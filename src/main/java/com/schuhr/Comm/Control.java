package com.schuhr.Comm;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;
import java.lang.Thread;

public class Control implements Runnable {

	List<Character> keysPushed = new ArrayList<Character>();

	private Boolean running = false;
	private Thread t;
	private String threadName = "";
	private Arduino arduino;

	public Control(String tName) {
		threadName = tName;
	}

	public void run() {
		try {

			arduino = new Arduino();
			arduino.Connect();

			int port = 11000;

			@SuppressWarnings("resource")
			DatagramSocket dsocket = new DatagramSocket(port);
			byte[] buffer = new byte[2048];

			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

			System.out.println("Packet reception starting...");
			while (running) {
				dsocket.receive(packet);

				String msg = new String(buffer, 0, packet.getLength());
				System.out.println(packet.getAddress().getHostName() + ": " + msg);

				//Process(msg, (msg.charAt(0) == '-') ? true : false);

				// Reset the length of the packet before reusing it.
				packet.setLength(buffer.length);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void Process(String message, Boolean remove) {
		char cmd;
		if (remove == true) {
			cmd = message.charAt(1);
			keysPushed.remove(cmd);
		} else {
			cmd = message.charAt(0);
			keysPushed.add(cmd);
		}

		switch (cmd) {
		case 'W':
			if (remove == true) {
				arduino.Stop();
			} else {
				if (!keysPushed.contains('S'))
					arduino.MoveForward();
			}
			break;
		case 'A':
			if (remove == true) {
				arduino.CenterWheels();
			} else {
				arduino.TurnLeft();
			}
			break;
		case 'S':
			if (remove == true) {
				arduino.Stop();
			} else {
				if (!keysPushed.contains('W'))
					arduino.MoveBackward();
			}
			break;
		case 'D':
			if (remove == true) {
				arduino.TurnRight();
			} else {
				arduino.CenterWheels();
			}
			break;
		}
	}
	
	public Boolean Start(){
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
			running = true;
			return true;
		}
		return false;
	}
	
	public void Stop(){
		running = false;
		System.out.println("Thread closing");
	}

}

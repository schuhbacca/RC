package com.schuhr.RCCar;
import com.schuhr.Comm.Control;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Control pb = new Control("thread1");
		pb.Start();

		do {
			// Don't do anything just wait for kill command
		} while (!System.console().readLine().equals("kill"));
		pb.Stop();
	}
}

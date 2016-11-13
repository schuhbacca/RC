package com.schuhr.Comm;


public class Arduino {

	//Link link;
	
	public Arduino(){
		
		//This is the connect stuff from version 1. Revert back if V2 doesn't work
		/*try {*/
/*			  Link link = Link.getDefaultInstance(); // 1
			  // Comment this row if you use just the default connection
			  link = getDigisparkConnection();

			  List<String> portList = link.getPortList(); // 2
			  if(portList != null && portList.size() > 0) {
			    String port = portList.get(0);
			    System.out.println("Connecting on port: " + port);
			    boolean connected = link.connect(port); // 3
			    System.out.println("Connected:" + connected);
			    Thread.sleep(2000); // 4
			    int power = IProtocol.HIGH;
			    while(true) {
			      System.out.println("Send power:" + power);
			      link.sendPowerPinSwitch(2, power); // 5
			      if(power == IProtocol.HIGH) {
			        power = IProtocol.LOW;
			      } else {
			        power = IProtocol.HIGH;
			      }
			      Thread.sleep(2000);
			    }
			  } else {
			    System.out.println("No port found!");
			  }

			} catch(Exception e) {
			  e.printStackTrace();
			}*/
	}
	
	public void Connect(){
		//Dont' know if this will actually work?
		//link = Links.getDefault(); //Returns the first serial port
	}
	
	public void MoveForward(){
		
	}
	
	public void MoveBackward(){
		
	}
	
	public void TurnLeft(){
		
	}
	
	public void TurnRight(){
		
	}
	
	public void CenterWheels(){
		
	}
	
	public void Stop(){
		
	}
}

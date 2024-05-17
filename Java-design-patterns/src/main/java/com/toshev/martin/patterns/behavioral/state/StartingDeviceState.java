package com.toshev.martin.patterns.behavioral.state;

public class StartingDeviceState extends DeviceState {

	public void restart() {
		System.out.println("Restarting.....");
		// restart device ...
	}
	
}

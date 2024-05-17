package com.toshev.martin.patterns.behavioral.state;

public class StoppedDeviceState extends DeviceState {

	public void restart() {
		System.out.println("Ignoring");
		// ignore ...
	}
	
}

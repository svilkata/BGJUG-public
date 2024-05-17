package com.toshev.martin.patterns.behavioral.statewithenum;



public class Device {

	private String serialNumber;

	private String shortName;

	private double price;

	private EnumDeviceState state;

	public Device(String serialNumber, String shortName, double price) {
		this.serialNumber = serialNumber;
		this.shortName = shortName;
		this.price = price;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public String getShortName() {
		return shortName;
	}

	public double getPrice() {
		return price;
	}

	public void setState(EnumDeviceState state) {
		this.state = state;
	}

	public EnumDeviceState getState() {
		return state;
	}

	public void restart() {
		state.restart();
	}

	public static void main(String[] args) {
		Device device = new Device("SN1", "device 1", 10.0);
		device.setState(EnumDeviceState.STARTING);
		device.restart();

		device.setState(EnumDeviceState.STOPPED);
		device.restart();
	}

}

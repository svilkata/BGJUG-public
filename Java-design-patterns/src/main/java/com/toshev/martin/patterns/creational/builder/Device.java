package com.toshev.martin.patterns.creational.builder;

public class Device {

    private String serialNumber;

    private String shortName;

    private double price;

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

	public static class Builder {

		private String serialNumber;

		private String shortName;

		private double price;

		public Builder serialNumber(String serialNumber) {
			this.serialNumber = serialNumber;
			return this;
		}

		public Builder shortName(String shortName) {
			this.shortName = shortName;
			return this;
		}

		public Builder price(double price) {
			this.price = price;
			return this;
		}

		public Device build() {
			return new Device(serialNumber, shortName, price);
		}

	}

    public Builder toNewBuilder() {
        return new Builder().serialNumber(serialNumber).shortName(shortName).price(price);
    }

    public static void main(String[] args) {
        Device device1 = new Device.Builder().serialNumber("SN123").shortName("router").price(1000d).build();
        System.out.println(device1.price);

        Device device2 = device1.toNewBuilder().price(2500d).build();
        System.out.println(device2.price);
    }
}

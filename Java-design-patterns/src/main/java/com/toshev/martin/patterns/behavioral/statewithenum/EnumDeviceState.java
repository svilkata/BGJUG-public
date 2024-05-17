package com.toshev.martin.patterns.behavioral.statewithenum;

public enum EnumDeviceState {
	STARTING{
		@Override
		public void restart() {
			System.out.println("Starting with enum...");
		}
	},
	STOPPED{
		@Override
		public void restart() {
			System.out.println("Ignoring with enum");
		}
	};

	public abstract void restart();
	
}

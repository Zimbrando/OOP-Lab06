package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends Exception {
	
	private static final long serialVersionUID = 2;
	private final double batteryLevel;
	private final double batteryRequired;
	
	public NotEnoughBatteryException(final double batteryLevel, final double batteryRequired) {
		super();
		this.batteryLevel = batteryLevel;
		this.batteryRequired = batteryRequired;
	}
	
	public String toString() {
		return "Not enough battery to move. Battery level: " + batteryLevel + " required: " + batteryRequired;
	}
	
	public String getMessage() {
		return this.toString();
	}
}

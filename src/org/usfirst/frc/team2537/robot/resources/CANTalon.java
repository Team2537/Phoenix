package org.usfirst.frc.team2537.robot.resources;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class CANTalon extends TalonSRX {
	private ControlMode controlMode = ControlMode.PercentOutput;
	
	public CANTalon(int deviceNumber) {
		super(deviceNumber);
	}
	
	public void setControlMode(ControlMode controlMode) {
		this.controlMode = controlMode;
	}
	
	public void set(double demand) {
		super.set(controlMode, demand);
	}
}

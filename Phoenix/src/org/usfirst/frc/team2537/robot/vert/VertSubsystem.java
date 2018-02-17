package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;
import org.usfirst.frc.team2537.robot.resources.CANTalon;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class VertSubsystem extends Subsystem {

	private CANTalon vertMotorOne;
	private CANTalon vertMotorTwo;
	private DigitalInput limitSwitch;
	double current;

	public VertSubsystem() { 
		vertMotorOne = new CANTalon(Ports.VERT_MOTOR_ONE);
		vertMotorTwo = new CANTalon(Ports.VERT_MOTOR_TWO);
		
		vertMotorTwo.setControlMode(ControlMode.Follower);
		vertMotorTwo.setInverted(true);
		
		limitSwitch = new DigitalInput(Ports.VERT_LIMIT_SWITCH);
	}

	public void initDefaultCommand() {

	}
	
	public void registerButtons() {
		HumanInput.registerWhileHeldCommand(HumanInput.vertRaiseButton, new VertUpCommand());
		HumanInput.registerWhileHeldCommand(HumanInput.vertLowerButton, new VertDownCommand());

	}

	public void setVertMotors(double speed) {
		// CHECK THAT THESE ARE CORRECT BEFORE STARTING TO AVOID DESTROYING GEARBOX
		vertMotorOne.set(speed);
	}
	
	public boolean getLimitSwitch() {
		return limitSwitch.get();
	}

}

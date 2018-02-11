package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class VertSubsystem extends Subsystem {

	private Talon vertMotorOne;
	private Talon vertMotorTwo;
	private DigitalInput limitSwitch;
	double current;

	public VertSubsystem() { 
		vertMotorOne = new Talon(Ports.VERT_MOTOR_ONE);
		vertMotorTwo = new Talon(Ports.VERT_MOTOR_TWO);
		limitSwitch = new DigitalInput(Ports.VERT_LIMIT_SWITCH);
	}

	public void initDefaultCommand() {

	}
	
	public void registerButtons() {
		HumanInput.registerWhileHeldCommand(HumanInput.raiseButton, new VertUpCommand());
		HumanInput.registerWhileHeldCommand(HumanInput.lowerButton, new VertDownCommand());

	}

	public void setVertMotors(double speed) {
		// CHECK THAT THESE ARE CORRECT BEFORE STARTING TO AVOID DESTROYING GEARBOX
		vertMotorOne.set(speed);
		vertMotorTwo.set(speed);
	}
	
	public boolean getLimitSwitch() {
		return limitSwitch.get();
	}

}

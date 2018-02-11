package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class VertSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.


	private Encoder vertEnc;
	private Talon vertMotorOne;
	private Talon vertMotorTwo;
	private DigitalInput limitSwitch;
	double current;

	public VertSubsystem() { 
		vertEnc = new Encoder(Ports.VERT_ENC_TRIGGER, Ports.VERT_ENC_ECHO, false, Encoder.EncodingType.k4X);
		vertMotorOne = new Talon(Ports.VERT_MOTOR_ONE);
		vertMotorTwo = new Talon(Ports.VERT_MOTOR_TWO);
		limitSwitch = new DigitalInput(Ports.VERT_LIMIT_SWITCH);
	}

	public void initDefaultCommand() {

	}
	
	//makes sure command works when button held
	public void registerButtons() {
		HumanInput.registerWhileHeldCommand(HumanInput.raiseButton, new VertUpCommand());
		HumanInput.registerWhileHeldCommand(HumanInput.lowerButton, new VertDownCommand());

	}

	//receives distance robot travels with encoders
	public int getDistance() {
		return vertEnc.get();
	}

	//sets speed of vertMotors
	public void setVertMotors(double speed) {
		vertMotorOne.set(speed);
		vertMotorTwo.set(speed);
	}
	
	
	public boolean getLimitSwitch() {
		return limitSwitch.get();
	}

}

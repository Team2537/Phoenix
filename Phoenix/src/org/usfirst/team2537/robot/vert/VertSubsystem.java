package org.usfirst.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;
import org.usfirst.frc.team2537.robot.resources.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class VertSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private Encoder vertEncoder;
	private CANTalon vertMotor;

	public VertSubsystem() {
		// vertEncoder = new Encoder(Ports.ENCODER_INPUT1, Ports.ENCODER_INPUT2, false,
		// Encoder.EncodingType.k4X);
		vertMotor = new CANTalon(Ports.VERT_MOTOR);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void registerButtons() {
		HumanInput.registerWhenPressedCommand(HumanInput.raiseButton, new VertUpCommand(false));
		HumanInput.registerWhenPressedCommand(HumanInput.lowerButton, new VertUpCommand(true));
	}

	public int getEncoder() {
		return vertEncoder.get();
	}




//these functions are nice and do things like stop and the start the motor :) (also a print line for testing)
	public void startMotor() {
		vertMotor.set(.3);
		System.out.println(vertMotor.getMotorOutputPercent());
	}
	
	//called in VertCommand end :(

	public void stopMotor() {
		vertMotor.set(0);
	}

}

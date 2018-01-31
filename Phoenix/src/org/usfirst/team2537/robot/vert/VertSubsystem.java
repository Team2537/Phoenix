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

	private Encoder vertEnc;
	private CANTalon vertMotor;

	public VertSubsystem() {
		vertEnc = new Encoder(Ports.VERT_ENC_A, Ports.VERT_ENC_B, false, Encoder.EncodingType.k4X);
		vertMotor = new CANTalon(Ports.VERT_MOTOR);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void registerButtons() {
		HumanInput.registerWhenPressedCommand(HumanInput.raiseButton, new VertUpCommand(true));
		HumanInput.registerWhenPressedCommand(HumanInput.lowerButton, new VertDownCommand(true));
	}

	public int getDistance() {
		vertEnc.reset();
		return vertEnc.get();
	}
	
	//these functions are nice and do things like stop and the start the motor :) (also a print line for testing)
	public void startMotor(double speed) {
		vertMotor.set(speed);
	}
	
	//called in VertCommand end

	public void stopMotor() {
		vertMotor.set(0);
	}

	public void moveUp(double motorValue) {
		vertMotor.set(motorValue);
	}
	
	public void moveDown(double motorValue) {
		vertMotor.set(motorValue);
	}
}

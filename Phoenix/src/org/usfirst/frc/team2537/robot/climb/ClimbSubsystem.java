package org.usfirst.frc.team2537.robot.climb;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimbSubsystem extends Subsystem {

	private Talon climbMotorOne;
	private Talon climbMotorTwo;
	private Talon climbMotorThree;
//	private DigitalInput limitSwitch;
	// private Encoder climbEnc;
	
	public double speed = 0.5;

	
	public ClimbSubsystem() {
		
		climbMotorOne = new Talon(Ports.CLIMB_MOTOR_ONE);
		climbMotorTwo = new Talon(Ports.CLIMB_MOTOR_TWO);
		climbMotorThree = new Talon(Ports.CLIMB_MOTOR_THREE);
//		limitSwitch = new DigitalInput(Ports.LIMIT_SWITCH);
	//	climbEnc = new Encoder(Ports.ENCODER_A, Ports.ENCODER_B, false, Encoder.EncodingType.k4X);		
	}

	@Override
	public void initDefaultCommand() {

	}

	public void registerButtons() {
		HumanInput.registerWhenPressedCommand(HumanInput.climbOnButton, new ClimbCommand());
//		HumanInput.registerWhenPressedCommand(HumanInput.climbOffButton, new ClimbKillCommand());

	}

	public void motorOneActivation() {

		climbMotorOne.set(speed);

	}

	public void motorTwoActivation() {

		climbMotorTwo.set(speed);

	}

	public void motorThreeActivation() {

		climbMotorThree.set(speed);

	}

	public void megaMotorActivation() {
		climbMotorOne.set(speed);
		climbMotorTwo.set(speed);
		climbMotorThree.set(speed);
	}

	public void ultraDeath() {
		climbMotorOne.set(0);
		climbMotorTwo.set(0);
		climbMotorThree.set(0);

	}
	
//	public boolean getLimitSwitch(){
//		return limitSwitch.get();
//	}
}

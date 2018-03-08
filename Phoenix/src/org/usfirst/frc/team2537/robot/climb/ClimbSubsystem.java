package org.usfirst.frc.team2537.robot.climb;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimbSubsystem extends Subsystem {

	private Talon climbMotorOne;
	private Talon climbMotorTwo;
	private Talon climbMotorThree;
	
	public static final double MAX_CURRENT = 131; //TODO: test for the max current value (131 is the listed CIM stall current)
	
	public ClimbSubsystem() {
		
		climbMotorOne = new Talon(Ports.CLIMB_MOTOR_ONE);
		climbMotorTwo = new Talon(Ports.CLIMB_MOTOR_TWO);
		climbMotorThree = new Talon(Ports.CLIMB_MOTOR_THREE);
	}

	@Override
	public void initDefaultCommand() {
		
	}

	public void registerButtons() {
		HumanInput.registerWhenPressedCommand(HumanInput.climbOnButton, new ClimbCommand());
		HumanInput.registerWhenPressedCommand(HumanInput.climbOffButton, new ClimbKillCommand());
		HumanInput.registerWhenPressedCommand(HumanInput.climbOverrideKeyOne, new ClimbOverrideCommand());
	}

	public void setClimbMotors(double speed) {
		// CHECK THAT THESE ARE CORRECT BEFORE STARTING TO AVOID DESTROYING GEARBOX
		climbMotorOne.set(speed);
		climbMotorTwo.set(speed);
		climbMotorThree.set(speed);
	}

//	public double getCurrentClimbMotorOne() {
//		return Robot.pdp.getCurrent(Ports.CLIMB_MOTOR_ONE_PDP);
//	}
//	public double getCurrentClimbMotorTwo() {
//		return Robot.pdp.getCurrent(Ports.CLIMB_MOTOR_TWO_PDP);
//	}
//	public double getCurrentClimbMotorThree() {
//		return Robot.pdp.getCurrent(Ports.CLIMB_MOTOR_THREE_PDP);
//	}
	
	public boolean climberOverridden() {
		return HumanInput.climbOverrideKeyOne.get() && HumanInput.climbOverrideKeyTwo.get();
	}
	
}

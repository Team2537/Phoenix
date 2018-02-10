package org.usfirst.frc.team2537.robot.climb;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
	
	/**
	 * 
	 * @author Space RAIDers
	 *
	 *
	 */
public class ClimbSubsystem extends Subsystem {

	private Talon climbMotorOne;
	private Talon climbMotorTwo;
	private Talon climbMotorThree;
	public static final double MAX_CURRENT = 35; //TODO: test for the max current value
	public ClimbSubsystem() {
		
		climbMotorOne = new Talon(Ports.CLIMB_MOTOR_ONE);
		climbMotorTwo = new Talon(Ports.CLIMB_MOTOR_TWO);
		climbMotorThree = new Talon(Ports.CLIMB_MOTOR_THREE);
	
	}
	/**
	 *  there is current-ly nothing here ;)
	 *  shocking, isn't it?
	 */
	@Override
	public void initDefaultCommand() {
		
	}
	/**
	 * this means that pressing the climbOn button will start the climb 
	 * and pressing the climbOff button will stop the climb
	 */
	public void registerButtons() {
		HumanInput.registerWhenPressedCommand(HumanInput.climbOnButton, new ClimbCommand());
		HumanInput.registerWhenPressedCommand(HumanInput.climbOffButton, new ClimbKillCommand());
	}

	/**
	 * 
	 * this method turns all three motors on
	 */
	public void megaMotorActivation(double speed) {
		climbMotorOne.set(speed);
		climbMotorTwo.set(speed);
		climbMotorThree.set(speed);
	}
	/**
	 * This method shuts off all three motors
	 */
	public void ultraDeath() {
		climbMotorOne.set(0);
		climbMotorTwo.set(0);
		climbMotorThree.set(0);

	}
	
	/**
	 * these methods return the current for each of the motors
	 * @return current
	 */
	public double getCurrentOne() {
		return Robot.PDP.getCurrent(Ports.CLIMB_MOTOR_ONE_PDP_CHANNEL);
	}
	public double getCurrentTwo() {
		return Robot.PDP.getCurrent(Ports.CLIMB_MOTOR_TWO_PDP_CHANNEL);
	}
	public double getCurrentThree() {
		return Robot.PDP.getCurrent(Ports.CLIMB_MOTOR_THREE_PDP_CHANNEL);
	}
	
	
}

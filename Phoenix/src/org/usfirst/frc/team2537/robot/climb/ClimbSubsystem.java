package org.usfirst.frc.team2537.robot.climb;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.hal.PDPJNI;
	
	/**
	 * 
	 * @author Space RAIDers
	 *
	 */
public class ClimbSubsystem extends Subsystem {

	private Talon climbMotorOne;
	private Talon climbMotorTwo;
	private Talon climbMotorThree;
	private DigitalInput limitSwitch;
	public static final double MAX_CURRENT = 1337; //TODO: test for the max current value
	public ClimbSubsystem() {
		
		climbMotorOne = new Talon(Ports.CLIMB_MOTOR_ONE);
		climbMotorTwo = new Talon(Ports.CLIMB_MOTOR_TWO);
		climbMotorThree = new Talon(Ports.CLIMB_MOTOR_THREE);
		limitSwitch = new DigitalInput(Ports.LIMIT_SWITCH);
	}
	/**
	 * 
	 */
	@Override
	public void initDefaultCommand() {
		
	}
	/**
	 * 
	 */
	public void registerButtons() {
		HumanInput.registerWhenPressedCommand(HumanInput.climbOnButton, new ClimbCommand());
		HumanInput.climbOffButton.cancelWhenPressed(getCurrentCommand());
	}

	/**
	 * 
	 * @param speed
	 */
	public void megaMotorActivation(double speed) {
		climbMotorOne.set(speed);
		climbMotorTwo.set(speed);
		climbMotorThree.set(speed);
	}
	/**
	 * This method is the kill command
	 */
	public void ultraDeath() {
		climbMotorOne.set(0);
		climbMotorTwo.set(0);
		climbMotorThree.set(0);

	}
	/**
	 * This method gets the limit switch
	 */
	public boolean getLimitSwitch() {
		return limitSwitch.get();
	}
	/**
	 * 
	 * @return current
	 */
	public double getCurrentOne() {
		return PDPJNI.getPDPChannelCurrent((byte) 0, 0);
	}
	public double getCurrentTwo() {
		return PDPJNI.getPDPChannelCurrent((byte) 1,0);
	}
	public double getCurrentThree() {
		return PDPJNI.getPDPChannelCurrent((byte)2,0);
	}
	
	public boolean limitSwitchOverridden() {
		return HumanInput.overrideKeyOne.get() && HumanInput.overrideKeyTwo.get() && HumanInput.overrideKeyThree.get();
	}
}

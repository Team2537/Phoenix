package org.usfirst.frc.team2537.robot.climb;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
	
	/**
	 * 
	 * @author Space RAIDers
	 *
	 */
public class ClimbSubsystem extends Subsystem {

	private Talon climbMotorOne;
	private Talon climbMotorTwo;
	private Talon climbMotorThree;
	
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
	}

	public void setClimbMotors(double speed) {
		// MAKE SURE THESE ARE SET CORRECTLY TO AVOID DESTROYING GEARBOX
		climbMotorOne.set(speed);
		climbMotorTwo.set(-speed);
		climbMotorThree.set(speed);
	}
	
	public boolean limitSwitchOverridden() {
		return HumanInput.overrideKeyOne.get() && HumanInput.overrideKeyTwo.get() && HumanInput.overrideKeyThree.get();
	}
}

package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VertUpCommand extends Command {
	
	private static final int ULTRASONIC_DISTANCE = 5; // 5 inches
	private static final int AMP_LIMIT = 5; //5 amps TBD


	
	public VertUpCommand() {
		requires(Robot.vertSys);
		
	}

	protected void initialize() {
		
	}

	protected void execute() {
		// stops bot when it's 5 inches or closer to object
		if (Robot.vertSys.getUltrasonic() <= ULTRASONIC_DISTANCE) {
			Robot.vertSys.setVertMotors(0);
		} else {
			Robot.vertSys.setVertMotors(-0.8);
		}	
		//stops bot when it exceeds amp limit for channel 5
		if (Robot.vertSys.getCurrentOne() >= AMP_LIMIT) {
			Robot.vertSys.setVertMotors(0);
		} else {
			Robot.vertSys.setVertMotors(-0.8);
		}	
		//stops bot when it exceeds amp limit for channel 4
		if (Robot.vertSys.getCurrentTwo() >= AMP_LIMIT) {
			Robot.vertSys.setVertMotors(0);
		} else {
			Robot.vertSys.setVertMotors(-0.8);
		}	
		
		
	}

	protected boolean isFinished() {

		return false;
		
	}

	protected void end() {
		Robot.vertSys.setVertMotors(0);
	}

	protected void interrupted() {
		Robot.vertSys.setVertMotors(0);
	}
}

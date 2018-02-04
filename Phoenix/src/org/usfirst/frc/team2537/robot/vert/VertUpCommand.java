package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VertUpCommand extends Command {
	
	private static final int ULTRASONIC_DISTANCE = 3; // 5 inches


	
	public VertUpCommand() {
		requires(Robot.vertSys);
		
	}

	protected void initialize() {
		if (Robot.vertSys.getUltrasonic() > ULTRASONIC_DISTANCE) {
			Robot.vertSys.setVertMotors(0);
		} else {
			Robot.vertSys.setVertMotors(-0.8);
		}	
		}

	protected void execute() {
		
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

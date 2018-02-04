package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class VertDownCommand extends Command {

	private static final int ULTRASONIC_DISTANCE = 3; // 5 inches
	private static final int AMP_LIMIT = 5;
	public VertDownCommand() {
		requires(Robot.vertSys);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		if (Robot.vertSys.getUltrasonic() < ULTRASONIC_DISTANCE) {
			Robot.vertSys.setVertMotors(0);
		} else {
			Robot.vertSys.setVertMotors(-0.8);
		}
		if (Robot.vertSys.getAmperageOne() >= AMP_LIMIT) {
			Robot.vertSys.setVertMotors(0);
		} else {
			Robot.vertSys.setVertMotors(-0.8);
		}	
		if (Robot.vertSys.getAmperageTwo() >= AMP_LIMIT) {
			Robot.vertSys.setVertMotors(0);
		} else {
			Robot.vertSys.setVertMotors(-0.8);
		}	
		
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.vertSys.setVertMotors(0);
	}

	@Override
	protected void interrupted() {
		Robot.vertSys.setVertMotors(0);
	}

}

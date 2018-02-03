package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VertUpCommand extends Command {

	
	public VertUpCommand() {
		requires(Robot.vertSys);
		
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.vertSys.setVertMotors(0.8);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		Robot.vertSys.getAmperage();
		Robot.vertSys.getUltrasonic();
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.vertSys.setVertMotors(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.vertSys.setVertMotors(0);
	}
}

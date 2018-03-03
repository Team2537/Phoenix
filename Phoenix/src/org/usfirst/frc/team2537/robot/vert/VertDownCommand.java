package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class VertDownCommand extends Command {

	private static final int AMP_LIMIT = 5;  //5 amps HECKKA TBD
	
	public VertDownCommand() {
		requires(Robot.vertSys);

	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		//stops bot when it exceeds amp limit for channel 5
		if (Robot.vertSys.getCurrentOne() >= AMP_LIMIT) {
			Robot.vertSys.setVertMotors(0);
		} else {
			Robot.vertSys.setVertMotors(-Robot.vertSys.targetVelocity);
		}	
		//stops bot when it exceeds amp limit for channel 4
		if (Robot.vertSys.getCurrentTwo() >= AMP_LIMIT) {
			Robot.vertSys.setVertMotors(0);
		} else {
			Robot.vertSys.setVertMotors(-Robot.vertSys.targetVelocity);
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

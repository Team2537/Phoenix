package org.usfirst.frc.team2537.robot.climb;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbKillCommand extends Command {
	
	public ClimbKillCommand() {
		requires(Robot.climbSys);
	}
	
	@Override
	protected void initialize() {
		Robot.climbSys.setClimbMotors(0);
		
	}
	
	@Override
	protected void execute() {
		Robot.climbSys.setClimbMotors(0);
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void end() {
		Robot.climbSys.setClimbMotors(0);
		
	}
	
	@Override
	protected void interrupted() {
		Robot.climbSys.setClimbMotors(0);
		
	}

}

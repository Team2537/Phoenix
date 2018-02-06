package org.usfirst.frc.team2537.robot.climb;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbKillCommand extends Command {
	
	public ClimbKillCommand() {
		requires(Robot.climbSys);
	}
	
	@Override
	protected void initialize() {
		Robot.climbSys.ultraDeath();
		
	}
	
	@Override
	protected void execute() {
		Robot.climbSys.ultraDeath();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	protected void end() {
		Robot.climbSys.ultraDeath();
		
	}
	
	@Override
	protected void interrupted() {
		Robot.climbSys.ultraDeath();
		
	}

}

package org.usfirst.frc.team2537.robot.climb;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbKillCommand extends Command {
	
	public ClimbKillCommand() {
		requires(Robot.climbSys);
	}

	protected void initialize() {

		Robot.climbSys.ultraDeath();

	}

	protected void execute() {

	}

	@Override
	protected boolean isFinished() {

		return true;
	}

	protected void end() {
		Robot.climbSys.ultraDeath();
	}

	protected void interrupted() {
		Robot.climbSys.ultraDeath();

	}

}

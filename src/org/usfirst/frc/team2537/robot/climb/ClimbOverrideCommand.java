package org.usfirst.frc.team2537.robot.climb;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbOverrideCommand extends Command {
	

	public ClimbOverrideCommand() {
		requires(Robot.climbSys);
	}

	@Override
	protected void initialize() {
			Robot.climbSys.setClimbMotors(1);
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return false;

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

package org.usfirst.frc.team2537.robot.climb;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbOverrideCommand extends Command {

	public ClimbOverrideCommand() {
		requires(Robot.climbSys);
	}

	@Override
	protected void initialize() {
		if (Robot.climbSys.climberOverridden()) {
			Robot.climbSys.setClimbMotors(0.85);
		} else {
			Robot.climbSys.setClimbMotors(0);
		}

	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return false;/* (Robot.climbSys.getCurrentClimbMotorOne() > ClimbSubsystem.MAX_CURRENT)
				|| (Robot.climbSys.getCurrentClimbMotorTwo() > ClimbSubsystem.MAX_CURRENT)
				|| (Robot.climbSys.getCurrentClimbMotorThree() > ClimbSubsystem.MAX_CURRENT);*/

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

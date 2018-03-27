package org.usfirst.frc.team2537.robot.climb;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbCommand extends Command {

	private static final int BUTTON_LOCK = 105000; // 1:45 fron teleop starts until we can climb

	private static final double SPEED = 1;

	public ClimbCommand() {
		requires(Robot.climbSys);
	}

	protected void initialize() {
		if (System.currentTimeMillis() - Robot.startTime >= BUTTON_LOCK) {
			Robot.climbSys.setClimbMotors(SPEED);
		} else {
			Robot.climbSys.setClimbMotors(0);
		}

	}

	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.climbSys.setClimbMotors(0);
	}

	protected void interrupted() {
		Robot.climbSys.setClimbMotors(0);
	}
}
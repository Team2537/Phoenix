package org.usfirst.frc.team2537.robot.climb;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbCommand extends Command {

	private static final int BUTTON_LOCK = 105000; // 1:45 fron teleop starts until we can climb

	private double climbSpeed;

	public ClimbCommand(double speed) {
		requires(Robot.climbSys);
		this.climbSpeed = speed;
	}

	protected void initialize() {
		if (System.currentTimeMillis() - Robot.startTime >= BUTTON_LOCK) {
			Robot.climbSys.setClimbMotors(climbSpeed);
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
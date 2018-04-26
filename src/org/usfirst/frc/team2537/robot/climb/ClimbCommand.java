package org.usfirst.frc.team2537.robot.climb;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbCommand extends Command {

	private static final int BUTTON_LOCK = 105000; // 1:45 fron teleop starts until we can climb

	private double minPower;
	private double maxPower;
	private double deltaTime;
	private double startTime;

	public ClimbCommand(double minPower, double maxPower, double time) {
		requires(Robot.climbSys);
		this.minPower = minPower;
		this.maxPower = maxPower;
		this.deltaTime = time;
	}

	protected void initialize() {
		if (System.currentTimeMillis() - Robot.startTime >= BUTTON_LOCK) {
			Robot.climbSys.setClimbMotors(minPower);
		} else {
			Robot.climbSys.setClimbMotors(0);
		}
		startTime = System.currentTimeMillis() / 1000d;
	}

	protected void execute() {
		Robot.climbSys.setClimbMotors(Math.min(((maxPower - minPower)/deltaTime) * ((System.currentTimeMillis()/1000d) - startTime) + minPower, maxPower));
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
package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.drive.Motor;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Hopefully shouldn't be used more than on Sunday.
 * numSeconds=number of seconds to go forward
 */
public class ShittyAutoCommand extends Command {
	int numSeconds;
	double timeStarted;

	public ShittyAutoCommand(int numSeconds) {
		this.numSeconds = numSeconds;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		timeStarted = System.currentTimeMillis();
		Robot.driveSys.setMotors(1, Motor.ALL);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return System.currentTimeMillis() - timeStarted > numSeconds * 1000;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveSys.setMotors(0, Motor.ALL);
	}
}
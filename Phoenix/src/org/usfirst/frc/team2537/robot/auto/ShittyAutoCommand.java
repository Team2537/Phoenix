package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.drive.Motor;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Hopefully shouldn't be used more than on Sunday.
 * numSeconds=number of seconds to go forward
 */
public class ShittyAutoCommand extends Command {
	double numSeconds;
	double timeStarted;
	boolean goBackwards=false;
	public ShittyAutoCommand(double numSeconds) {
		this.numSeconds = numSeconds;
	}
	
	public ShittyAutoCommand(double numSeconds, boolean goBackwards) {
		this.numSeconds = numSeconds;
		this.goBackwards=goBackwards;
	}
	

	// Called just before this Command runs the first time
	protected void initialize() {
		timeStarted = System.currentTimeMillis();
		Robot.driveSys.setMode(ControlMode.PercentOutput);
		if (goBackwards)
			Robot.driveSys.setMotors(-.420, Motor.ALL);
		else
			Robot.driveSys.setMotors(.420, Motor.ALL);
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
package org.usfirst.frc.team2537.robot.auto.vision;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Should be constantly executed during auto, adds most recent serial input to buffer
 */
public class ReadSerialCommand extends Command {
	protected void execute() {
		Robot.visionSerial.addToBuffer();
	}

	protected boolean isFinished() {
		return false;
	}
}

package org.usfirst.frc.team2537.robot.vision;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Should be in TeleopPeriodic, adds most recent serial input to buffer
 */
public class ReadSerialCommand extends Command {
	static long lastTimePrinted = 0;

	public ReadSerialCommand() {
		requires(Robot.serialSys);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run

	protected void execute() {
		Robot.serialSys.addToBuffer();
		Target[] currentPacket = Robot.serialSys.getVisionPacket();
		if (Robot.serialSys.DEBUG && System.currentTimeMillis() - lastTimePrinted >= 1000) {
			System.out.println("number of targets: " + currentPacket.length);
			for (int i = 0; i < currentPacket.length; i++) {
				System.out.println("current target number: " + i);
				System.out.println("bottom left point: " + currentPacket[i].getBoundingBox()[0].getX(CoordinateSystems.CARTESIAN_NORMALIZED) + ","
						+ currentPacket[i].getBoundingBox()[0].getY(CoordinateSystems.CARTESIAN_NORMALIZED));
				System.out.println("top right point: " + currentPacket[i].getBoundingBox()[1].getX(CoordinateSystems.CARTESIAN_NORMALIZED) + ","
						+ currentPacket[i].getBoundingBox()[1].getY(CoordinateSystems.CARTESIAN_NORMALIZED));
			}
			lastTimePrinted = System.currentTimeMillis();
		}
		// Robot.serialSys.sendVisionPacket(Robot.serialSys.getVisionPacket());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}

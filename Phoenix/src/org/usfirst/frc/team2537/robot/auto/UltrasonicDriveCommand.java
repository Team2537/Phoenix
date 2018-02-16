package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.Robot;

public class UltrasonicDriveCommand extends DriveStraightTemplate {
	@Override
	protected double getRemainingInches() {
		return Robot.driveSys.getEncoderDistance();
	}
}
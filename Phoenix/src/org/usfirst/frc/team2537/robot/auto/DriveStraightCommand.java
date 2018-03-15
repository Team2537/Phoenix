package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.Robot;

public class DriveStraightCommand extends DriveStraightTemplate {

	private final double targetInches;
	
	public DriveStraightCommand(double targetInches, double defaultPercentOutput) {
		super(defaultPercentOutput);
		this.targetInches = targetInches;
	}
	
	public DriveStraightCommand(double targetInches) {
		super();
		this.targetInches = targetInches;
	}
	
	@Override
	protected double getRemainingInches() {
		return targetInches - Robot.driveSys.getEncoderDistance();
	}

}

package org.usfirst.frc.team2537.robot.ramp;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RampLowerCommand extends Command {

	public RampLowerCommand() {
		requires(Robot.rampSys);
	}
	@Override 
	protected void initialize() {
		
	}
	
	@Override 
	protected void execute() {
		Robot.rampSys.lowerRamp(-.5);
	}
	
	@Override
	protected boolean isFinished() {
		if (Robot.rampSys.getLeftEncoderRange()>100) {
			return true;
		}
		return false;
	}
	
	@Override 
	protected void end() {
		Robot.rampSys.setRampMotors(0, 0);
		
	}
	
	@Override 
	protected void interrupted() {
		
	}

}

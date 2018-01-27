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
	protected void execute() {
		Robot.rampSys.lowerRamp();
		
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override 
	protected void end() {
		
	}
	
	@Override 
	protected void interrupted() {
		
	}

}

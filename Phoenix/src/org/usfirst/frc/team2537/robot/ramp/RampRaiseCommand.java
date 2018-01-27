package org.usfirst.frc.team2537.robot.ramp;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RampRaiseCommand extends Command {

	public RampRaiseCommand() {
		requires(Robot.rampSys);
	}
	@Override 
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		Robot.rampSys.raiseRamp();
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

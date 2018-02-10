package org.usfirst.frc.team2537.robot.ramp;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CloseRampCommand extends Command {
	
	public CloseRampCommand() {
		requires(Robot.rampSys);
	}
	
	@Override
	protected void initialize() {
		Robot.rampSys.raiseRampServo();
	}
	
	@Override
	protected void execute() {
		
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

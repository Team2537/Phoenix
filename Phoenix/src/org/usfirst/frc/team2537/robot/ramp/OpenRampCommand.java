package org.usfirst.frc.team2537.robot.ramp;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OpenRampCommand extends Command {
	
	
	public OpenRampCommand() {
		requires(Robot.rampSys);
	}
	
	@Override
	protected void initialize() {
		System.out.println("trying to lower");
	}
	
	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void end() {
		Robot.rampSys.isOpen = true;
		Robot.rampSys.lowerRampServo();
	}
	
	@Override
	protected void interrupted() {
		Robot.rampSys.stopServo();
		
	}

}

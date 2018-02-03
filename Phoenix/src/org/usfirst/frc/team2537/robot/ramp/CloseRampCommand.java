package org.usfirst.frc.team2537.robot.ramp;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CloseRampCommand extends Command {
	
	private long startTime;
	private static final int WAIT_TIME = 500; // .5 seconds
	
	public CloseRampCommand() {
		requires(Robot.rampSys);
	}
	
	@Override
	protected void initialize() {
		startTime = System.currentTimeMillis();
		Robot.rampSys.lowerRampSoleOff();
		Robot.rampSys.raiseRampSoleOff();
		Robot.rampSys.raiseRampServo();
		Robot.rampSys.raiseRampSoleOn();
	}
	
	@Override
	protected void execute() {
		if (System.currentTimeMillis() - startTime > WAIT_TIME)
			Robot.rampSys.raiseRampSoleOff();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		Robot.rampSys.lowerRampSoleOff();
		Robot.rampSys.raiseRampSoleOff();
		System.out.println("CloseRampCommand just ended. This should not happen...");
	}
	
	@Override
	protected void interrupted() {
		Robot.rampSys.lowerRampSoleOff();
		Robot.rampSys.raiseRampSoleOff();
	}

}

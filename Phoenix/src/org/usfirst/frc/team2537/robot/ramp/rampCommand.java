package org.usfirst.frc.team2537.robot.ramp;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class rampCommand extends Command {
	
	private long startTime;
	
	public rampCommand() {
		requires(Robot.rampSys);
	}
	
	@Override
	protected void initialize() {
		startTime = System.currentTimeMillis();
		Robot.rampSys.openLatch();
		
	}
	
	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		if(System.currentTimeMillis() - startTime > 200) {
			return true;
		} else {
			return false;
		}
		
	}
	
	@Override
	protected void end() {
		Robot.rampSys.openRampPiston();
		
	}
	
	@Override
	protected void interrupted() {
		end();
		
	}

}

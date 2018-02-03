package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CubeFlipUpCommand extends Command {
	
	private long startTime;
	private static final int WAIT_TIME = 1000; // 1 second
	
	public CubeFlipUpCommand() {
		requires(Robot.cubeSys);
	}
	
	protected void initialize() {
		startTime = System.currentTimeMillis();
		Robot.cubeSys.closeFlipper();
	}
	
	protected void execute() {
		
	}

	protected boolean isFinished() {
		return (System.currentTimeMillis() - startTime > WAIT_TIME);
	}
	
	protected void end() {
		Robot.cubeSys.stopCloseFlipper();
	}
	
	protected void interrupted() {
		Robot.cubeSys.stopCloseFlipper();
	}

}

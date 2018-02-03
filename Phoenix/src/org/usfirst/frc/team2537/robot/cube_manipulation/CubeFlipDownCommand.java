package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.command.Command;

public class CubeFlipDownCommand extends Command {
	
	private long startTime;
	private static final int WAIT_TIME = 1000; // 1 second
	
	/**
	 * tells that the command requires cubeSys	
	 */
	public CubeFlipDownCommand() {
		requires(Robot.cubeSys);
	}
	
	
	/**
	 * when this command is initialized, pressure is applied so that the claw opens
	 */
	@Override
	protected void initialize() {
		startTime = System.currentTimeMillis();
		Robot.cubeSys.openFlipper();;
	}
	
	@Override
	protected void execute() {
		
	}
	
	/**
	 * 	if the button is being pressed, the command keeps on running, and when it is released,
		it continues to else, and returns true, which indicates that the command is finished
	 */
	@Override
	protected boolean isFinished() {
		return (System.currentTimeMillis() - startTime > WAIT_TIME);
	}
	
	/**
	 * when the command ends, the piston stops applying pressure
	 */
	@Override
	protected void end() {		
		Robot.cubeSys.stopOpenFlipper();;
		
	}
	
	/**
	 * when the command is interrupted, the piston stops applying pressure
	 */
	@Override
	protected void interrupted() {
		Robot.cubeSys.stopOpenFlipper();
	}

}

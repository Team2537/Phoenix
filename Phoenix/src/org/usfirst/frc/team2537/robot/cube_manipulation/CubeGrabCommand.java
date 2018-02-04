package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.command.Command;

public class CubeGrabCommand extends Command {
	private long startTime;
	private static final int WAIT_TIME = 1000; // 1 second
	
	/**
	 * says that the command requires cubeSys
	 */
	public CubeGrabCommand() {
		requires(Robot.cubeSys);
	}
	
	/**
	 * when the command is initialized, it starts to apply pressure and closes the claw
	 */
	protected void initialize() {
		startTime = System.currentTimeMillis();
		Robot.cubeSys.openGrabPiston();
	}
	
	protected void execute() {
		
	}
	
	/**
	 * if the button is released, the command is finished
	 */
	protected boolean isFinished() {
		return (System.currentTimeMillis() - startTime > WAIT_TIME);
	}
	
	/**
	 * when the command ends, pressure stops being applied
	 */
	protected void end() {
		Robot.cubeSys.stopOpenGrabPiston();
	}
	
	/**
	 * if the command is interrupted, pressure stops being applied
	 */
	protected void interrupted() {
		Robot.cubeSys.stopOpenGrabPiston();
	}
}

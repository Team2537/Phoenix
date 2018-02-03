package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.command.Command;

public class CubeStartCommand extends Command {
	
	/**
	 * tells that the command requires cubeSys	
	 */
	public CubeStartCommand() {
		requires(Robot.cubeSys);
	}
	
	
	/**
	 * when this command is initialized, pressure is applied so that the claw opens
	 */
	@Override
	protected void initialize() {
		Robot.cubeSys.openStartPiston();
		
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

		if(HumanInput.cubeFlipperReleaseButton.get()) {
			return false;
		}
		else return true;
	}
	
	/**
	 * when the command ends, the piston stops applying pressure
	 */
	@Override
	protected void end() {		
		Robot.cubeSys.closeStartPiston();
		
	}
	
	/**
	 * when the command is interrupted, the piston stops applying pressure
	 */
	@Override
	protected void interrupted() {
		Robot.cubeSys.closeStartPiston();
		
	}

}

package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CubeStartCommand extends Command {
	
	public CubeStartCommand() {
		requires(Robot.cubeSys);
	}
	
	@Override
	protected void initialize() {
		Robot.cubeSys.openStartPiston();
		
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
		Robot.cubeSys.closeStartPiston();
		
	}
	
	@Override
	protected void interrupted() {
		Robot.cubeSys.closeStartPiston();
		
	}

}

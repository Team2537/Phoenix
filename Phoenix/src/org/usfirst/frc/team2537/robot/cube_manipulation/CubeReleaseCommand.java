package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CubeReleaseCommand extends Command {
	
	public CubeReleaseCommand() {
		requires(Robot.cubeSys);
	}
	
	protected void initialize() {
		
	}
	protected void execute() {
		Robot.cubeSys.endCompression();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}
}

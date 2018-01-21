package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.command.Command;

public class CubeGrabCommand extends Command {
	
	public CubeGrabCommand() {
		requires(Robot.cubeSys);
	}
	
	protected void initialize() {
		
	}
	protected void execute() {
		Robot.cubeSys.startCompression();
	}

	protected boolean isFinished() {
		if(HumanInput.clawGrabButton.get()){
			return false;
		}
		else return true;
	}

	protected void end() {
		Robot.cubeSys.endCloseArm();
	}

	protected void interrupted() {
		
	}
}

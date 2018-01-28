package org.usfirst.frc.team2537.robot.climb;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbCommand extends Command {
	
	private boolean climbOn = true;

	public ClimbCommand() {

		requires(Robot.climbSys);

	}

	protected void initialize() {
		if (climbOn) {
			climbOn = false;
		} else {
			climbOn = true;
		}
	}

	protected void execute() { 
		if (!climbOn) {
			Robot.climbSys.megaMotorActivation();
		}
		if (climbOn) {
			Robot.climbSys.ultraDeath();
		}
	}

	@Override
	protected boolean isFinished() {
//		if(Robot.climbSys.getLimitSwitch()){
//			return true;
//		}else{
			return false;
	//	}
	}

	protected void end() {
		Robot.climbSys.ultraDeath();
	}

	protected void interrupted() {
		Robot.climbSys.ultraDeath();
	}
}

package org.usfirst.frc.team2537.robot.climb;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbCommand extends Command {

	public ClimbCommand() {

		requires(Robot.climbSys);

	}

	protected void initialize() {

		Robot.climbSys.megaMotorActivation();

	}

	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		if(Robot.climbSys.getlimitSwitch()){
			return true;
		}else{
			return false;
		}
	}

	protected void end() {
	Robot.climbSys.ultraDeath();
	}

	protected void interrupted() {

	}
}

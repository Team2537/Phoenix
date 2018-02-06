package org.usfirst.frc.team2537.robot.climb;
import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbOverrideCommand extends Command {

	public ClimbOverrideCommand() {
		requires(Robot.climbSys);
	}

	@Override
	protected void initialize() {
		Robot.climbSys.megaMotorActivation(0.85);

	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return (!HumanInput.overrideKeyOne.get()) || 
				(!HumanInput.overrideKeyTwo.get())|| 
				(!HumanInput.overrideKeyThree.get());

	}

	@Override
	protected void end() {
		Robot.climbSys.ultraDeath();

	}

	@Override
	protected void interrupted() {
		Robot.climbSys.ultraDeath();

	}

}

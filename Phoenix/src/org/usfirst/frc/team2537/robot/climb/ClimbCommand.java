package org.usfirst.frc.team2537.robot.climb;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbCommand extends Command {
	

	public ClimbCommand() {

		requires(Robot.climbSys);

	}

	protected void initialize() {
		Robot.climbSys.megaMotorActivation(0.85);
	}

	protected void execute() { 
		
	}

	@Override
	protected boolean isFinished() {
		return false; 
	}

	protected void end() {
		Robot.climbSys.ultraDeath();
	}

	protected void interrupted() {
		Robot.climbSys.ultraDeath();
	}
}

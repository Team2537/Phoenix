 package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class VertDownCommand extends Command {


	public VertDownCommand() {
		requires(Robot.vertSys);
	}

	@Override
	protected void initialize() {
		Robot.vertSys.setVertMotors(-.7);
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
		Robot.vertSys.setVertMotors(0);
	}

	@Override
	protected void interrupted() {
		Robot.vertSys.setVertMotors(0);
	}

}

package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class VertUpCommand extends Command {

	public VertUpCommand() {
		requires(Robot.vertSys);
	}

	protected void initialize() {
		Robot.vertSys.setVertMotors(0);
		if (!Robot.vertSys.getLimitSwitch())
			Robot.vertSys.setVertMotors(0.8);
	}

	protected void execute() {
		if (Robot.vertSys.getLimitSwitch())
			Robot.vertSys.setVertMotors(0);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.vertSys.setVertMotors(0);
	}

	protected void interrupted() {
		Robot.vertSys.setVertMotors(0);
	}
}

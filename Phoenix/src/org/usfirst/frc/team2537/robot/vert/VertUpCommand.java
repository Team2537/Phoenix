package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class VertUpCommand extends Command {
	
	private final double targetDistance;
	
	public VertUpCommand(double targetDistance) {
		requires(Robot.vertSys);
		this.targetDistance = targetDistance;
	}
	
	public VertUpCommand() {
		this(-1);
	}

	protected void initialize() {
		Robot.vertSys.resetEncoder();
		Robot.vertSys.setVertMotors(0);
		if (!Robot.vertSys.getLimitSwitch())
			Robot.vertSys.setVertMotors(1);
	}

	protected void execute() {
		if (Robot.vertSys.getLimitSwitch())
			Robot.vertSys.setVertMotors(0);

		System.out.println(Robot.vertSys.getLimitSwitch());
	}


	protected boolean isFinished() {
		return (targetDistance > 0 && Robot.vertSys.getEncoderPos() >= targetDistance) || Robot.vertSys.getLimitSwitch();
	}

	protected void end() {
		Robot.vertSys.setVertMotors(0);
	}

	protected void interrupted() {
		Robot.vertSys.setVertMotors(0);
	}
}

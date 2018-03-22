 package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class VertDownCommand extends Command {

	private final double targetDistance;

	public VertDownCommand() {
		requires(Robot.vertSys);
		this.targetDistance = -1;
	}
	
	public VertDownCommand(int targetDistance) {
		requires(Robot.vertSys);
		this.targetDistance = Math.abs(targetDistance);
	}

	@Override
	protected void initialize() {
		Robot.vertSys.resetEncoder();
		Robot.vertSys.setVertMotors(0);
		if (!Robot.vertSys.getBottomSwitch())
			Robot.vertSys.setVertMotors(-.6);
	}

	@Override
	protected void execute() {
		if (Robot.vertSys.getBottomSwitch())
			Robot.vertSys.setVertMotors(0);
		System.out.println("encoder: " + -Robot.vertSys.getEncoderPos() + " target: " + targetDistance);
	}

	@Override
	protected boolean isFinished() {
		return (targetDistance > 0 && -Robot.vertSys.getEncoderPos() >= targetDistance) || Robot.vertSys.getBottomSwitch();
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

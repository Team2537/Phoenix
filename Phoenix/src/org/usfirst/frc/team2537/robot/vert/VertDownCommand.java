 package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class VertDownCommand extends Command {

	private final double targetDistance;

	public VertDownCommand() {
		this(-1);
	}
	
	public VertDownCommand(int targetDistance) {
		requires(Robot.driveSys);
		this.targetDistance = Math.abs(targetDistance);
	}

	@Override
	protected void initialize() {
		Robot.vertSys.resetEncoder();
		Robot.vertSys.setVertMotors(-.6);
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return (targetDistance > 0 && -Robot.vertSys.getEncoderPos() >= targetDistance);
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

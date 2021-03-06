 package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class VertDownSlowCommand extends Command {

	private final double targetDistance;

	public VertDownSlowCommand() {
		requires(Robot.vertSys);
		this.targetDistance = -1;
	}
	
	@Override
	protected void initialize() {
		Robot.vertSys.resetEncoder();
		Robot.vertSys.setVertMotors(0);
		if (!Robot.vertSys.getBottomSwitch())
			Robot.vertSys.setVertMotors(-.15);
	}

	@Override
	protected void execute() {
		if (Robot.vertSys.getBottomSwitch())
 			Robot.vertSys.setVertMotors(0);
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

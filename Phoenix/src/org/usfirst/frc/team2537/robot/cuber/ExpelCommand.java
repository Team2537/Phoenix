package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ExpelCommand extends Command {
	double speed; 
	public ExpelCommand() {
		requires(Robot.cuberSys); 
	}

	/**
	 * sets speed to reverse to expel out cube
	 */
	@Override
	protected void initialize() {
		Robot.cuberSys.setFlywheelMotors(-speed); // sets speed to reverse to expel out cube

	}

	@Override
	protected void execute() {

	}
	
	/**
	 * prevents stalling of flywheel motors by sensing problems with amperage and distance
	 */
	@Override
	protected boolean isFinished() { 
		return (Robot.cuberSys.getRightFlywheelCurrent() >= Robot.cuberSys.currentLimit
				|| Robot.cuberSys.getLeftFlywheelCurrent() >= Robot.cuberSys.currentLimit
				|| Robot.cuberSys.getUltrasonicDistance() <= 1);
	}

	/**
	 * sets Flywheel motor speed to zero when isFinished senses problems with flywheel motor amperage or ultrasonic 
	 */
	@Override
	protected void end() { 
		Robot.cuberSys.setFlywheelMotors(0);

	}
	
	/**
	 * sets Flywheel motor speed to zero so that new command can be enacted 
	 */
	@Override
	protected void interrupted() { 
		Robot.cuberSys.setFlywheelMotors(0);

	}

}

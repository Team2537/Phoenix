package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PickUpCommand extends Command {
	double speed;

	public PickUpCommand() {
		requires(Robot.cuberSys); 
	}

	/**
	 *  sets speed to reverse to expel out cube
	 **/
	@Override
	protected void initialize() {
		Robot.cuberSys.setFlywheelMotors(speed); // initializes Flywheel motors to designated speed when pickUp button is pressed
	}

	@Override
	protected void execute() {
		Robot.vertSys.initDefaultCommand();
	}
	
	/**
	 * prevents stalling of flywheel motors by sensing problems with amperage and distance
	 */
	@Override
	protected boolean isFinished() { // returns true to isFinished when flywheel motors exceed max amp

		return (Robot.cuberSys.getRightFlywheelCurrent() >= Robot.cuberSys.currentLimit 
				|| Robot.cuberSys.getLeftFlywheelCurrent() >= Robot.cuberSys.currentLimit //prevents stalling
				|| Robot.cuberSys.getUltrasonicDistance() <= 1); //when distance of cube to back of cuber is less or equal to 1, flywheel motors stop to prevent stalling
	}
	
	/**
	 * sets Flywheel motor speed to zero when isFinished senses problems with flywheel motor amperage or ultrasonic 
	 */
	@Override
	protected void end() {
		Robot.cuberSys.setFlywheelMotors(0); 
	}
	/**
	 *stops flywheel motors so that another command can occur
	 */
	@Override
	protected void interrupted() {
		Robot.cuberSys.setFlywheelMotors(0); 
	}

}



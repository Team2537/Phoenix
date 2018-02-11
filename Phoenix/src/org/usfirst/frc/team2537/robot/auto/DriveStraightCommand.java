package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.drive.Motor;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraightCommand extends Command {

	/******************************************************************************/
	/* PUBLIC CONSTANTS */
	/******************************************************************************/

	/**
	 * when we are at or below this angle (degrees) from the target, we
	 * gradually slow down until the angle is 0
	 */
	public static final double ANGLE_TOLERANCE = 1;

	public static final double SLOW_DOWN_POWER = 10;

	public static final double ANGLE_kP = 2;

	/** value [0,1] representing the percent of power to motors */
	public static final double DEFAULT_PERCENT_OUTPUT = 0.69;

	/******************************************************************************/
	/* INSTANCE VARIABLES */
	/******************************************************************************/

	private double targetInches;
	private double motorPower;
	private boolean slowingDown;

	/******************************************************************************/
	/* CONSTRUCTORS */
	/******************************************************************************/

	/**
	 * @param distance
	 *            (inches)
	 * @param defaultPercentOutput
	 *            power to the motors [0,1]
	 */
	public DriveStraightCommand(double distance) {
		this(distance, DEFAULT_PERCENT_OUTPUT);
	}

	/**
	 * @param distance
	 *            (inches)
	 * @param defaultPercentOutput
	 *            power to the motors [0,1]
	 */
	public DriveStraightCommand(double distance, double defaultPercentOutput) {
		requires(Robot.driveSys);
		targetInches = distance;
		motorPower = defaultPercentOutput;
		slowingDown = false;
	}

	/******************************************************************************/
	/* OVERRIDEN METHODS */
	/******************************************************************************/

	@Override
	protected void initialize() {
		Robot.driveSys.resetEncoders();
		Robot.driveSys.setMode(ControlMode.PercentOutput);
		Navx.getInstance().reset();
		System.out.println("starting angle: " + Navx.getInstance().getAngle());
	}

	@Override
	protected void execute() {
		double currentInches = Robot.driveSys.getAverageEncoderInches();
		double currentVelocity = Robot.driveSys.getEncoderVelocity();
		double power = motorPower;

		if (!slowingDown) {
			double slowDownDistance = calculateSlowDownDistance(currentVelocity);
			if (targetInches - currentInches <= slowDownDistance) {
				System.out.println("\n\n\n\n\n SLOWING DOWN!!! slow down distance: " + slowDownDistance);
				slowingDown = true;
			}
		}

		if (slowingDown) {
			power *= (targetInches - currentInches) / targetInches;
		}

		/* we add a speed delta to compensate for being off angle */
		double powerAdjustmentFromAngle = 0;
		double currentAngle = Navx.getInstance().getAngle();
//		System.out.println("current angle: " + currentAngle);
		if (Math.abs(currentAngle) > ANGLE_TOLERANCE) {
			powerAdjustmentFromAngle = currentAngle/180*ANGLE_kP*power;
		}

		Robot.driveSys.setMotors(power - powerAdjustmentFromAngle, Motor.LEFT);
		Robot.driveSys.setMotors(power + powerAdjustmentFromAngle, Motor.RIGHT);
	}

	@Override
	protected boolean isFinished() {
		System.out.println("speed: " + Robot.driveSys.getEncoderVelocity() + "; " + 
				Robot.driveSys.getAverageEncoderInches() + " / " + targetInches);
		return Robot.driveSys.getAverageEncoderInches() >= targetInches;
	}

	@Override
	protected void end() {
		Robot.driveSys.setMotors(0);
	}

	/**
	 * Called when another command which requires one or more of the same
	 * subsystems is scheduled to run
	 *
	 */
	@Override
	protected void interrupted() {
		end();
	}

	/******************************************************************************/
	/* MISC */
	/******************************************************************************/

	/**
	 * @param speed
	 *            (inches per second)
	 * @return the optimal distance away from the target at which the robot
	 *         should slow down (inches)
	 */
	private double calculateSlowDownDistance(double speed) {
		//return Math.pow(speed, speed / SLOW_DOWN_POWER) / SLOW_DOWN_POWER;
		return Math.pow(speed, 2) / SLOW_DOWN_POWER;
	}

}
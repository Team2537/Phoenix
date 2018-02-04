package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.conversions.Conversions;
import org.usfirst.frc.team2537.robot.conversions.Distances;
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

	public static final double SLOW_DOWN_POWER = 100;

	public static final double[] ANGLE_PID = new double[] { 20, 0, 0 };

	/** value [0,1] representing the percent of power to motors */
	public static final double DEFAULT_PERCENT_OUTPUT = 0.4;

	/******************************************************************************/
	/* INSTANCE VARIABLES */
	/******************************************************************************/

	private double targetTicks;
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
		targetTicks = Conversions.convertDistance(distance, Distances.INCHES, Distances.TICKS);
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
		/* we convert angles to values in range [-1,1] */
		double normalizedAngle = Navx.getInstance().getAngle() / 180;
		double normalizedSlowDownAngle = ANGLE_TOLERANCE / 180;
		double currentTicks = Robot.driveSys.getEncoderDistance();
		double currentVelocity = Robot.driveSys.getEncoderVelocity();
		double power = motorPower;

		if (!slowingDown) {
			double slowDownDistance = calculateSlowDownDistance(currentVelocity);
			/*System.out.printf("avg velocity: %f in/s;  slow down distance: %f in.; target ticks: %f%n",
					Conversions.roundDigits(Conversions.convertSpeed(currentVelocity, Distances.TICKS, Times.HUNDRED_MS,
							Distances.INCHES, Times.SECONDS), 4),
					Conversions.roundDigits(
							Conversions.convertDistance(slowDownDistance, Distances.TICKS, Distances.INCHES), 4),
					targetTicks);*/
			if (targetTicks - currentTicks <= slowDownDistance) {
				System.out.println("\n\n\n\n\n SLOWING DOWN!!! slow down distance: " + slowDownDistance);
				slowingDown = true;
			}
		}

		if (slowingDown) {
			/*System.out.printf("avg velocity: %f in/s%n",
					Conversions.roundDigits(Conversions.convertSpeed(currentVelocity, Distances.TICKS, Times.HUNDRED_MS,
							Distances.INCHES, Times.SECONDS), 4));*/
			power *= (targetTicks - currentTicks) / targetTicks;
		}

		/* we add a speed delta to compensate for being off angle */
		
		double slowDownDelta = 0;
		if (Math.abs(normalizedAngle) > Math.abs(normalizedSlowDownAngle)) {
			System.out.println(normalizedAngle * 180 + " degrees");
			slowDownDelta = normalizedAngle * ANGLE_PID[0] * power;
		}

		Robot.driveSys.setMotors(power - slowDownDelta, Motor.LEFT);
		Robot.driveSys.setMotors(power + slowDownDelta, Motor.RIGHT);
	}

	@Override
	protected boolean isFinished() {
		return Robot.driveSys.getEncoderDistance() >= targetTicks;
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
		return Math.pow(speed, 2) / SLOW_DOWN_POWER;
	}

}
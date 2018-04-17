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
	
	public static final double DISTANCE_TOLERANCE = 1;

	public static final double ANGLE_kP = 2;

	/** value [0,1] representing the percent of power to motors */
	public static final double DEFAULT_PERCENT_OUTPUT = .4;
	
	public static final double MIN_PERCENT_OUTPUT = 0.15;
	
	public static final double RAMP_UP_TIME = 1.5;

	/******************************************************************************/
	/* INSTANCE VARIABLES */
	/******************************************************************************/

	private double motorPower;
	private double remainingInchesAtSlowdown;
	private boolean slowingDown;
	private double backwardsMultiplier;
	private double targetInches;
	private double startingTime;
	private double slowDownPower;

	/******************************************************************************/
	/* CONSTRUCTORS */
	/******************************************************************************/
	
	public DriveStraightCommand(double targetInches, double defaultPercentOutput) {
		requires(Robot.driveSys);
		motorPower = defaultPercentOutput;
		slowingDown = false;
		this.targetInches = targetInches;
		slowDownPower = targetInches * 50;
	}
	
	public DriveStraightCommand(double targetInches) {
		this(targetInches, DEFAULT_PERCENT_OUTPUT);
	}

	/******************************************************************************/
	/* OVERRIDEN METHODS */
	/******************************************************************************/

	@Override
	protected void initialize() {
		Robot.driveSys.setMode(ControlMode.PercentOutput);
		Robot.driveSys.resetEncoders();
		Navx.getInstance().reset();
		System.out.println("starting angle: " + Navx.getInstance().getAngle());
		System.out.println("encoders: " + Robot.driveSys.justFuckMyShitUpFam());
		backwardsMultiplier = Math.signum(getRemainingInches());
		startingTime = System.currentTimeMillis();
	}

	@Override
	protected void execute() {
		double remainingInches = getRemainingInches() * backwardsMultiplier;
		double currentVelocity = Robot.driveSys.getEncoderVelocity() * backwardsMultiplier;
		double power = motorPower;

		power = Math.min(((DEFAULT_PERCENT_OUTPUT - MIN_PERCENT_OUTPUT) * (System.currentTimeMillis() - startingTime) * 1e9) + MIN_PERCENT_OUTPUT, DEFAULT_PERCENT_OUTPUT);
		System.out.println(power);
		if (!slowingDown) {
			double slowDownDistance = calculateSlowDownDistance(currentVelocity);
			if (remainingInches <= slowDownDistance) {
				System.out.println("\n\n SLOWING DOWN!!! slow down distance: " + slowDownDistance);
				slowingDown = true;
				remainingInchesAtSlowdown = remainingInches;
			}
		}

		if (slowingDown) {
			power *= remainingInches / remainingInchesAtSlowdown;
		}
		
		power = Math.max(power, MIN_PERCENT_OUTPUT);
		power *= Math.signum(remainingInches);

		/* we add a speed delta to compensate for being off angle */
		double powerAdjustmentFromAngle = 0;
		double currentAngle = Navx.getInstance().getAngle();
//		System.out.println("current angle: " + currentAngle);
		if (Math.abs(currentAngle) > ANGLE_TOLERANCE) {
			powerAdjustmentFromAngle = currentAngle/180*ANGLE_kP*power * backwardsMultiplier;
		}
		
		System.out.println("power adjustment from angle: " + powerAdjustmentFromAngle);
		
		Robot.driveSys.setMotors((power - powerAdjustmentFromAngle) * backwardsMultiplier, Motor.LEFT);
		Robot.driveSys.setMotors((power + powerAdjustmentFromAngle) * backwardsMultiplier, Motor.RIGHT);
	}

	@Override
	protected boolean isFinished() {
		System.out.println("speed: " + Robot.driveSys.getEncoderVelocity() + "; " + 
				"remaining dist: " + getRemainingInches());
		return getRemainingInches() * backwardsMultiplier <= DISTANCE_TOLERANCE;
	}

	@Override
	protected void end() {
		System.out.println("ending driveforward");
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
	
	protected double getRemainingInches() {
		return targetInches - Robot.driveSys.getEncoderDistance();
	}
	
	/**
	 * @param speed
	 *            (inches per second)
	 * @return the optimal distance away from the target at which the robot
	 *         should slow down (inches)
	 */
	private double calculateSlowDownDistance(double speed) {
		//return Math.pow(speed, speed / SLOW_DOWN_POWER) / SLOW_DOWN_POWER;
		return Math.pow(speed, 2) / 1;
	}

}
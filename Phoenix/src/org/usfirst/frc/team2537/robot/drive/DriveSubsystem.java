package org.usfirst.frc.team2537.robot.drive;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.units.Distances;
import org.usfirst.frc.team2537.robot.units.Times;
import org.usfirst.frc.team2537.robot.units.Units;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveSubsystem extends Subsystem {

	/******************************************************************************/
	/* PUBLIC CONSTANTS */
	/******************************************************************************/

	/**
	 * set to 1 if the motors are in the forward direction otherwise set to -1
	 * when the motors are upside-down
	 * 
	 * methods in this class that take speed parameters use these multipliers to
	 * flip the sign of reversed motors.
	 */
	public static final int LEFT_MOTOR_DIRECTION = 1;
	public static final int RIGHT_MOTOR_DIRECTION = -1;
	
	public static final double ENCODER_MIN_PERCENT_AGREEMENT = 0.10;

	/******************************************************************************/
	/* INSTANCE VARIABLES */
	/******************************************************************************/

	private TalonSRX talonFrontLeft;
	private TalonSRX talonFrontRight;
	private TalonSRX talonBackLeft;
	private TalonSRX talonBackRight;
	public ControlMode controlMode = ControlMode.PercentOutput;

	/******************************************************************************/
	/* CONSTRUCTORS */
	/******************************************************************************/

	public DriveSubsystem() {
		talonFrontLeft = new TalonSRX(Ports.FRONT_LEFT_MOTOR);
		talonFrontRight = new TalonSRX(Ports.FRONT_RIGHT_MOTOR);
		talonBackLeft = new TalonSRX(Ports.BACK_LEFT_MOTOR);
		talonBackRight = new TalonSRX(Ports.BACK_RIGHT_MOTOR);

		talonFrontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		talonFrontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		talonBackLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		talonFrontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
	}

	/******************************************************************************/
	/* OVERRIDEN METHODS */
	/******************************************************************************/

	@Override
	public void initDefaultCommand() {
		this.setDefaultCommand(new DriveCommand());
	}

	/******************************************************************************/
	/* ENCODER METHODS */
	/******************************************************************************/

	public String justFuckMyShitUpFam() {
		SmartDashboard.putNumber("front left", talonFrontLeft.getSelectedSensorPosition(0)*LEFT_MOTOR_DIRECTION);
		SmartDashboard.putNumber("front right", talonFrontRight.getSelectedSensorPosition(0)*RIGHT_MOTOR_DIRECTION);
		SmartDashboard.putNumber("back left", talonBackLeft.getSelectedSensorPosition(0)*LEFT_MOTOR_DIRECTION);
		SmartDashboard.putNumber("back right", talonBackRight.getSelectedSensorPosition(0)*RIGHT_MOTOR_DIRECTION);
		SmartDashboard.putNumber("speed", getEncoderVelocity());
		return "front left: "+talonFrontLeft.getSelectedSensorPosition(0)*LEFT_MOTOR_DIRECTION+"\n"
				+ "front right: " + talonFrontRight.getSelectedSensorPosition(0)*RIGHT_MOTOR_DIRECTION+"\n"
				+ "back left: " + talonBackLeft.getSelectedSensorPosition(0)*LEFT_MOTOR_DIRECTION + "\n"
				+ "back right: " + talonBackRight.getSelectedSensorPosition(0)*RIGHT_MOTOR_DIRECTION;
	}
	/**
	 * @return average value of all talons in inches
	 */
	public double getAverageEncoderInches() {
		/*
		double[] encoderTicks = new double[4];
		encoderTicks[0] = talonFrontLeft.getSelectedSensorPosition(0) * LEFT_MOTOR_DIRECTION;
		encoderTicks[1] = talonFrontRight.getSelectedSensorPosition(0) * RIGHT_MOTOR_DIRECTION;
		encoderTicks[2] = talonBackLeft.getSelectedSensorPosition(0) * LEFT_MOTOR_DIRECTION;
		encoderTicks[3] = talonBackRight.getSelectedSensorPosition(0) * RIGHT_MOTOR_DIRECTION;
		
		double maxTicks = 0;
		for(int x = 0; x < encoderTicks.length; x++){
			if(Math.abs(encoderTicks[x]) > Math.abs(maxTicks)){
				maxTicks = encoderTicks[x];
			}
		}
		
		if(maxTicks == 0){
			return 0;
		}
		
		double sum = 0;
		int validEncoders = 0;
		for(int x = 0; x < encoderTicks.length; x++){
			if(Math.abs(encoderTicks[x] / maxTicks) >= (1 - ENCODER_MIN_PERCENT_AGREEMENT)){
				sum += encoderTicks[x];
				validEncoders++;
			}
		}
		System.out.println("valid encoders: "+validEncoders);
		return sum / validEncoders;
		*/
		return Units.convertDistance((talonFrontLeft.getSelectedSensorPosition(0) * LEFT_MOTOR_DIRECTION + 
				talonFrontRight.getSelectedSensorPosition(0) * RIGHT_MOTOR_DIRECTION) / 2, 
				Distances.TICKS, Distances.INCHES);
	}

	/**
	 * @return average velocity of all talons in inches per second
	 */
	public double getEncoderVelocity() {
		return Units.convertSpeed((talonFrontLeft.getSelectedSensorVelocity(0) * LEFT_MOTOR_DIRECTION + 
				talonFrontRight.getSelectedSensorVelocity(0) * RIGHT_MOTOR_DIRECTION) / 2,
				Distances.TICKS, Times.HUNDRED_MS, Distances.INCHES, Times.SECONDS);
	}

	public void resetEncoders() {
		talonFrontRight.getSensorCollection().setQuadraturePosition(0, 0);
		talonFrontLeft.getSensorCollection().setQuadraturePosition(0, 0);
		talonBackRight.getSensorCollection().setQuadraturePosition(0, 0);
		talonBackLeft.getSensorCollection().setQuadraturePosition(0, 0);
	}

	/******************************************************************************/
	/* MOTOR METHODS */
	/******************************************************************************/

	public void setMotors(double speed, Motor id) {
		if (id == Motor.FRONT_LEFT || id == Motor.LEFT || id == Motor.FRONT || id == Motor.ALL) {
			talonFrontLeft.set(controlMode, speed * LEFT_MOTOR_DIRECTION);
		}
		if (id == Motor.FRONT_RIGHT || id == Motor.RIGHT || id == Motor.FRONT || id == Motor.ALL) {
			talonFrontRight.set(controlMode, speed * RIGHT_MOTOR_DIRECTION);
		}
		if (id == Motor.BACK_LEFT || id == Motor.LEFT || id == Motor.BACK || id == Motor.ALL) {
			talonBackLeft.set(controlMode, speed * LEFT_MOTOR_DIRECTION);
		}
		if (id == Motor.BACK_RIGHT || id == Motor.RIGHT || id == Motor.BACK || id == Motor.ALL) {
			talonBackRight.set(controlMode, speed * RIGHT_MOTOR_DIRECTION);
		}
	}

	public void setMotors(double speed, Motor... motors) {
		if (motors.length == 0) {
			setMotors(speed, Motor.ALL);
		} else {
			for (Motor motor : motors) {
				setMotors(speed, motor);
			}
		}
	}

	/******************************************************************************/
	/* SETTERS */
	/******************************************************************************/

	/**
	 * control mode not actually changed until you set a value (thanks a lot
	 * dumbasses @ ctre)
	 * 
	 * @param controlMode
	 */
	public void setMode(ControlMode controlMode) {
		this.controlMode = controlMode;
	}

}

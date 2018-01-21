package org.usfirst.frc.team2537.robot.drive;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.resources.CANTalon;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
	private CANTalon leftFrontRampMotor;
	private CANTalon leftBackRampMotor;
	private CANTalon rightFrontRampMotor;
	private CANTalon rightBackRampMotor;
	
	public DriveSubsystem() {
		leftFrontRampMotor = new CANTalon(Ports.LEFT_FRONT_RAMP_MOTOR);
		leftBackRampMotor = new CANTalon(Ports.LEFT_BACK_RAMP_MOTOR);
		rightBackRampMotor = new CANTalon(Ports.RIGHT_BACK_RAMP_MOTOR);
		rightBackRampMotor = new CANTalon(Ports.RIGHT_BACK_RAMP_MOTOR);
	}

	@Override
	public void initDefaultCommand() {
		this.setDefaultCommand(new DriveCommand());

	}
	
	public void setLeftFrontMotor(double speed) {
		leftFrontRampMotor.set(speed);
	}
	
	public void setLeftBackMotor(double speed) {
		leftBackRampMotor.set(speed);
	}
	
	public void setRightFrontMotor(double speed) {
		rightFrontRampMotor.set(speed);
	}
	
	public void setRightBackMotor(double speed) {
		rightBackRampMotor.set(speed);
	}
	
	public void setLeftMotors(double frontSpeed, double backSpeed) {
		setLeftFrontMotor(frontSpeed);
		setLeftBackMotor(backSpeed);
	}
	
	public void setRightMotors(double frontSpeed, double backSpeed) {
		setRightFrontMotor(frontSpeed);
		setRightBackMotor(backSpeed);
	}
	public void setMotors(double leftFrontSpeed, double leftBackSpeed, double rightFrontSpeed, double rightBackSpeed) {
		setLeftFrontMotor(leftFrontSpeed);
		setLeftBackMotor(leftBackSpeed);
		setRightFrontMotor(rightFrontSpeed);
		setRightBackMotor(rightBackSpeed);
	}
	public void setBackMotors(double speed) {
		setLeftBackMotor(speed);
		setRightBackMotor(speed);
	}

}

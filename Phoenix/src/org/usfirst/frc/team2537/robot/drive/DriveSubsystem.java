package org.usfirst.frc.team2537.robot.drive;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;
import org.usfirst.frc.team2537.robot.resources.CANTalon;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
	private CANTalon backLeftMotor, backRightMotor;
	private Talon frontLeftMotor, frontRightMotor;
	private final double DEADZONE_THRESHOLD = .1;
	
	public DriveSubsystem() {
		backLeftMotor = new CANTalon(Ports.BACK_LEFT_MOTOR);
		backRightMotor = new CANTalon(Ports.BACK_RIGHT_MOTOR);
		frontLeftMotor = new Talon(Ports.FRONT_LEFT_MOTOR);
		frontRightMotor = new Talon(Ports.FRONT_RIGHT_MOTOR);
	}
	
	public void initDefaultCommand() {
		this.setDefaultCommand(new DriveCommand());
	}
	
	public void setLeftMotors(double speed) {
		backLeftMotor.set(speed);
		frontLeftMotor.set(speed);
	}
	
	public void setRightMotors(double speed) {
		backRightMotor.set(speed);
		frontRightMotor.set(speed);
	}
	
	public void setMotors(double leftSpeed, double rightSpeed) {
		setLeftMotors(leftSpeed);
		setRightMotors(rightSpeed);
	}
	
	public double getLeftJoystick() {
		double leftJoystick = HumanInput.leftJoystick.getRawAxis(1);
		if (Math.abs(leftJoystick) > DEADZONE_THRESHOLD)
			return leftJoystick;
		return 0;
	}
	
	public double getRightJoystick() {
		double rightJoystick = HumanInput.rightJoystick.getRawAxis(1);
		if (Math.abs(rightJoystick) > DEADZONE_THRESHOLD)
			return rightJoystick;
		return 0;
	}

}

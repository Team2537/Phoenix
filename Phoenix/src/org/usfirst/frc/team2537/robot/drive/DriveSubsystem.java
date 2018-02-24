package org.usfirst.frc.team2537.robot.drive;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;
import org.usfirst.frc.team2537.robot.resources.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {

	private CANTalon frontRightMotor;
	private CANTalon frontLeftMotor;
	private CANTalon backRightMotor;
	private CANTalon backLeftMotor;

	public DriveSubsystem() {
		frontRightMotor = new CANTalon(Ports.FRONT_RIGHT_MOTOR);
		frontLeftMotor = new CANTalon(Ports.FRONT_LEFT_MOTOR);
		backRightMotor = new CANTalon(Ports.BACK_RIGHT_MOTOR);
		backLeftMotor = new CANTalon(Ports.BACK_LEFT_MOTOR);
	}

	@Override
	public void initDefaultCommand() {
		this.setDefaultCommand(new DriveCommand());

	}

	public void setRightMotorsSpeed(double speed) {
		frontRightMotor.set(speed);
		backRightMotor.set(speed);
	}

	public void setLeftMotorsSpeed(double speed) {
		frontLeftMotor.set(speed);
		backLeftMotor.set(speed);
	}
	
	public double checkLeftJoystickValue() {
		if (Math.abs(HumanInput.leftJoystick.getRawAxis(1)) >= .1) {
			return HumanInput.leftJoystick.getRawAxis(1);
		} else {
			return 0;
		}
	}
	
	public double checkRightJoystickValue() {
		if (Math.abs(HumanInput.rightJoystick.getRawAxis(1)) >= .1) {
			return HumanInput.rightJoystick.getRawAxis(1);
		}  else {
			return 0;
		}
	}
}
	


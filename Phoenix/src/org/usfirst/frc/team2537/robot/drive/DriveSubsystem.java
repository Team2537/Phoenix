package org.usfirst.frc.team2537.robot.drive;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;
import org.usfirst.frc.team2537.robot.resources.CANTalon;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
	private CANTalon backLeft;
	private CANTalon backRight;
	private Talon frontLeft;
	private Talon frontRight;
	double deadZone = .1;
	
	public DriveSubsystem() {
		backLeft = new CANTalon(Ports.BACK_LEFT_MOTOR);
		backRight = new CANTalon(Ports.BACK_RIGHT_MOTOR);
		frontLeft = new Talon(Ports.FRONT_LEFT_MOTOR);
		frontRight = new Talon(Ports.FRONT_RIGHT_MOTOR);
	}
	
	@Override
	public void initDefaultCommand() {	
		this.setDefaultCommand(new DriveCommand());
	}

	public void setLeftMotors(double speed) {
		backLeft.set(speed);
		frontLeft.set(speed);
	}
	
	public void setRightMotors(double speed) {
		backRight.set(speed);
		frontRight.set(speed);
		
	}

	public double getRightJoystick() {
		if (Math.abs(HumanInput.rightJoystick.getRawAxis(1)) >= deadZone) {
			return HumanInput.rightJoystick.getRawAxis(1);
		}
		return 0;
	}
	
	public double getLeftJoystick() {
		if (Math.abs(HumanInput.leftJoystick.getRawAxis(1)) >= deadZone) {
			return HumanInput.leftJoystick.getRawAxis(1);
		}
		return 0;
	}
}

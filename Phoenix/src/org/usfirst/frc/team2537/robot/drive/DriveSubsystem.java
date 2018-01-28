package org.usfirst.frc.team2537.robot.drive;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.resources.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
	CANTalon backLeftTalon;
	CANTalon frontLeftTalon;
	CANTalon backRightTalon;
	CANTalon frontRightTalon;
	
	
	public DriveSubsystem(){
		backLeftTalon = new CANTalon(Ports.BACK_LEFT_TALON);
		frontLeftTalon = new CANTalon(Ports.FRONT_LEFT_TALON);
		backRightTalon = new CANTalon(Ports.BACK_RIGHT_TALON);
		frontRightTalon = new CANTalon(Ports.FRONT_RIGHT_TALON);
		
	}

	@Override
	public void initDefaultCommand() {
		this.setDefaultCommand(new DriveCommand());
		
	}
	
	public void setBackLeftMotor(double speed){
		backLeftTalon.set(-speed);
	}
	
	public void setBackRightMotor(double speed){
		backRightTalon.set(speed);
	}
	
	public void setFrontLeftMotor(double speed){
		frontLeftTalon.set(-speed);
	}
	
	public void setFrontRightMotor(double speed){
		frontRightTalon.set(speed);
	}
	
	public void setLeftMotors(double speed){
		backLeftTalon.set(speed);
		frontLeftTalon.set(speed);
	}
	
	public void setRightMotors(double speed){
		backRightTalon.set(speed);
		frontRightTalon.set(speed);
	}
	
	public void setAllMotors(double speed){
		setLeftMotors(speed);
		setRightMotors(speed);
	}
	
	public void stopMotors(){
		setAllMotors(0);
	}
	
	public void setDifferentBothMotors(double leftSpeed, double rightSpeed){
		setLeftMotors(leftSpeed);
		setRightMotors(rightSpeed);
	}
	
	
	
	
	
	
	
	
	
	
}

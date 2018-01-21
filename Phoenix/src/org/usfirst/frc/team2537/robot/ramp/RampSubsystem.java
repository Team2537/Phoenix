package org.usfirst.frc.team2537.robot.ramp;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RampSubsystem extends Subsystem {
	//Talon with Ramp
	private Talon leftRampMotor;
	private Talon rightRampMotor;
//	private Talon leftFrontRampMotor;
//	private Talon leftBackRampMotor;
//	private Talon rightFrontRampMotor;
//	private Talon rightBackRampMotor;
	private Encoder leftEnc;
	private Encoder rightEnc;
	private DigitalInput limitSwitchA;
	private DigitalInput limitSwitchB;
	
	public RampSubsystem() {
		leftRampMotor = new Talon(Ports.LEFT_RAMP_MOTOR);
		rightRampMotor = new Talon(Ports.RIGHT_RAMP_MOTOR);
		//leftFrontRampMotor = new Talon(Ports.LEFT_FRONT_RAMP_MOTOR);
		//leftBackRampMotor = new Talon(Ports.LEFT_BACK_RAMP_MOTOR);
		//rightBackRampMotor = new Talon(Ports.RIGHT_BACK_RAMP_MOTOR);
		//rightBackRampMotor = new Talon(Ports.RIGHT_BACK_RAMP_MOTOR);
		
		leftEnc = new Encoder(Ports.LEFT_ENC_A, Ports.LEFT_ENC_B, false, Encoder.EncodingType.k4X);
		rightEnc = new Encoder(Ports.RIGHT_ENC_A, Ports.RIGHT_ENC_B, false, Encoder.EncodingType.k4X);
		
		limitSwitchA = new DigitalInput(Ports.LIMIT_SWITCH_A);
		limitSwitchB = new DigitalInput(Ports.LIMIT_SWITCH_B);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public double getLeftEncoderRange() {
		return leftEnc.getDistance();
	}
	
	public double getRightEncoderRange() {
		return rightEnc.getDistance();
	}
	
	public void registerButtons() {
		HumanInput.registerWhenPressedCommand(HumanInput.rampRaiseButton, new RampRaiseCommand ());
		HumanInput.registerWhenPressedCommand(HumanInput.rampLowerButton, new RampLowerCommand ());
	}
	
//	public void setLeftFrontMotor(double speed) {
//		leftFrontRampMotor.set(speed);
//	}
//	
//	public void setLeftBackMotor(double speed) {
//		leftBackRampMotor.set(speed);
//	}
//	
//	public void setRightFrontMotor(double speed) {
//		rightFrontRampMotor.set(speed);
//	}
//	
//	public void setRightBackMotor(double speed) {
//		rightBackRampMotor.set(speed);
//	}
	
//	public void setLeftMotors(double frontSpeed, double backSpeed) {
//		setLeftFrontMotor(frontSpeed);
//		setLeftBackMotor(backSpeed);
//	}
	
//	public void setRightMotors(double frontSpeed, double backSpeed) {
//		setRightFrontMotor(frontSpeed);
//		setRightBackMotor(backSpeed);
//	}
//	public void setMotors(double leftFrontSpeed, double leftBackSpeed, double rightFrontSpeed, double rightBackSpeed) {
//		setLeftFrontMotor(leftFrontSpeed);
//		setLeftBackMotor(leftBackSpeed);
//		setRightFrontMotor(rightFrontSpeed);
//		setRightBackMotor(rightBackSpeed);
//	}
//	public void setBackMotors(double speed) {
//		setLeftBackMotor(speed);
//		setRightBackMotor(speed);
//	}
	public void setLeftRampMotor(double speed) {
		setLeftRampMotor(speed);
	}
	public void setRightRampMotor(double speed) {
		setRightRampMotor(speed);
	}
	
	public void setRampMotors(double leftSpeed, double rightSpeed) {
		setLeftRampMotor(leftSpeed);
		setRightRampMotor(rightSpeed);
	}
	
	public void raiseRamp(double speed) {
		setRampMotors(speed,speed);
	}
	
	public void lowerRamp(double speed) {
		setRampMotors(speed,speed);
	}
	
	public boolean getLimitSwitchA() {
		return limitSwitchA.get();
	}
	
	public boolean getLimitSwitchB() {
		return limitSwitchB.get();
	}
	
}

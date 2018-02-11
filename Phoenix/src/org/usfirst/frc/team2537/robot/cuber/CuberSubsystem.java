package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CuberSubsystem extends Subsystem {
	private Talon flywheelMotorLeft; 
	private Talon flywheelMotorRight;
	private Encoder liftEnc;
	private Talon liftMotor;
	private AnalogInput cuberIRSensor;
	public static final double FLYWHEEL_SPEED = .5;
	public static final double FLYWHEEL_CURRENT_LIMIT = 30; // TODO: determine max amps
	public static final double CUTOFF_DISTANCE = 2; // TODO: determine cutoff distance
	
	public CuberSubsystem() {
		flywheelMotorLeft = new Talon(Ports.FLYWHEEL_MOTOR_LEFT);
		flywheelMotorRight = new Talon(Ports.FLYWHEEL_MOTOR_RIGHT);
		liftMotor = new Talon(Ports.WINDOW_MOTOR);
		liftEnc = new Encoder(Ports.LIFT_ENCODER_A, Ports.LIFT_ENCODER_B, false, Encoder.EncodingType.k4X);
		cuberIRSensor = new AnalogInput(Ports.CUBER_IR);
	}
	
	public void initDefaultCommand() {
		
	}
	
	public void registerButtons() { 
		HumanInput.registerWhileHeldCommand(HumanInput.pickUpButton, new PickUpCommand());
		HumanInput.registerWhileHeldCommand(HumanInput.expelButton, new ExpelCommand());
		HumanInput.registerWhenPressedCommand(HumanInput.lowerButton, new LowerFlipperCommand());
		HumanInput.registerWhenPressedCommand(HumanInput.raiseButton, new LiftFlipperCommand());
	}
	
	public void setFlywheelMotors(double speed) {
		flywheelMotorLeft.set(speed);
		flywheelMotorRight.set(speed);
	}

	public void setLiftMotor(double speedLift) {
			liftMotor.set(speedLift);  			
	}
	
	public double getDegrees() {
		return liftEnc.get();
	}

	public void resetEncoder() {
		liftEnc.reset();
	}
	
	public double getLeftFlywheelCurrent() {
		return Robot.pdp.getCurrent(Ports.LEFT_FLYWHEEL_PDP_CHANNEL);
		 
	}
	
	public double getRightFlywheelCurrent() { //returns amps of right flywheel motor
		return Robot.pdp.getCurrent(Ports.RIGHT_FLYWHEEL_PDP_CHANNEL);
		
	}
	
	public double getIRSensorVoltage() {
		return cuberIRSensor.getVoltage();
	}
	
	public double voltageToDistance(double voltage) {
		return 0; // TODO: convert voltage to distance
	}
	
}


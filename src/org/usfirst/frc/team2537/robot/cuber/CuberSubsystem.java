package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;
import org.usfirst.frc.team2537.robot.resources.CANTalon;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CuberSubsystem extends Subsystem {
	private CANTalon flywheelMotorLeft; 
	private CANTalon flywheelMotorRight;
	private CANTalon liftMotor;
	private DigitalInput flipperHallEffectOne;
//	private DigitalInput flipperHallEffectTwo;
	private Ultrasonic ultrasonic;
	public boolean ultrasonicOverride = false;
	public static final double FLYWHEEL_SPEED = .5;
	public static final double FLYWHEEL_CURRENT_LIMIT = 35; // TODO: determine max amps
	public static final double CUTOFF_DISTANCE = 2; // TODO: determine cutoff distance
	public static final int ULTRASONIC_RANGE = 3;
	public static final double FLIPPER_TIMEOUT = 5000; //TODO: Figure this one out
	

	
	public CuberSubsystem() {
		flywheelMotorLeft = new CANTalon(Ports.FLYWHEEL_MOTOR_LEFT);
		flywheelMotorRight = new CANTalon(Ports.FLYWHEEL_MOTOR_RIGHT);
		liftMotor = new CANTalon(Ports.FLIPPER_WINDOW_MOTOR);	
		ultrasonic = new Ultrasonic(Ports.CUBER_ULTRASONIC_TRIGGER, Ports.CUBER_ULTRASONIC_ECHO);
		ultrasonic.setAutomaticMode(true);
		flipperHallEffectOne = new DigitalInput(Ports.FLIPPER_HALL_EFFECT_TOP);
//		flipperHallEffectTwo = new DigitalInput(Ports.FLIPPER_HALL_EFFECT_BOTTOM);
		
		liftMotor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
		
		liftMotor.overrideLimitSwitchesEnable(true);
		
		
	}
	
	public void initDefaultCommand() {
		
	}
	
	public void registerButtons() { 
		HumanInput.registerWhileHeldCommand(HumanInput.cuberPickUpButton, new PickUpCommand());
		HumanInput.registerWhileHeldCommand(HumanInput.cuberPickUpButtonTwo, new PickUpCommand());
		HumanInput.registerWhileHeldCommand(HumanInput.cuberExpelFastButton, new ExpelCommand(0.7));
		HumanInput.registerWhileHeldCommand(HumanInput.cuberExpelSlowButton, new ExpelCommand(0.5));
		HumanInput.registerWhileHeldCommand(HumanInput.cuberFlipDownButton, new LowerFlipperCommand());
		HumanInput.registerWhileHeldCommand(HumanInput.cuberFlipUpButton, new LiftFlipperCommand());
		HumanInput.registerWhenPressedCommand(HumanInput.enableUltrasonicOverride, new Command() {

			@Override
			protected void initialize() {
				Robot.cuberSys.ultrasonicOverride = true;
			}
			
			@Override
			protected boolean isFinished() {
				return true;
			} 
			
		});
		HumanInput.registerWhenPressedCommand(HumanInput.disableUltrasonicOverride, new Command() {

			@Override
			protected void initialize() {
				Robot.cuberSys.ultrasonicOverride = false;
			}
			
			@Override
			protected boolean isFinished() {
				return true;
			} 
			
		});
	}
	
	public void setFlywheelMotors(double speed) {
		flywheelMotorLeft.set(speed);
		flywheelMotorRight.set(-speed);
	}

	public void setLiftMotor(double speedLift) {
			liftMotor.set(speedLift);  			
	}
	
	/*
	public double getLeftFlywheelCurrent() {
		return Robot.pdp.getCurrent(Ports.LEFT_FLYWHEEL_PDP_CHANNEL);
		 
	}
	
	public double getRightFlywheelCurrent() { //returns amps of right flywheel motor
		return Robot.pdp.getCurrent(Ports.RIGHT_FLYWHEEL_PDP_CHANNEL);
		
	}*/
	
	public double getUltrasonicInches() {
		return ultrasonic.getRangeInches();
	}
	
	public double getFlipperVoltage() {
		return liftMotor.getMotorOutputVoltage();
	}
	
	public boolean getHallEffectOne() {
		return !flipperHallEffectOne.get();
	}	
}


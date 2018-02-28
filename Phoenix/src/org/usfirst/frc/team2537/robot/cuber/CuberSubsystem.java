package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CuberSubsystem extends Subsystem {
	private Encoder flywheelEnc; 
	private Talon flywheelMotorLeft; 
	private Talon flywheelMotorRight;
	private Encoder windowEnc; 
	private Talon liftMotor; 
	private double radius = 2; //what units?//for getTime90Degrees() method (see below)
	private static final double PI = 3.14; //for getTime90Degrees() method (see below)
	private Ultrasonic ultrasonic;
	private DigitalInput limitSwitchLift;
	private DigitalInput limitSwitchLower;
	private double liftTime;
	
	//private double speedLift;
	//private double leftCurrent;
	//private double rightCurrent;
	 public static final double currentLimit = 134;  //constant for max amp	
	 
	public CuberSubsystem() { //constructors for cuberSubsys
		flywheelEnc = new Encoder(Ports.CUBER_ENCODER_A, Ports.CUBER_ENCODER_B, false, Encoder.EncodingType.k4X);
		flywheelMotorLeft = new Talon(Ports.FLYWHEEL_MOTOR_LEFT);
		flywheelMotorRight = new Talon(Ports.FLYWHEEL_MOTOR_RIGHT);
		liftMotor = new Talon(Ports.WINDOW_MOTOR);
		windowEnc = new Encoder(Ports.LIFT_ENCODER_A, Ports.LIFT_ENCODER_B, false, Encoder.EncodingType.k4X);
		ultrasonic = new Ultrasonic(Ports.ULTRASONIC_INPUT, Ports.ULTRASONIC_OUTPUT);
		limitSwitchLift = new DigitalInput(Ports.LIMIT_SWITCH_LIFT);
		limitSwitchLower = new DigitalInput(Ports.LIMIT_SWITCH_LOWER);
		
	}
	
	public void initDefaultCommand() {
		
	}
	
	public void registerButtons() { 
		HumanInput.registerWhileHeldCommand(HumanInput.pickUpButton, new PickUpCommand()); //corresponds to pickUp command
		HumanInput.registerWhileHeldCommand(HumanInput.expelButton, new ExpelCommand()); //corresponds to expel command
		HumanInput.registerWhileHeldCommand(HumanInput.lowerButton, new LowerFlipperCommand()); //corresponds to LowerFlipper command
		HumanInput.registerWhileHeldCommand(HumanInput.liftButton, new LiftFlipperCommand());//corresponds to LiftFlipper command
	}
	
	/*
	 * sets both left and right flywheel motor speed
	 */
	public void setFlywheelMotors(double speed) { 
		flywheelMotorLeft.set(speed);
		flywheelMotorRight.set(speed);
	}
	

	/**
	 * sets window motor speed
	 */
	public void setLiftMotor(double speedLift) { 
			liftMotor.set(speedLift);  			
	}
	
	
	public double getDegrees() { //returns degrees of lift/window motor
		return windowEnc.get();
	}

	public void resetEncoder() { //resets lift motor encoder
		windowEnc.reset();
	}
	
	public double getLeftFlywheelCurrent(){ // returns amps of left flywheel motor
		return Robot.pdp.getCurrent(Ports.LEFT_FLYWHEEL_PDP_CHANNEL);
	
	}
	
	public double getRightFlywheelCurrent() { //returns amps of right flywheel motor
		return Robot.pdp.getCurrent(Ports.RIGHT_FLYWHEEL_PDP_CHANNEL);
		
	}
	
	public double getWindowMotorCurrent() {
		return Robot.pdp.getCurrent(Ports.WINDOW_MOTOR_CHANNEL);
	}
	public double getUltrasonicDistance() { //returns distance of cube from  back of cuber
		return ultrasonic.getRangeInches();
	}
	
	public boolean checkLiftSwitch() {
		return limitSwitchLift.get();
	}
	
	public boolean checkLowerSwitch() {
		return limitSwitchLower.get();
	}
	
	/*public double getTimeForWindow() {
		return windowEnc.getPeriod();
	}
	
//BELOW COULD BE USED ONLY IF WE DONT HAVE SENSORS TO TURN WINDOW MOTOR ARM TO 90 DEGREES
	
	public double getTimefor90Degrees() { //this calculates time needed for arm to move from 0 degrees to 90 degrees in case we don't have sensors or stuff
		return ((radius*2*PI)/4)/speedLift; 
	}
	
	public void setTo90Degrees() {
		while(HumanInput.registerWhileHeldCommand(Button b, Command c) == true)
			if (actualTime == getTimefor90Degrees()) {
				liftMotor.set(speedLift);
			}
	}	
*/
	
}


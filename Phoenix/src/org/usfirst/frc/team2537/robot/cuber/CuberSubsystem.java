package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CuberSubsystem extends Subsystem {
	private Encoder flywheelEnc; //encoder for 2 flywheels
	private Talon flywheelMotorLeft; 
	private Talon flywheelMotorRight;
	private Encoder liftEnc; //window(lifting) motor encoder
	private Talon liftMotor; //window(lifting motor)
	private double radius = 2; //what units?//for getTime90Degrees() method (see below)
	private static final double PI = 3.14; //for getTime90Degrees() method (see below)
	//private double speedLift;
	//private double leftCurrent;
	//private double rightCurrent;
	private PowerDistributionPanel PDP; // pdp to measure current of flywheel motors
	 public static final double currentLimit = 134;  //constant for max amp
	
	
	public CuberSubsystem() { //constructors for cuberSubsys
		flywheelMotorLeft = new Talon(Ports.FLYWHEEL_MOTOR_LEFT);
		flywheelMotorRight = new Talon(Ports.FLYWHEEL_MOTOR_RIGHT);
		liftMotor = new Talon(Ports.WINDOW_MOTOR);
		liftEnc = new Encoder(Ports.LIFT_ENCODER_A, Ports.LIFT_ENCODER_B, false, Encoder.EncodingType.k4X);
		
		
	}
	
	public void initDefaultCommand() {
		
	}
	
	public void registerButtons() { 
		HumanInput.registerWhileHeldCommand(HumanInput.pickUpButton, new PickUpCommand()); //corresponds to pickUp command
		HumanInput.registerWhileHeldCommand(HumanInput.expelButton, new ExpelCommand()); //corresponds to expel command
		HumanInput.registerWhenPressedCommand(HumanInput.lowerButton, new LowerFlipperCommand()); //corresponds to LowerFlipper command
		HumanInput.registerWhenPressedCommand(HumanInput.raiseButton, new LiftFlipperCommand());//corresponds to LiftFlipper command
	}
	
	public void setFlywheelMotors(double speed) { //sets both left and right flywheel motor speed
		flywheelMotorLeft.set(speed);
		flywheelMotorRight.set(speed);
	}

	public void setLiftMotor(double speedLift) { //sets window motor speed
			liftMotor.set(speedLift);  			
	}
	
	public double getDegrees() { //returns degrees of lift/window motor
		return liftEnc.get();
	}

	public void resetEncoder() { //resets lift motor encoder
		liftEnc.reset();
	}
	
	public double getLeftFlywheelCurrent(){ // returns amps of left flywheel motor
		double leftCurrent = PDP.getCurrent(Ports.LEFT_FLYWHEEL_PDP_CHANNEL);
		return leftCurrent;
	}
	
	public double getRightFlywheelCurrent() { //returns amps of right flywheel motor
		double rightCurrent = PDP.getCurrent(Ports.RIGHT_FLYWHEEL_PDP_CHANNEL);
		return rightCurrent;
	}
	
//BELOW COULD BE USED ONLY IF WE DONT HAVE SENSORS TO TURN WINDOW MOTOR ARM TO 90 DEGREES
	/*
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


package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CuberSubsystem extends Subsystem {
	private Talon flywheelMotorLeft; 
	private Talon flywheelMotorRight;
	private Encoder liftEnc; //window(lifting) motor encoder
	private Talon liftMotor; //window(lifting motor)
	public final double currentLimit = 134;  //constant for max amp
	private DigitalInput cuberIRSensor;
	
	public CuberSubsystem() { //constructors for cuberSubsys
		flywheelMotorLeft = new Talon(Ports.FLYWHEEL_MOTOR_LEFT);
		flywheelMotorRight = new Talon(Ports.FLYWHEEL_MOTOR_RIGHT);
		liftMotor = new Talon(Ports.WINDOW_MOTOR);
		liftEnc = new Encoder(Ports.LIFT_ENCODER_A, Ports.LIFT_ENCODER_B, false, Encoder.EncodingType.k4X);
		cuberIRSensor = new DigitalInput(Ports.CUBER_IR);
		
		
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
		return Robot.pdp.getCurrent(Ports.LEFT_FLYWHEEL_PDP_CHANNEL);
		 
	}
	
	public double getRightFlywheelCurrent() { //returns amps of right flywheel motor
		return Robot.pdp.getCurrent(Ports.RIGHT_FLYWHEEL_PDP_CHANNEL);
		
	}
	
	public boolean getIRSensor() {
		return cuberIRSensor.get();
	}
	

	
}


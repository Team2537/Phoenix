package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;
import org.usfirst.frc.team2537.robot.resources.CANTalon;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CubeSubsystem extends Subsystem {
    Solenoid solea;
    Solenoid soleb;
    Timer time;
    Encoder encoderOne;
    Encoder encoderTwo;
    double encOneValue;
    double diameter;
    double circumference;
    double ticksInEncoder;
    double encOneDistance;
    Talon flywheelA;
    Talon flywheelB;
    

	
	public CubeSubsystem() {
    	solea = new Solenoid(Ports.SOLENOID_A);
    	soleb = new Solenoid(Ports.SOLENOID_B);
    	encoderOne = new Encoder(Ports.ENCODER_ONE_A,Ports.ENCODER_ONE_B, false, Encoder.EncodingType.k4X);
    	encoderTwo = new Encoder(Ports.ENCODER_TWO_A, Ports.ENCODER_TWO_B, false, Encoder.EncodingType.k4X);
    	diameter = 8;
    	circumference = diameter*Math.PI;
    	flywheelA = new Talon(Ports.FLYWHEEL_A);
    	flywheelB = new Talon(Ports.FLYWHEEL_B);
    	ticksInEncoder = 256;
    	
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public double getFlywheelA() {
    	return flywheelA.getSpeed();
    }
    
    public double getFlywheelB() {
    	return flywheelB.getSpeed();
    }
    
    public void setFlywheelA(double speed) {
    	flywheelA.set(speed);
    }
    
    public void setFlywheelB(double speed) {
    	flywheelB.set(-speed);
    }
    
    public void setBothFlywheels(double speed) {
    	setFlywheelA(speed);
    	setFlywheelB(speed);
    }
    
    public double getEncoderOne(){
    	return encoderOne.get();
    }
    
    public void resetEncoderOne(){
    	encoderOne.reset();
    }
    
    public void encoderOneToDistance(){
    	encOneValue = encoderOne.get();
    	encOneDistance = (encOneValue*circumference/ticksInEncoder);
    }
    
    
	
	public void startCompression() {
		solea.set(true);
	}
	
	public void endCloseArm() {
		solea.set(false);
	}
	
	public void endCompression() {
		soleb.set(true);
	}
	
	public void endOpenArm() {
		soleb.set(false);
	}
	
	public void registerButtons() {
    	HumanInput.registerWhenPressedCommand(HumanInput.clawGrabButton, new CubeGrabCommand());
    	HumanInput.registerWhenPressedCommand(HumanInput.clawReleaseButton, new CubeReleaseCommand());
    	
    }
}













package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class PIDSubsystem extends Subsystem {
    Encoder encoderOne;
    Encoder encoderTwo;
    double encOneValue;
    double diameter;
    double circumference;
    double encOneDistance;
    Talon flywheelA;
    Talon flywheelB;
    double p;
    double i;
    double d;
    double previousError;
    double setpoint;
    double error;
    
    

    public void initDefaultCommand() {
    	encoderOne = new Encoder(Ports.ENCODER_ONE_A,Ports.ENCODER_ONE_B, false, Encoder.EncodingType.k4X);
    	encoderTwo = new Encoder(Ports.ENCODER_TWO_A, Ports.ENCODER_TWO_B, false, Encoder.EncodingType.k4X);
    	diameter = 7.5;
    	circumference = diameter*Math.PI;
    	flywheelA = new Talon(Ports.FLYWHEEL_A);
    	flywheelB = new Talon(Ports.FLYWHEEL_B);
    	p = 0;
    	i = 0;
    	d = 0;
    	previousError = 0;
    	setpoint = 0;
    }
    
    public double getFlywheelA() {
    	return flywheelA.get();
    }
    
    public double getFlywheelB() {
    	return flywheelB.get();
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
    
    public void encoderOneToDistance(){
    	encOneValue = encoderOne.get();
    	encOneDistance = (encOneValue*circumference/360);
    }
    
    
    
    
    
}








package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;

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
    PIDController control;
    SpeedController motor;
    DifferentialDrive driveMotor;
    Gyro gyro;
    int p;
    int i;
    int d;
    double integral;
    int previousError;
    int setpoint;
    double error;
    double derivative;
    double rcw;
    

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
    	integral = 0;
    	previousError = 0;
    	setpoint = 0;
    	control.enable();
    }
    
    public void drive(Gyro gyro){
    	this.gyro = gyro;
    }
    
    public void setSetPoint(){
    	this.setpoint = setpoint;
    }
    
    public void pid(){
    	error = setpoint - gyro.getAngle();
    	this.integral = (error*.02);
    	derivative = (error - this.previousError) / .02;
    	this.rcw = p*error + i*this.integral + d*derivative;
    }
    
    public void encoderOneToDistance(){
    	encOneValue = encoderOne.get();
    	encOneDistance = (encOneValue*circumference/360);
    }
    
    
    
    
    
}








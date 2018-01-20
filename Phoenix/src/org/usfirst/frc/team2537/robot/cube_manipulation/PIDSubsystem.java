//package org.usfirst.frc.team2537.robot.cube_manipulation;
//
//import org.usfirst.frc.team2537.robot.Ports;
//import org.usfirst.frc.team2537.robot.input.HumanInput;
//
//import edu.wpi.first.wpilibj.AnalogPotentiometer;
//import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.interfaces.Potentiometer;
//
///**
// *
// */
//public class PIDSubsystem extends Subsystem {
//	double initialArmWidth;
//	double cubeWidth;
//    Encoder clawEncoder;
//    Compressor comp;
//    Solenoid sole;
//    double encValue;
//    double diameter;
//    double circumference;
//    double encDistance;
//    
//
//    public void initDefaultCommand() {
//    	initialArmWidth = 0;
//    	cubeWidth = 0;
//    	clawEncoder = new Encoder(Ports.ENCODER_A,Ports. ENCODER_B, false, Encoder.EncodingType.k4X);
//    	sole = new Solenoid(Ports.SOLENOID);
//    	comp = new Compressor(Ports.COMPRESSOR);
//    	diameter = 7.5;
//    	circumference = diameter*Math.PI;
//    	
//    }
//    
//    
//
//    
//    public void encodersToDistance(){
//    	encValue = clawEncoder.get();
//    	encDistance = (encValue*circumference/360);
//    }
//    
//    
//    
//    
//    
//}
//
//
//
//
//
//
//
//
//
//

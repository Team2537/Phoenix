package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;
import org.usfirst.frc.team2537.robot.resources.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CubeSubsystem extends Subsystem {
	double initialArmWidth;
	double cubeWidth;
    Encoder clawEncoder;
    Compressor comp;
    Solenoid solea;
    Solenoid soleb;
    double encValue;
    double diameter;
    double circumference;
    double encDistance;
    Timer time;
	
	
	public CubeSubsystem() {
		initialArmWidth = 0;
    	cubeWidth = 0;
    	clawEncoder = new Encoder(Ports.ENCODER_A,Ports. ENCODER_B, false, Encoder.EncodingType.k4X);
    	solea = new Solenoid(Ports.SOLENOID_A);
    	soleb = new Solenoid(Ports.SOLENOID_B);
//    	comp = new Compressor(Ports.COMPRESSOR);
    	diameter = 7.5;
    	circumference = diameter*Math.PI;
    	time = new Timer();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
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
	
	public void encodersToDistance(){
    	encValue = clawEncoder.get();
    	encDistance = (encValue*circumference/360);
    }
	
	
	
	
	public void registerButtons() {
    	HumanInput.registerWhenPressedCommand(HumanInput.clawGrabButton, new CubeGrabCommand());
    	HumanInput.registerWhenPressedCommand(HumanInput.clawReleaseButton, new CubeReleaseCommand());
    }
}













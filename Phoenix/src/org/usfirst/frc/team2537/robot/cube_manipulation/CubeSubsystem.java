package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;
import org.usfirst.frc.team2537.robot.resources.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CubeSubsystem extends Subsystem {
	double initialArmWidth;
	double cubeWidth;
    Encoder clawEncoder;
    Compressor comp;
    Solenoid sole;
    double encValue;
    double diameter;
    double circumference;
    double encDistance;
	
	
	public CubeSubsystem() {
		initialArmWidth = 0;
    	cubeWidth = 0;
    	clawEncoder = new Encoder(Ports.ENCODER_A,Ports. ENCODER_B, false, Encoder.EncodingType.k4X);
    	sole = new Solenoid(Ports.SOLENOID);
    	comp = new Compressor(Ports.COMPRESSOR);
    	diameter = 7.5;
    	circumference = diameter*Math.PI;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void startCompression() {
		sole.set(true);
	}
	
	public void endCompression() {
		sole.set(false);
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













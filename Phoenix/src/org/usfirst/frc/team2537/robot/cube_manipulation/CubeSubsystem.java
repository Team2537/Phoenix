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
    Solenoid solea;
    Solenoid soleb;
    Timer time;
	
	
	public CubeSubsystem() {
    	solea = new Solenoid(Ports.SOLENOID_A);
    	soleb = new Solenoid(Ports.SOLENOID_B);
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
	
	public void registerButtons() {
    	HumanInput.registerWhenPressedCommand(HumanInput.clawGrabButton, new CubeGrabCommand());
    	HumanInput.registerWhenPressedCommand(HumanInput.clawReleaseButton, new CubeReleaseCommand());
    }
}













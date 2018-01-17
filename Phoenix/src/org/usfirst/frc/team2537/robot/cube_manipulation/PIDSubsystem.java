package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Ports;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class PIDSubsystem extends Subsystem {
	
	double cubeWidth;
    Potentiometer clawPotentiometer;
    double offset;

    public void initDefaultCommand() {
    	offset = 0;
    	cubeWidth = 0;
    	clawPotentiometer = new AnalogPotentiometer(Ports.POTENTIOMETER_CHANNEL, Ports.POTENTOMETER_SCALE, offset);
    	
    	
    	
    }
    
    
    
    
}


package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CubeSubsystem extends Subsystem {
    private Solenoid solea;
    private Solenoid soleb;

   /* Timer time;
    Encoder encoderOne;
    Encoder encoderTwo;
    double encOneValue;
    double diameter;
    double circumference;
    double ticksInEncoder;
    double encOneDistance;
    CANTalon flywheelA;
    CANTalon flywheelB;
   */ 

	
	public CubeSubsystem() {
    	solea = new Solenoid(Ports.SOLENOID_A);
    	soleb = new Solenoid(Ports.SOLENOID_B);
    /*	diameter = 8;
    	circumference = diameter*Math.PI;
    	flywheelA = new CANTalon(Ports.FLYWHEEL_A);
    	flywheelB = new CANTalon(Ports.FLYWHEEL_B);
    	ticksInEncoder = 256;
    	*/
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
/*	public double getFlywheelA() {
		flywheelA.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		return flywheelA.getSelectedSensorVelocity(0);
		
    }
    
    public double getFlywheelB() {
    	flywheelB.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		return flywheelB.getSelectedSensorVelocity(0);
		
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
    
*/    
	
	public void openGrabPiston() {
		solea.set(true);
	}
	
	public void closeGrabPiston() {
		solea.set(false);
	}
	
	public void openStartPiston() {
		soleb.set(true);
	}
	
	public void closeStartPiston() {
		soleb.set(false);
	}
	
	public void registerButtons() {
		HumanInput.registerWhenPressedCommand(HumanInput.clawGrabButton, new CubeGrabCommand());
		HumanInput.registerWhenPressedCommand(HumanInput.cubeFlipperReleaseButton, new CubeStartCommand());
//    	HumanInput.registerWhenPressedCommand(HumanInput.clawReleaseButton, new CubeReleaseCommand());
   	
    }
}













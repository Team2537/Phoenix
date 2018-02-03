package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * creates solenoids and methods to control them
 * registers buttons for commands
 */
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

	/**
	 * creates the solenoids and assigns ports to them
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
	
	/**
	 * starts to apply the pressure
	 */
	public void openGrabPiston() {
		solea.set(true);
	}
	
	/**
	 * stops the pressure
	 */
	public void closeGrabPiston() {
		solea.set(false);
	}
	
	/**
	 * applies pressure
	 */
	public void openStartPiston() {
		soleb.set(true);
	}
	
	/**
	 * stops pressure
	 */
	public void closeStartPiston() {
		soleb.set(false);
	}
	
	/**
	 * registers buttons so that when they are pressed, the respective command starts	
	 */
	public void registerButtons() {
		HumanInput.registerWhenPressedCommand(HumanInput.clawGrabButton, new CubeGrabCommand());
		HumanInput.registerWhenPressedCommand(HumanInput.cubeFlipperReleaseButton, new CubeStartCommand());
//    	HumanInput.registerWhenPressedCommand(HumanInput.clawReleaseButton, new CubeReleaseCommand());
   	
    }
}

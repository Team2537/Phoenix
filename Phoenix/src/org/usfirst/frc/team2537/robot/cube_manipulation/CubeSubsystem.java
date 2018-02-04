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
    private Solenoid manipulatorSolenoidA;
    private Solenoid manipulatorSolenoidB;
    private Solenoid flipSolenoidA;
    private Solenoid flipSolenoidB;

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
    	manipulatorSolenoidA = new Solenoid(Ports.MANIPULATOR_SOLENOID_A);
    	manipulatorSolenoidB = new Solenoid(Ports.MANIPULATOR_SOLENOID_B);
    	flipSolenoidA = new Solenoid(Ports.FLIP_SOLENOID_A);
    	flipSolenoidB = new Solenoid(Ports.FLIP_SOLENOID_B);
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
	
	// Methods used for setup
	
	/**
	 * opens manipulator
	 */
	public void openGrabPiston() {
		manipulatorSolenoidA.set(true);
	}
	
	/**
	 * stops opening manipulator
	 */
	public void stopOpenGrabPiston() {
		manipulatorSolenoidA.set(false);
	}
	
	/**
	 * closes manipulator
	 */
	public void openReleasePiston() {
		manipulatorSolenoidB.set(true);
	}
	
	/**
	 * stops closing manipulator
	 */
	public void closeReleasePiston() {
		manipulatorSolenoidB.set(false);
	}
	
	/**
	 * flips down manipulator
	 */
	public void openFlipper() {
		flipSolenoidA.set(true);
	}
	
	/**
	 * stops flipping down manipulator
	 */
	public void stopOpenFlipper() {
		flipSolenoidA.set(false);
	}
	
	/**
	 * flips up manipulator
	 */
	public void closeFlipper() {
		flipSolenoidB.set(true);
	}
	
	/**
	 * stops flipping up manipulator
	 */
	public void stopCloseFlipper() {
		flipSolenoidB.set(false);
	}
	
	/**
	 * registers buttons so that when they are pressed, the respective command starts	
	 */
	public void registerButtons() {
		HumanInput.registerWhenPressedCommand(HumanInput.cubeGrabButton, new CubeGrabCommand());
		HumanInput.registerWhenPressedCommand(HumanInput.cubeReleaseButton, new CubeReleaseCommand());
		HumanInput.registerWhenPressedCommand(HumanInput.cubeFlipDownButton, new CubeFlipDownCommand());
		HumanInput.registerWhenPressedCommand(HumanInput.cubeFlipUpButton, new CubeFlipUpCommand());
    }
}

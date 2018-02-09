package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CuberSubsystem extends Subsystem {
	private Encoder flywheelEnc; //encoder for 2 flywheels
	private Talon flywheelMotorLeft; 
	private Talon flywheelMotorRight;
	private Encoder liftEnc; //window(lifting) motor encoder
	private Talon liftMotor; //window(lifting motor)
	private double radius = 2; //what units?//for getTime90Degrees() method (see below)
	private static final double PI = 3.14; //for getTime90Degrees() method (see below)
	private double speedLift; 
	
	
	public CuberSubsystem() { 
		flywheelEnc = new Encoder(Ports.CUBER_ENCODER_A, Ports.CUBER_ENCODER_B, false, Encoder.EncodingType.k4X);
		flywheelMotorLeft = new Talon(Ports.FLYWHEEL_MOTOR_LEFT);
		flywheelMotorRight = new Talon(Ports.FLYWHEEL_MOTOR_RIGHT);
		liftMotor = new Talon(Ports.WINDOW_MOTOR);
		liftEnc = new Encoder(Ports.LIFT_ENCODER_A, Ports.LIFT_ENCODER_B, false, Encoder.EncodingType.k4X);
	}
	
	public void initDefaultCommand() {
		
	}
	
	public void registerButtons() { //registers buttons when held and directs to either pick up command or expel command
		HumanInput.registerWhileHeldCommand(HumanInput.pickUpButton, new PickUpCommand()); 
		HumanInput.registerWhileHeldCommand(HumanInput.expelButton, new ExpelCommand()); 
	}
	
	public void setFlywheelMotors(double speed) { //sets both left and right flywheel motor speed
		flywheelMotorLeft.set(speed);
		flywheelMotorRight.set(speed);
	}
	
	public void setLiftMotor(double speedLift) { //sets window motor speed
			liftMotor.set(speedLift);  
	}
//BELOW COULD BE USED ONLY IF WE DONT HAVE SENSORS TO TURN WINDOW MOTOR ARM TO 90 DEGREES
	/*
	public double getTimefor90Degrees() { //this calculates time needed for arm to move from 0 degrees to 90 degrees in case we don't have sensors or stuff
		return ((radius*2*PI)/4)/speedLift; //use to raise arm to 90
	}
	
	public void setTo90Degrees() {
		while(HumanInput.registerWhileHeldCommand(Button b, Command c) == true)
			if (actualTime == getTimefor90Degrees()) {
				liftMotor.set(speedLift);
			}
	}	
*/
	
}


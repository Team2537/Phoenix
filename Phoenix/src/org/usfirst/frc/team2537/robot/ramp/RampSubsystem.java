package org.usfirst.frc.team2537.robot.ramp;

//
import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RampSubsystem extends Subsystem {

	
	private Servo rampOpenServo;
	public RampSubsystem() {
		rampOpenServo = new Servo(Ports.RAMP_SERVO);//creation of servo object and assignment to port value
	}

	@Override
	protected void initDefaultCommand() {
		
	}

	public void registerButtons() {
		HumanInput.registerWhenPressedCommand(HumanInput.rampLowerButton, new OpenRampCommand());
		HumanInput.registerWhenPressedCommand(HumanInput.rampRaiseButton, new CloseRampCommand());
	}

	public void openRamp() {
		rampOpenServo.setAngle(180); //servo set to 180 degrees
	}
	public void closeRamp() {
		rampOpenServo.setAngle(0);//servo set to 0 degrees
	}
}






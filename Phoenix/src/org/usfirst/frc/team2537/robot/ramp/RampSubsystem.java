package org.usfirst.frc.team2537.robot.ramp;

//
import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RampSubsystem extends Subsystem {

	private Solenoid rampLowerSole;
	private Solenoid rampRaiseSole;
	private Servo rampServo;

	public RampSubsystem() {
		rampLowerSole = new Solenoid(Ports.RAMP_LOWER_SOLENOID);
		rampRaiseSole = new Solenoid(Ports.RAMP_RAISE_SOLENOID);
		rampServo = new Servo(Ports.RAMP_SERVO);
	}

	@Override
	protected void initDefaultCommand() {
		
	}

	public void registerButtons() {
		HumanInput.registerWhenPressedCommand(HumanInput.rampLowerButton, new OpenRampCommand());
		HumanInput.registerWhenPressedCommand(HumanInput.rampRaiseButton, new CloseRampCommand());
	}

	public void lowerRampServo() {
		rampServo.setAngle(120);
	}

	public void raiseRampServo() {
		rampServo.setAngle(0);
	}
	
	public void lowerRampSoleOn() {
		rampLowerSole.set(true);
	}
	
	public void lowerRampSoleOff() {
		rampLowerSole.set(false);
	}
	
	public void raiseRampSoleOn() {
		rampRaiseSole.set(true);
	}
	
	public void raiseRampSoleOff() {
		rampRaiseSole.set(false);
	}
	
}

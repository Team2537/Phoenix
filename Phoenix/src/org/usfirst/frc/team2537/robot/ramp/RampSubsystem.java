package org.usfirst.frc.team2537.robot.ramp;

//
import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RampSubsystem extends Subsystem {

	private Servo rampServo;
	public boolean isOpen = false;

	public RampSubsystem() {
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
		rampServo.setAngle(90);
	}

	public void raiseRampServo() {
		rampServo.setAngle(0);
	}
	
}

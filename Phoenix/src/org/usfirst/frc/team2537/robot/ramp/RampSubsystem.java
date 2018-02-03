package org.usfirst.frc.team2537.robot.ramp;

//
import org.usfirst.frc.team2537.robot.Ports;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RampSubsystem extends Subsystem {

	private Solenoid solea;
	private Servo servo;

	public RampSubsystem() {
		solea = new Solenoid(Ports.SOLENOID_C);
		servo = new Servo(Ports.SERVO_MOTOR);
	}

	@Override
	protected void initDefaultCommand() {
	}

	public void registerButtons() {
		
	}

	public void openLatch() {
		servo.setAngle(120);
	}

	public void raiseRamp() {
		servo.setAngle(0);
	}
	
	public void openRampPiston() {
		solea.set(true);
	}
	
}

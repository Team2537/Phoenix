package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;
import org.usfirst.frc.team2537.robot.resources.CANTalon;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class VertSubsystem extends Subsystem {

	private CANTalon vertMotorOne;
	private CANTalon vertMotorTwo;
	private DigitalInput limitSwitch;
	double current;
	private DigitalInput vertBeamBreak;

	public VertSubsystem() { 
		vertMotorOne = new CANTalon(Ports.VERT_MOTOR_ONE);
		vertMotorTwo = new CANTalon(Ports.VERT_MOTOR_TWO);
		
		vertMotorOne.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		
		vertMotorTwo.setControlMode(ControlMode.Follower);
		vertMotorTwo.follow(vertMotorOne);
		
		limitSwitch = new DigitalInput(Ports.VERT_LIMIT_SWITCH);
		vertBeamBreak = new DigitalInput(Ports.VERT_BEAM_BREAK_RECEIVER);
	}

	public void initDefaultCommand() {

	}
	
	public void registerButtons() {
		HumanInput.registerWhileHeldCommand(HumanInput.vertRaiseButton, new VertUpCommand());
		HumanInput.registerWhileHeldCommand(HumanInput.vertLowerButton, new VertDownCommand());

	}

	public void setVertMotors(double speed) {
		// CHECK THAT THESE ARE CORRECT BEFORE STARTING TO AVOID DESTROYING GEARBOX
		vertMotorOne.set(speed);
		
	
	}
	
	public double getEncoderPos() {
		return vertMotorOne.getSelectedSensorPosition(0)*-1;
	}
	
	public void resetEncoder() {
		vertMotorOne.getSensorCollection().setQuadraturePosition(0, 0);
	}
	
	public boolean getLimitSwitch() {
		return limitSwitch.get();
	}
	
	public boolean getBeamBreak() {
		return vertBeamBreak.get();
	}

}

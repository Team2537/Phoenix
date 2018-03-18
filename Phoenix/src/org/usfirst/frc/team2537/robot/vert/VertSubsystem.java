package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;
import org.usfirst.frc.team2537.robot.resources.CANTalon;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class VertSubsystem extends Subsystem {

//	private CANTalon vertMotorOne;
//	private CANTalon vertMotorTwo;
	private DigitalInput limitSwitch;
	public boolean enableReadSwitch = true;
	double current;

	public VertSubsystem() { 
//		vertMotorOne = new CANTalon(Ports.VERT_MOTOR_ONE);
//		vertMotorTwo = new CANTalon(Ports.VERT_MOTOR_TWO);
//		
//		vertMotorOne.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
//		
//		vertMotorTwo.setControlMode(ControlMode.Follower);
//		vertMotorTwo.follow(vertMotorOne);
		
		//limitSwitch = new DigitalInput(Ports.VERT_LIMIT_SWITCH);
	}

	public void initDefaultCommand() {
		this.setDefaultCommand(new HoldCommand());
	}
	
	public void registerButtons() {
		HumanInput.registerWhileHeldCommand(HumanInput.vertRaiseButton, new VertUpCommand());
		HumanInput.registerWhileHeldCommand(HumanInput.vertLowerButton, new VertDownCommand());
		HumanInput.registerWhenPressedCommand(HumanInput.vertOverrideButton, new Command() {

			@Override
			protected void initialize() {
				Robot.vertSys.enableReadSwitch = false;
			}
			
			@Override
			protected boolean isFinished() {
				return true;
			} 
			
		});
		HumanInput.registerWhenPressedCommand(HumanInput.vertUnderrideButton, new Command() {

			@Override
			protected void initialize() {
				Robot.vertSys.enableReadSwitch = true;
			}
			
			@Override
			protected boolean isFinished() {
				return true;
			} 
			
		});

	}

	public void setVertMotors(double speed) {
		// CHECK THAT THESE ARE CORRECT BEFORE STARTING TO AVOID DESTROYING GEARBOX
//		vertMotorOne.set(speed);
		
	
	}
	
	public double getEncoderPos() {
//		return vertMotorOne.getSelectedSensorPosition(0)*-1;
		return 0;
	}
	
	public void resetEncoder() {
//		vertMotorOne.getSensorCollection().setQuadraturePosition(0, 0);
//		vertMotorOne.getSensorCollection().setQuadraturePosition(0, 0);
//		vertMotorOne.getSensorCollection().setQuadraturePosition(0, 0);
//		vertMotorOne.getSensorCollection().setQuadraturePosition(0, 0);
	}
	
	public boolean getLimitSwitch() {
		//return !limitSwitch.get() && enableReadSwitch;
		return false;
	}
	
}

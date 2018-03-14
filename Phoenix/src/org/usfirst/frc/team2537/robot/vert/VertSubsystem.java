package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;
import org.usfirst.frc.team2537.robot.resources.CANTalon;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;


public class VertSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private Encoder vertEnc;
	private TalonSRX vertMotorOne;
	private TalonSRX vertMotorTwo;
	private PowerDistributionPanel PDP;
	private DigitalInput limitSwitchDown;
	private DigitalInput limitSwitchUp;
	double speed;
	private double P = .2; //proportional value
	private double I = .1; //integral value
	private double D = .1; //derivative value
	private double F = 0; // f gain
	public double targetVelocity = (23/5) * (1/1) * (1/(Math.PI*2)) * (360/1) * (1/10); //for PID loop and sets speed of motors
							//(23 in./5s) x (1 rad/1in.) x (1 rev/2Pi rad) x (360 ticks/1 rev) x (1 s/10 100 ms)
	
	
	
	public VertSubsystem() {
		vertEnc = new Encoder(Ports.VERT_ENC_A, 1, false, Encoder.EncodingType.k4X);
		vertMotorOne = new TalonSRX(Ports.VERT_MOTOR_ONE);
		vertMotorTwo = new TalonSRX(Ports.VERT_MOTOR_TWO);
		PDP = new PowerDistributionPanel(Ports.PDP);
		limitSwitchDown = new DigitalInput(Ports.LIMIT_SWITCH_DOWN);
		limitSwitchUp = new DigitalInput(Ports.LIMIT_SWITCH_UP);
		vertMotorOne.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0); //PID loop main encoder on vertMotorOne; for type of feedback device, 
		vertMotorTwo.set(ControlMode.Follower, Ports.VERT_MOTOR_ONE); //corresponds to actions of vertMotorOne
		
		vertMotorOne.config_kP(Ports.VERT_MOTOR_ONE, P, 0); //0 ID port, P value, 0 timeoutMs (none)
		vertMotorOne.config_kI(Ports.VERT_MOTOR_ONE, I, 0); //0 ID port, I value, 0 timeoutMs (none)
		vertMotorOne.config_kD(Ports.VERT_MOTOR_ONE, D, 0); //0 ID port, D value, 0 timeoutMs (none)
		vertMotorOne.config_kF(Ports.VERT_MOTOR_ONE, F, 0); //0 ID port, K value, 0 timeoutMs (none)
		
	}

	public void initDefaultCommand() {

	}

	// makes sure command works when button held
	public void registerButtons() {
		HumanInput.registerWhileHeldCommand(HumanInput.vertRaiseButton, new VertUpCommand());
		HumanInput.registerWhileHeldCommand(HumanInput.vertLowerButton, new VertDownCommand());

	}

	// sets speed of vertMotors
	public void setVertMotors(double speed) {
		 vertMotorOne.set(ControlMode.Velocity, speed); 
		 vertMotorTwo.set(ControlMode.Velocity, speed);
	}
	

	public boolean getLimitSwitchUp() {
		return limitSwitchUp.get(); //This bit of code is used to get the output of the limit switch on the top of the Vertical Actuator.  
	}

	public boolean getLimitSwitchDown() {
		return limitSwitchDown.get(); //This bit of code is used to get the output of the limit switch on the bottom of the Vertical Actuator.
	}
	
	
	// returns current of vert motor one
	public double getCurrentOne() {
		return PDP.getCurrent(Ports.VERT_MOTOR_ONE_PDP_CHANNEL); //

	}

	// returns current of vert motor two
	public double getCurrentTwo() {
		return PDP.getCurrent(Ports.VERT_MOTOR_TWO_PDP_CHANNEL);

	}
	
	public double getSpeedVertMotorOne() { //returns speed of motors
		return vertEnc.getRate();
	}
	
	
	public void keepVertUp() {
		
	}
	//things that need work
	//is setVertMotors method correct?
	//merge both up and down into one method
	//possibly don't set it completely to 0 when it comes down
	//check PID values through testing or calculations
	
	//RAISE CUBER FIRST TO PREVENT GETTING STUCK
}

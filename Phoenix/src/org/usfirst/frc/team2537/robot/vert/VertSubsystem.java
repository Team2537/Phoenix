package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;
import org.usfirst.frc.team2537.robot.resources.CANTalon;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class VertSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private Encoder vertEnc;
	private TalonSRX vertMotorOne;
	private TalonSRX vertMotorTwo;
	private PowerDistributionPanel PDP;
	private DigitalInput limitswitch;
	double speed;

	

	public VertSubsystem() {

		vertEnc = new Encoder(Ports.VERT_ENC_A, Ports.VERT_ENC_B, false, Encoder.EncodingType.k4X);
		vertMotorOne = new TalonSRX(Ports.VERT_MOTOR_ONE);
		vertMotorTwo = new TalonSRX(Ports.VERT_MOTOR_TWO);
		PDP = new PowerDistributionPanel(Ports.PDP);
		limitswitch = new DigitalInput(Ports.LIMIT_SWITCH);

	}

	public void initDefaultCommand() {

	}

	// makes sure command works when button held
	public void registerButtons() {
		HumanInput.registerWhileHeldCommand(HumanInput.raiseButton, new VertUpCommand());
		HumanInput.registerWhileHeldCommand(HumanInput.lowerButton, new VertDownCommand());

	}

	// receives distance robot travels with encoders
	public int getDistance() {
		return vertEnc.get();

	}

	// sets speed of vertMotors
	public void setVertMotors(double speed) {
		// vertMotorOne.set(speed);
		// vertMotorTwo.set(-speed);
	}

	public boolean getLimitSwitch() {
		return limitswitch.get();

	}

	// returns current of vert motor one
	public double getCurrentOne() {
		return PDP.getCurrent(Ports.VERT_MOTOR_ONE_PDP_CHANNEL);

	}

	// returns current of vert motor two
	public double getCurrentTwo() {
		return PDP.getCurrent(Ports.VERT_MOTOR_TWO_PDP_CHANNEL);

	}

	
}

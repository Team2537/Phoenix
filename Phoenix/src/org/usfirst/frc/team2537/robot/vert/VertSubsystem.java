package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;
import org.usfirst.frc.team2537.robot.resources.CANTalon;

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
	private CANTalon vertMotorOne;
	private CANTalon vertMotorTwo;
	private PowerDistributionPanel PDP;
	private Ultrasonic ultrasonic;

	public VertSubsystem() {
		vertEnc = new Encoder(Ports.VERT_ENC_A, Ports.VERT_ENC_B, false, Encoder.EncodingType.k4X);
		vertMotorOne = new CANTalon(Ports.VERT_MOTOR_ONE);
		vertMotorTwo = new CANTalon(Ports.VERT_MOTOR_TWO);
		PDP = new PowerDistributionPanel(Ports.PDP);

		ultrasonic = new Ultrasonic(Ports.ULTRASONIC_INPUT, Ports.ULTRASONIC_OUTPUT); // help
	}

	public void initDefaultCommand() {

	}

	public void registerButtons() {
		HumanInput.registerWhileHeldCommand(HumanInput.raiseButton, new VertUpCommand());
		HumanInput.registerWhileHeldCommand(HumanInput.lowerButton, new VertDownCommand());

	}

	public int getDistance() {
		return vertEnc.get();
	}

	public void setVertMotors(double speed) {
		vertMotorOne.set(speed);
		vertMotorTwo.set(-speed);
	}

	public double getAmperage(int channel) {
		return PDP.getCurrent(channel);
	}

	public boolean checkAmperage() {
		if (PDP.getCurrent(1) >= 3)
			return true;
		return false;
	}

	public double getUltrasonic() {
		return ultrasonic.getRangeInches();
	}

}

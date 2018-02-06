package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class VertSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private Talon vertMotorOne;
	private Talon vertMotorTwo;
	private PowerDistributionPanel PDP;

	public VertSubsystem() {
		vertMotorOne = new Talon(Ports.VERT_MOTOR_ONE);
		vertMotorTwo = new Talon(Ports.VERT_MOTOR_TWO);
		PDP = new PowerDistributionPanel(Ports.PDP);

	}

	public void initDefaultCommand() {

	}

	public void registerButtons() {
		HumanInput.registerWhileHeldCommand(HumanInput.raiseButton, new VertUpCommand());
		HumanInput.registerWhileHeldCommand(HumanInput.lowerButton, new VertDownCommand());

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



}

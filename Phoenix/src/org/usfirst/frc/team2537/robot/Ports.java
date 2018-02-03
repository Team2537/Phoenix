package org.usfirst.frc.team2537.robot;

import edu.wpi.first.wpilibj.SerialPort.Port;

public class Ports {
	// TODO: Change ports to line up with actual ports

	// Drive Talon Ports
	public static final int FRONT_LEFT_MOTOR = 1, FRONT_RIGHT_MOTOR = 2, BACK_LEFT_MOTOR = 3, BACK_RIGHT_MOTOR = 2;

	// Joystick and XBox Ports
	//public static final int LEFT_JOYSTICK = 0, RIGHT_JOYSTICK = 1;
	public static final int XBOX=0;
	
	public static final edu.wpi.first.wpilibj.SerialPort.Port RASPI = Port.kMXP;
}

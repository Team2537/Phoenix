package org.usfirst.frc.team2537.robot;

import edu.wpi.first.wpilibj.SerialPort.Port;

public class Ports {
	// Joysticks
	public static final int LEFT_JOYSTICK = 1, RIGHT_JOYSTICK = 2;

	// Buttons
	public static final int RAISE_BUTTON = 1, LOWER_BUTTON = 2;
	public static final int CLIMB_ON_BUTTON = 3, CLIMB_OFF_BUTTON = 2;
	public static final int OVERRIDE_KEY_ONE = 6, OVERRIDE_KEY_TWO = 7, OVERRIDE_KEY_THREE = 8;
	public static final int RAMP_LOWER_BUTTON = 4, RAMP_RAISE_BUTTON = 5;

	// Talons
	public static final int VERT_MOTOR_ONE = 2, VERT_MOTOR_TWO = 3;
	public static final int CLIMB_MOTOR_ONE = 4, CLIMB_MOTOR_TWO = 5, CLIMB_MOTOR_THREE = 6;

	// Encoders
	public static final int VERT_ENC_A = 1, VERT_ENC_B = 2;

	// Drive Motors
	public static final int FRONT_LEFT_MOTOR = 0, FRONT_RIGHT_MOTOR = 1, BACK_LEFT_MOTOR = 2, BACK_RIGHT_MOTOR = 3;

	// limit switches
	public static final int LIMIT_SWITCH = 0, LIMIT_SWITCH_A = 8, LIMIT_SWITCH_B = 11;

	// Servo
	public static final int RAMP_SERVO = 9;

	// Encoders
	public static final int LEFT_ENC_A = 0, LEFT_ENC_B = 1;
	public static final int RIGHT_ENC_A = 2, RIGHT_ENC_B = 3;

	// Solenoids
	public static final int RAMP_LOWER_SOLENOID = 5, RAMP_RAISE_SOLENOID = 4;

	public static final edu.wpi.first.wpilibj.SerialPort.Port RASPI = Port.kMXP;
}


package org.usfirst.frc.team2537.robot;

import edu.wpi.first.wpilibj.SerialPort.Port;

public class Ports {
	// Joysticks
	public static final int LEFT_JOYSTICK = 0, RIGHT_JOYSTICK = 1;

	// Buttons
	public static final int VERT_RAISE_BUTTON = 3, VERT_LOWER_BUTTON = 2;

	public static final int CLIMB_ON_BUTTON = 3, CLIMB_OFF_BUTTON = 2;

	public static final int OVERRIDE_KEY_ONE = 6, OVERRIDE_KEY_TWO = 7, OVERRIDE_KEY_THREE = 8;

	public static final int RAMP_LOWER_BUTTON = 4, RAMP_RAISE_BUTTON = 5;

	public static final int CUBE_GRAB_BUTTON = 1, CUBE_RELEASE_BUTTON = 1;

	public static final int FLIP_MANIPULATOR_DOWN_BUTTON = 4, FLIP_MANIPULATOR_UP_BUTTON = 5;

	// Talons
	public static final int VERT_MOTOR_ONE = 2, VERT_MOTOR_TWO = 3;

	public static final int CLIMB_MOTOR_ONE = 4, CLIMB_MOTOR_TWO = 5, CLIMB_MOTOR_THREE = 6;

	// Drive Motors
	public static final int FRONT_LEFT_MOTOR = 1, FRONT_RIGHT_MOTOR = 0, BACK_LEFT_MOTOR = 3, BACK_RIGHT_MOTOR = 2;

	// limit switches
	public static final int LIMIT_SWITCH = 0;

	// Servo
	public static final int RAMP_SERVO = 9;

	// Solenoids
	public static final int RAMP_LOWER_SOLENOID = 5, RAMP_RAISE_SOLENOID = 4;

	public static final int MANIPULATOR_SOLENOID_A = 0, MANIPULATOR_SOLENOID_B = 1;

	public static final int FLIP_SOLENOID_A = 2, FLIP_SOLENOID_B = 3;

	// potentiometers
	public static final int POTENTIOMETER_CHANNEL = 3, POTENTOMETER_SCALE = 360;

	public static final int FLYWHEEL_A = 1, FLYWHEEL_B = 2;

	// Power Distribution Panel
	public static final int PDP = 0;

	// Ultrasonic
	public static final int ULTRASONIC_INPUT = 0, ULTRASONIC_OUTPUT = 1;
	
	// PDP Channels
	public static final int VERT_MOTOR_ONE_PDP_CHANNEL = 5;
	
	public static final int VERT_MOTOR_TWO_PDP_CHANNEL = 4;
	
	//Encoders
	public static final int VERT_ENC_TRIGGER = 4, VERT_ENC_ECHO = 5;

	public static final edu.wpi.first.wpilibj.SerialPort.Port RASPI = Port.kMXP;



}

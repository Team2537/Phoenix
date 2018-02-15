package org.usfirst.frc.team2537.robot;

import edu.wpi.first.wpilibj.SerialPort.Port;

public class Ports {
	
	// PDP Channels
	public static final int LEFT_FLYWHEEL_PDP_CHANNEL = 6, RIGHT_FLYWHEEL_PDP_CHANNEL = 7;
	
	public static final int CLIMB_MOTOR_ONE_PDP = 2, CLIMB_MOTOR_TWO_PDP = 1, CLIMB_MOTOR_THREE_PDP = 0;
	
	/**********Input**********/
	
	// Joysticks
	public static final int LEFT_JOYSTICK = 0, RIGHT_JOYSTICK = 1;

	// Buttons
	public static final int VERT_RAISE_BUTTON = 3, VERT_LOWER_BUTTON = 2;

	public static final int CLIMB_ON_BUTTON = 3, CLIMB_OFF_BUTTON = 2;

	public static final int OVERRIDE_KEY_ONE = 6, OVERRIDE_KEY_TWO = 7, OVERRIDE_KEY_THREE = 8;

	public static final int RAMP_LOWER_BUTTON = 4, RAMP_RAISE_BUTTON = 5;

	public static final int FLIP_MANIPULATOR_DOWN_BUTTON = 4, FLIP_MANIPULATOR_UP_BUTTON = 5;
	
	public static final int PICK_UP_BUTTON = 1, EXPEL_BUTTON = 1, LIFT_BUTTON = 5, LOWER_BUTTON = 4;

	/**********Motors**********/

	// Talons
	public static final int VERT_MOTOR_ONE = 4, VERT_MOTOR_TWO = 5;

	public static final int CLIMB_MOTOR_ONE = 1, CLIMB_MOTOR_TWO = 2, CLIMB_MOTOR_THREE = 3;
	
	public static final int FLYWHEEL_MOTOR_LEFT = 0, FLYWHEEL_MOTOR_RIGHT = 2;
	
	public static final int WINDOW_MOTOR = 2;

	// Drive Motors
	public static final int FRONT_LEFT_MOTOR = 0, FRONT_RIGHT_MOTOR = 1, BACK_LEFT_MOTOR = 2, BACK_RIGHT_MOTOR = 3;

	// Servo
	public static final int RAMP_SERVO = 9;
	
	/**********Sensors**********/
	
	// Encoders
	public static final int LIFT_ENCODER_A = 1, LIFT_ENCODER_B = 2;

	// Limit Switch
	public static final int VERT_LIMIT_SWITCH = 0;
	
	// IR
	public static final int CUBER_IR = 1; // fix port
	
	// Ultrasonic
	public static final int ULTRASONIC_PING = 0, ULTRASONIC_ECHO = 0; //TODO: add ultrasonic
	
	// Raspberry Pi
	public static final edu.wpi.first.wpilibj.SerialPort.Port RASPI = Port.kMXP;
	
}
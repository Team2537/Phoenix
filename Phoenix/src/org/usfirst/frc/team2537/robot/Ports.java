package org.usfirst.frc.team2537.robot;

import edu.wpi.first.wpilibj.SerialPort.Port;

public class Ports {

	/********** Input **********/

	// Joysticks
	public static final int LEFT_JOYSTICK = 0, RIGHT_JOYSTICK = 1;

	// Buttons
	public static final int VERT_RAISE_BUTTON = 3, VERT_LOWER_BUTTON = 2;

	public static final int CLIMB_ON_BUTTON = 5, CLIMB_OFF_BUTTON = 4;

	public static final int OVERRIDE_KEY_ONE = 11, OVERRIDE_KEY_TWO = 10;

	public static final int RAMP_LOWER_BUTTON = 8, RAMP_RAISE_BUTTON = 9;

	public static final int FLIP_MANIPULATOR_DOWN_BUTTON = 2, FLIP_MANIPULATOR_UP_BUTTON = 3;

	public static final int PICK_UP_BUTTON = 1, PICK_UP_BUTTON_TWO = 1, EXPEL_SLOW_BUTTON = 4, EXPEL_FAST_BUTTON = 5;

	/********** Motors **********/

	// CANTalons
	public static final int VERT_MOTOR_ONE = 5, VERT_MOTOR_TWO = 4;

	public static final int FLYWHEEL_MOTOR_LEFT = 7, FLYWHEEL_MOTOR_RIGHT = 8;

	public static final int FLIPPER_WINDOW_MOTOR = 6;
	
	public static final int FRONT_LEFT_DRIVE_MOTOR = 0, FRONT_RIGHT_DRIVE_MOTOR = 1, 
							BACK_LEFT_DRIVE_MOTOR = 2, BACK_RIGHT_DRIVE_MOTOR = 3;

	// Talons

	public static final int CLIMB_MOTOR_ONE = 1, CLIMB_MOTOR_TWO = 2, CLIMB_MOTOR_THREE = 0;

	// Servo 
	public static final int RAMP_SERVO = 9;

	/********** Sensors **********/

	// Encoders
	public static final int LIFT_ENCODER_A = 1, LIFT_ENCODER_B = 2;

	// Ultrasonic
	public static final int CUBER_ULTRASONIC_TRIGGER = 4, CUBER_ULTRASONIC_ECHO = 5, CUBER_FAKE_ULTRASONIC = 9;

	public static final int DRIVE_ULTRASONIC_TRIGGER = 1, DRIVE_ULTRASONIC_ECHO = 0;

	//Holifax
	public static final int FLIPPER_HOLIFAX_ONE = 6, FLIPPER_HOLIFAX_TW0 = 7;
	
	// Limit Switch
	public static final int VERT_LIMIT_SWITCH = 2;
	
	// Raspberry Pi
	public static final edu.wpi.first.wpilibj.SerialPort.Port RASPI = Port.kMXP;
	
 
	
	/********* Miscellaneous ********/

	// PDP Channels
	public static final int LEFT_FLYWHEEL_PDP_CHANNEL = 6, RIGHT_FLYWHEEL_PDP_CHANNEL = 7;

	public static final int CLIMB_MOTOR_ONE_PDP = 2, CLIMB_MOTOR_TWO_PDP = 1, CLIMB_MOTOR_THREE_PDP = 0;

	public static final int VERT_PDP = 12;

	public static final int FRONT_RIGHT_PDP = 13, FRONT_LEFT_PDP = 12, BACK_RIGHT_PDP = 14, BACK_LEFT_PDP = 15;

	//Camera Ports
	public static final int CAMERA_PORT = 0;
	
}

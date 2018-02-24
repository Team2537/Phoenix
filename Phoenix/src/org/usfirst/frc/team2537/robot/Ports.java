package org.usfirst.frc.team2537.robot;

import edu.wpi.first.wpilibj.DigitalSource;

public class Ports {

	//flywheel motors
	public static final int FLYWHEEL_MOTOR_LEFT = 0, FLYWHEEL_MOTOR_RIGHT = 2;
	
	//cuber encoders
	public static final int CUBER_ENCODER_A = 1, CUBER_ENCODER_B = 2;
	
	// window motor? for lifting
	public static final int WINDOW_MOTOR = 2;
	
	//lifting encoders
	public static final int LIFT_ENCODER_A = 1, LIFT_ENCODER_B = 2;
	
	//joysticks
	public static final int LEFT_JOYSTICK = 0, RIGHT_JOYSTICK = 1;
	
	//buttons
	public static final int PICK_UP_BUTTON = 1, EXPEL_BUTTON = 2, LIFT_BUTTON = 5, LOWER_BUTTON = 4;
	
	//ultrasonics
	public static final int ULTRASONIC_INPUT = 1, ULTRASONIC_OUTPUT = 2;

	//PDP channels
	public static final int RIGHT_FLYWHEEL_PDP_CHANNEL = 1, LEFT_FLYWHEEL_PDP_CHANNEL = 2, WINDOW_MOTOR_CHANNEL = 10;

	//digital input
	public static final int LIMIT_SWITCH_LIFT = 1, LIMIT_SWITCH_LOWER = 2;
	
	//drive motors
	public static final int FRONT_RIGHT_MOTOR = 0, FRONT_LEFT_MOTOR = 1, BACK_RIGHT_MOTOR = 2, BACK_LEFT_MOTOR = 3; 
	
	
}

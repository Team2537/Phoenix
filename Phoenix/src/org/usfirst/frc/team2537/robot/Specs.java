package org.usfirst.frc.team2537.robot;

public class Specs {
	// all values in inches unless noted
	public static final double WHEEL_DIAMETER = 7.5;
	public static final int TICKS_PER_REVOLUTION = 1440; // ticks
	public static final double ROBOT_LENGTH = 1337; // TODO: measure robot
	public static final double ROBOT_WIDTH  = 1337; // TODO: measure robot
	
	public static final double FLIPPER_SCALE_LOWER_TIME = 0.5; // seconds to lower flipper to scale position from fully raised
	public static final double FLIPPER_SCALE_LIFT_TIME = 1; // seconds to raise flipper to scale position from fully lowered
	public static final double EXPEL_TIME = 0.8; // seconds to expel a cube
	public static final double VISION_TIMEOUT = 0.5; // seconds
	
	public static final int SWITCH_HEIGHT = 450000; // ticks
	public static final int SCALE_HEIGHT = 675000; // ticks
}

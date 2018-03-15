package org.usfirst.frc.team2537.robot.input;

import org.usfirst.frc.team2537.robot.Ports;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class HumanInput {

	public static Joystick leftJoystick = new Joystick(Ports.LEFT_JOYSTICK);
	public static Joystick rightJoystick = new Joystick(Ports.RIGHT_JOYSTICK);
	
	public static Button vertRaiseButton = new JoystickButton(rightJoystick, Ports.VERT_RAISE_BUTTON);
	public static Button vertLowerButton = new JoystickButton(rightJoystick, Ports.VERT_LOWER_BUTTON);
	public static Button vertOverrideButton = new JoystickButton(rightJoystick, Ports.VERT_OVERRIDE_BUTTON);
	public static Button vertUnderrideButton = new JoystickButton(rightJoystick, Ports.VERT_UNDERRIDE_BUTTON);
	
	public static Button cuberPickUpButton = new JoystickButton(leftJoystick, Ports.PICK_UP_BUTTON); 
	public static Button cuberPickUpButtonTwo = new JoystickButton(rightJoystick, Ports.PICK_UP_BUTTON_TWO);
	public static Button cuberExpelFastButton = new JoystickButton(leftJoystick, Ports.EXPEL_FAST_BUTTON); 
	public static Button cuberExpelSlowButton = new JoystickButton(leftJoystick, Ports.EXPEL_SLOW_BUTTON);
	public static Button cuberFlipDownButton = new JoystickButton(leftJoystick, Ports.FLIP_MANIPULATOR_DOWN_BUTTON);
	public static Button cuberFlipUpButton = new JoystickButton(leftJoystick, Ports.FLIP_MANIPULATOR_UP_BUTTON);
	public static Button enableUltrasonicOverride = new JoystickButton(leftJoystick, Ports.OVERRIDE_KEY_TWO);
	public static Button disableUltrasonicOverride = new JoystickButton(leftJoystick, Ports.OVERRIDE_KEY_ONE);
	
	public static Button climbOnButton = new JoystickButton(rightJoystick, Ports.CLIMB_ON_BUTTON);
	public static Button climbOffButton = new JoystickButton(rightJoystick, Ports.CLIMB_OFF_BUTTON);
	
	public static Button climbOverrideKeyOne = new JoystickButton(rightJoystick, Ports.OVERRIDE_KEY_ONE);
	public static Button climbOverrideKeyTwo = new JoystickButton(rightJoystick, Ports.OVERRIDE_KEY_TWO);
	
	public static Button rampLowerButton = new JoystickButton(rightJoystick, Ports.RAMP_LOWER_BUTTON);
	public static Button rampRaiseButton = new JoystickButton(rightJoystick, Ports.RAMP_RAISE_BUTTON);
	

	
	
	/**
	 * Register button to command
	 * 
	 * @param b
	 *            button to register command to
	 * 
	 * @param c
	 *            command to register to button
	 */

	
	public static void registerWhenPressedCommand(Button b, Command c) {
		b.whenPressed(c);
	}
	
	/**
	 * Register held button to a command
	 * when button is released, interrupted() is called
	 * if command finishes while button is held, command is called again
	 * isFinsished() should always return false
	 * 
	 * @param b
	 * 			button to register command to
	 * @param c
	 * 			command to register button
	 */
	public static void registerWhileHeldCommand(Button b, Command c) {
		b.whileHeld(c);
	}
	
	public static void registerWhenReleasedCommand(Button b, Command c) {
		b.whenReleased(c);
	}
}

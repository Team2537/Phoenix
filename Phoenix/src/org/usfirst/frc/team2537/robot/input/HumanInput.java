package org.usfirst.frc.team2537.robot.input;

import org.usfirst.frc.team2537.robot.Ports;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class HumanInput {
	
	public static Joystick leftJoystick = new Joystick(Ports.LEFT_JOYSTICK);
	public static Joystick rightJoystick = new Joystick(Ports.RIGHT_JOYSTICK);
	
	public static Button raiseButton = new JoystickButton(rightJoystick, Ports.VERT_RAISE_BUTTON);
	public static Button lowerButton = new JoystickButton(rightJoystick, Ports.VERT_LOWER_BUTTON);


	public static Button climbOnButton = new JoystickButton(leftJoystick, Ports.CLIMB_ON_BUTTON);
	public static Button climbOffButton = new JoystickButton(leftJoystick, Ports.CLIMB_OFF_BUTTON);
	
	public static Button overrideKeyOne = new JoystickButton(leftJoystick, Ports.OVERRIDE_KEY_ONE);
	public static Button overrideKeyTwo = new JoystickButton(leftJoystick, Ports.OVERRIDE_KEY_TWO);
	public static Button overrideKeyThree = new JoystickButton(leftJoystick, Ports.OVERRIDE_KEY_THREE);
	
	public static Button rampLowerButton = new JoystickButton(rightJoystick, Ports.RAMP_LOWER_BUTTON);
	public static Button rampRaiseButton = new JoystickButton(rightJoystick, Ports.RAMP_RAISE_BUTTON);
	
	public static Button cubeGrabButton = new JoystickButton(leftJoystick, Ports.CUBE_GRAB_BUTTON);
	public static Button cubeReleaseButton = new JoystickButton(rightJoystick, Ports.CUBE_RELEASE_BUTTON);
	
	public static Button cubeFlipDownButton = new JoystickButton(leftJoystick, Ports.FLIP_MANIPULATOR_DOWN_BUTTON);
	public static Button cubeFlipUpButton = new JoystickButton(leftJoystick, Ports.FLIP_MANIPULATOR_UP_BUTTON);
	
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
}

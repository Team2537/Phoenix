package org.usfirst.frc.team2537.robot.input;

import org.usfirst.frc.team2537.robot.Ports;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class HumanInput {

	public static Joystick leftJoystick = new Joystick(Ports.LEFT_JOYSTICK);
	public static Joystick rightJoystick = new Joystick(Ports.RIGHT_JOYSTICK);
	public static Joystick xboxController = new Joystick(Ports.XBOX_CONTROLLER);
	
	public static Button vertRaiseButton = new JoystickButton(xboxController, Ports.VERT_RAISE_BUTTON);
	public static Button vertLowerButton = new JoystickButton(xboxController, Ports.VERT_LOWER_BUTTON);
	
	public static Button cuberPickUpButton = new JoystickButton(xboxController, Ports.PICK_UP_BUTTON); 
//	public static Button cuberPickUpButtonTwo = new JoystickButton(xboxController, Ports.PICK_UP_BUTTON_TWO);
	public static Button cuberExpelFastButton = new JoystickButton(xboxController, Ports.EXPEL_FAST_BUTTON); 
	public static Button cuberExpelSlowButton = new JoystickButton(xboxController, Ports.EXPEL_SLOW_BUTTON);
	public static Button cuberFlipDownButton = new JoystickButton(xboxController, Ports.FLIP_MANIPULATOR_DOWN_BUTTON);
	public static Button cuberFlipUpButton = new JoystickButton(xboxController, Ports.FLIP_MANIPULATOR_UP_BUTTON);
	
	public static Button climbOnButton = new JoystickButton(rightJoystick, Ports.CLIMB_ON_BUTTON);
	public static Button climbOffButton = new JoystickButton(rightJoystick, Ports.CLIMB_OFF_BUTTON);
	
	public static Button climbOverrideKeyOne = new JoystickButton(rightJoystick, Ports.OVERRIDE_KEY_ONE);
	public static Button climbOverrideKeyTwo = new JoystickButton(rightJoystick, Ports.OVERRIDE_KEY_TWO);
	
	public static Button rampLowerButton = new JoystickButton(rightJoystick, Ports.RAMP_LOWER_BUTTON);
	public static Button rampRaiseButton = new JoystickButton(rightJoystick, Ports.RAMP_RAISE_BUTTON);
	
	public static boolean xboxLeftTriggerPressed() {
		return xboxController.getRawAxis(3) > .5;
	}
	
	public static boolean xboxRightTriggerPressed() {
		return xboxController.getRawAxis(3) < -.5;
	}
	
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

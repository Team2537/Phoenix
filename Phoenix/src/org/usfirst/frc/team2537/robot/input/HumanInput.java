package org.usfirst.frc.team2537.robot.input;

import org.usfirst.frc.team2537.robot.Ports;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class HumanInput {
	
	public static Joystick leftJoystick = new Joystick(Ports.LEFT_JOYSTICK);
	public static Joystick rightJoystick = new Joystick(Ports.RIGHT_JOYSTICK);
	
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
	
	public static void registerWhileHeldCommand(Button b, Command c) {
		b.whileHeld(c);
	}
}

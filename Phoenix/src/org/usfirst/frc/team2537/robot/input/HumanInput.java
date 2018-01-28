package org.usfirst.frc.team2537.robot.input;

import org.usfirst.frc.team2537.robot.Ports;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class HumanInput {
	
	public static Joystick leftJoystick = new Joystick(Ports.LEFT_JOYSTICK);
	public static Joystick rightJoystick = new Joystick(Ports.RIGHT_JOYSTICK);
	
	public static Button clawGrabButton = new JoystickButton(leftJoystick, Ports.CLAW_GRAB_BUTTON);
	public static Button clawReleaseButton = new JoystickButton(leftJoystick, Ports.CLAW_RELEASE_BUTTON);

	
	
	
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
}

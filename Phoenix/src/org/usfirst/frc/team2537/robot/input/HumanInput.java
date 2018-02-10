package org.usfirst.frc.team2537.robot.input;

import org.usfirst.frc.team2537.robot.Ports;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class HumanInput {
	
	public static Joystick leftJoystick = new Joystick(Ports.LEFT_JOYSTICK);
	public static Joystick rightJoystick = new Joystick(Ports.RIGHT_JOYSTICK);

	
	public static Button pickUpButton = new JoystickButton(leftJoystick, Ports.PICK_UP_BUTTON); //leads to command for picking up cube
	public static Button expelButton = new JoystickButton(rightJoystick, Ports.EXPEL_BUTTON); //leads to command for shooting out cube//I'm not sure what button is used for this command or whether it occurs for pressed or held
	public static Button liftButton = new JoystickButton(leftJoystick, Ports.LIFT_BUTTON); // button command on left joystick for lifting arm
	public static Button lowerButton = new JoystickButton(leftJoystick, Ports.LOWER_BUTTON); //button command on left joystick for lowering arm
	
	
	
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
	
	public static void registerWhenReleasedCommand(Button b, Command c) {
		b.whenReleased(c);
	}
}

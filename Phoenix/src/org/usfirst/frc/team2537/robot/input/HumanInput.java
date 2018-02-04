package org.usfirst.frc.team2537.robot.input;

import org.usfirst.frc.team2537.robot.Ports;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class HumanInput {

	public static Joystick leftJoystick = new Joystick(Ports.LEFT_JOYSTICK);
	public static Joystick rightJoystick = new Joystick(Ports.RIGHT_JOYSTICK);
	public static Button climbOnButton = new JoystickButton(rightJoystick, Ports.CLIMB_ON_BUTTON);
	public static Button climbOffButton = new JoystickButton(rightJoystick, Ports.CLIMB_OFF_BUTTON);
	public static Button overrideKeyOne = new JoystickButton(leftJoystick, Ports.OVERRIDE_KEY_ONE);
	public static Button overrideKeyTwo = new JoystickButton(leftJoystick, Ports.OVERRIDE_KEY_TWO);
	public static Button overrideKeyThree = new JoystickButton(leftJoystick, Ports.OVERRIDE_KEY_THREE);

	public static void registerWhenPressedCommand(Button b, Command c) {
		b.whenPressed(c);
	}
}
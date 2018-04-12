package org.usfirst.frc.team2537.robot.input;

import org.usfirst.frc.team2537.robot.Ports;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class HumanInput {
	
		// Register two joysticks
		public static Joystick leftJoystick = new Joystick(Ports.LEFT_JOYSTICK);
		public static Joystick rightJoystick = new Joystick(Ports.RIGHT_JOYSTICK);

		// Create camera buttons
		// Camera switcheroo switches overlay without switching sensors
		public static Button cameraSwitchButton = new JoystickButton(rightJoystick, Ports.CAMERA_SWITCH_BUTTON);
		public static Button cameraSwitcherooButton = new JoystickButton(rightJoystick, Ports.CAMERA_SWITCHEROO_BUTTON);

	public static void registerWhenPressedCommand(Button b, Command c) {
		b.whenPressed(c);
	}
}

package org.usfirst.frc.team2537.robot.input;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

public class HumanInput {
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

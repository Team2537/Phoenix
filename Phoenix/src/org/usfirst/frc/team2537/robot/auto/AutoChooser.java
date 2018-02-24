package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.auto.routes.LeftAuto;
import org.usfirst.frc.team2537.robot.auto.routes.RightAuto;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class AutoChooser extends SendableChooser<Command> {
	public AutoChooser() {
		addObject("Left", new LeftAuto());
		addObject("Right", new RightAuto());
	}
}

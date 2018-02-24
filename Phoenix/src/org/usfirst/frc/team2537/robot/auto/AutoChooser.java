package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.auto.routes.LeftCoopAuto;
import org.usfirst.frc.team2537.robot.auto.routes.LeftSoloAuto;
import org.usfirst.frc.team2537.robot.auto.routes.RightCoopAuto;
import org.usfirst.frc.team2537.robot.auto.routes.RightSoloAuto;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class AutoChooser extends SendableChooser<Command> {
	public AutoChooser() {
		addObject("Left Solo", new LeftSoloAuto());
		addObject("Left With Teammate", new LeftCoopAuto());
		addObject("Right Solo", new RightSoloAuto());
		addObject("Right With Teammate", new RightCoopAuto());
	}
}

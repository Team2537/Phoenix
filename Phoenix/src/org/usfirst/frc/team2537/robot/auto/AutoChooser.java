package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.auto.routes.RouteHandler.AutoChooserOption;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class AutoChooser extends SendableChooser<AutoChooserOption> {
	public AutoChooser() {
		addObject("Left Solo", AutoChooserOption.SOLO_LEFT);
		addObject("Left With Teammate", AutoChooserOption.CO_OP_LEFT);
		addObject("Right Solo", AutoChooserOption.SOLO_RIGHT);
		addObject("Right With Teammate", AutoChooserOption.CO_OP_RIGHT);
		addObject("Left Scale", AutoChooserOption.SCALE_LEFT);
		addObject("Right Scale", AutoChooserOption.SCALE_RIGHT);
	}
}

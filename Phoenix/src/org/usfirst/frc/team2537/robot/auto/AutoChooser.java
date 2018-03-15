package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.auto.routes.RouteHandler.AutoChooserOption;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class AutoChooser extends SendableChooser<AutoChooserOption> {
	public AutoChooser() {
		addDefault("Drive Straight", AutoChooserOption.DRIVE_STRAIGHT);
		addObject("Left Solo", AutoChooserOption.SOLO_LEFT);
		addObject("Left With Teammate", AutoChooserOption.CO_OP_LEFT);
		addObject("Right Solo", AutoChooserOption.SOLO_RIGHT);
		addObject("Right With Teammate", AutoChooserOption.CO_OP_RIGHT);
		addObject("Left Elims Ally 2-cube", AutoChooserOption.ELIMS_LEFT);
		addObject("Right Elims Ally 2-cube", AutoChooserOption.ELIMS_RIGHT);
		addObject("Vision Rotate (Test)", AutoChooserOption.VISION_ROTATE_TEST);
//		addObject("Straight w/ competent teammate", AutoChooserOption.DRIVE_STRAIGHT_WITH_COMPETENT_TEAMMATE);
	}
}

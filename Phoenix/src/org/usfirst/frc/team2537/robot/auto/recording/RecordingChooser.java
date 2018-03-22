package org.usfirst.frc.team2537.robot.auto.recording;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class RecordingChooser extends SendableChooser<Boolean> {
	public RecordingChooser() {
		addDefault("Do not record", false);
		addObject("Record", true);
	}

}

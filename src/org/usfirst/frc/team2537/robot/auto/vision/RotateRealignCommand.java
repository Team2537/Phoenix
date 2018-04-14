package org.usfirst.frc.team2537.robot.auto.vision;

import org.usfirst.frc.team2537.robot.auto.RotateCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RotateRealignCommand extends CommandGroup {
	public RotateRealignCommand(double angle) {
		addSequential(new RotateCommand(angle));
	}

}

package org.usfirst.frc.team2537.robot.auto.routes;

import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LineCrossRoute extends CommandGroup {
	public LineCrossRoute(){
		addSequential(new DriveStraightCommand(258));
	}
}

package org.usfirst.frc.team2537.robot.auto.routes;

import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveStraightTest extends CommandGroup {
	public DriveStraightTest() {
		addSequential(new DriveStraightCommand(24));
		addSequential(new DriveStraightCommand(24));
		addSequential(new DriveStraightCommand(24));
	}
}

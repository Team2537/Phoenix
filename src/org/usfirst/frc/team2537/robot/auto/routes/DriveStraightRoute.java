package org.usfirst.frc.team2537.robot.auto.routes;

import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;

public class DriveStraightRoute extends AutoRoute {

	@Override
	public void scheduleCommands() {
		addSequential(new DriveStraightCommand(110));
	}
	
	@Override
	public StartingSide defaultSide() {
		return StartingSide.LEFT;
	}
	
}

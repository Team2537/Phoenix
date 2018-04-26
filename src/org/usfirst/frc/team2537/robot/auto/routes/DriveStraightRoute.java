package org.usfirst.frc.team2537.robot.auto.routes;

import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class DriveStraightRoute extends AutoRoute {

	@Override
	public void scheduleCommands() {
		addSequential(new WaitCommand(delay()));
		addSequential(new DriveStraightCommand(110));
	}
	
	@Override
	public StartingSide defaultSide() {
		return StartingSide.LEFT;
	}
	
}

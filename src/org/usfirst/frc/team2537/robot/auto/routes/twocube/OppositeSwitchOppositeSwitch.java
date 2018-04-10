package org.usfirst.frc.team2537.robot.auto.routes.twocube;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.ShittyAutoCommand;
import org.usfirst.frc.team2537.robot.auto.routes.AutoRoute;
import org.usfirst.frc.team2537.robot.auto.routes.StartingSide;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

public class OppositeSwitchOppositeSwitch extends AutoRoute {
	@Override
	public void scheduleCommands() {
		addSequential(new OppositeSwitchSecondCubeRoute());
		
		addSequential(new ShittyAutoCommand(-.6), .2);
		addSequential(new VertUpCommand(Specs.SWITCH_HEIGHT));
		addSequential(new ShittyAutoCommand(.420), 1);
		addSequential(new ExpelCommand(.5), Specs.EXPEL_TIME);		
	}
	
	@Override
	public StartingSide defaultSide() {
		return StartingSide.LEFT;
	}

}

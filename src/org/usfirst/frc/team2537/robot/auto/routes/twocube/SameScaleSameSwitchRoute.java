

package org.usfirst.frc.team2537.robot.auto.routes.twocube;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.ShittyAutoCommand;
import org.usfirst.frc.team2537.robot.auto.routes.AutoRoute;
import org.usfirst.frc.team2537.robot.auto.routes.StartingSide;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

public class SameScaleSameSwitchRoute extends AutoRoute {
	@Override
	public void scheduleCommands() {
		addSequential(new SameScaleSecondCubeRoute());
		
		addSequential(new VertUpCommand(Specs.SWITCH_HEIGHT));
		addSequential(new RotateCommand(10 * sideMultiplier()), .5);
		addSequential(new ShittyAutoCommand(.4), 1.5);
		addSequential(new ExpelCommand(.5), Specs.EXPEL_TIME);
	};
	
	@Override
	public StartingSide defaultSide() {
		return StartingSide.LEFT;
	}
}

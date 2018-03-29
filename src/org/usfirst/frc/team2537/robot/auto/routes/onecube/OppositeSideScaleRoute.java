package org.usfirst.frc.team2537.robot.auto.routes.onecube;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.ShittyAutoCommand;
import org.usfirst.frc.team2537.robot.auto.routes.AutoRoute;
import org.usfirst.frc.team2537.robot.auto.routes.StartingSide;
//github.com/Team2537/Phoenix.git
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

public class OppositeSideScaleRoute extends AutoRoute {
	public void scheduleCommands(){
		addSequential(new DriveStraightCommand(230));
		addSequential(new RotateCommand(90*sideMultiplier()));

		addSequential(new DriveStraightCommand(250));
		addSequential(new RotateCommand(-90*sideMultiplier()));

		addSequential(new DriveStraightCommand(69));
		addSequential(new RotateCommand(-90*sideMultiplier()));

		addParallel(new LowerFlipperCommand(), Specs.FLIPPER_SCALE_LOWER_TIME);
		addParallel(new ShittyAutoCommand(-0.5), 0.420);
		addSequential(new VertUpCommand(Specs.SCALE_HEIGHT));
		addSequential(new ShittyAutoCommand(0.5), 0.420/2);
		addSequential(new ExpelCommand(1), Specs.EXPEL_TIME);
	}
	
	@Override
	public StartingSide defaultSide() {
		return StartingSide.LEFT;
	}
}

/*

+-------------------------------------------------+
| XX                                              |
|X                                                |
S>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>o              |
|                                  v              |
|                                  v              |
|               +------------+     v              |
|               |          +-+     v     +--------+
|               |          |       v     |        |
|               |          +-+     v     |       XX
|               |          +-+     v     |       X|
|             +-+          |       v     |       X|
|           +---|          +-+     v     |       X|
|         +-----|          |-|     v     |       X|
|         +-----|          |-|     v     |       X|
|           +---|          +-+     v     |       X|
|             +-+          |       v     |       X|
|               |          +-+     v     |       X|
|               |          +-+     v     |       XX
|               |          |       v     |        |
|               |          +-+     v     +--------+
|               +------------+     v              |
|                                  v              |
|                                  o>>>>>>>>>>>>>o|
|X                                               ^|
| XX                                             ^|
+------------------------------------------------E+

 */
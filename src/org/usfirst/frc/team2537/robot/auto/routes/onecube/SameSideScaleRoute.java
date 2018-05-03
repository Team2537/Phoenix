package org.usfirst.frc.team2537.robot.auto.routes.onecube;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.routes.AutoRoute;
import org.usfirst.frc.team2537.robot.auto.routes.StartingSide;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.vert.HoldCommand;
import org.usfirst.frc.team2537.robot.vert.VertDownCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class SameSideScaleRoute extends AutoRoute {
	public void scheduleCommands(){
		addSequential(new WaitCommand(delay()));
		addParallel(new LowerFlipperCommand(), Specs.FLIPPER_SCALE_LOWER_TIME);
		addSequential(new DriveStraightCommand(360));
		addSequential(new RotateCommand(90*sideMultiplier()));

		addParallel(new DriveStraightCommand(-40), 0.5);
		addSequential(new VertUpCommand(Specs.SCALE_HEIGHT));
		addParallel(new HoldCommand(), 0.5 + Specs.EXPEL_TIME);
		addSequential(new WaitCommand(0.5));
		addSequential(new ExpelCommand(1), Specs.EXPEL_TIME);
		
		addSequential(new VertDownCommand(Specs.SCALE_HEIGHT));
	}

	@Override
	public StartingSide defaultSide() {
		return StartingSide.LEFT;
	}
}

/*

+------------------------------------------------E+
| XX                                             v|
|X                                               v|
S>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>o|
|                                                 |
|                                                 |
|               +------------+                    |
|               |          +-+           +-------v+
|               |          |             |        |
|               |          +-+           |       XX
|               |          +-+           |       X|
|             +-+          |             |       X|
|           +---|          +-+           |       X|
|         +-----|          |-|           |       X|
|         +-----|          |-|           |       X|
|           +---|          +-+           |       X|
|             +-+          |             |       X|
|               |          +-+           |       X|
|               |          +-+           |       XX
|               |          |             |        |
|               |          +-+           +--------+
|               +------------+                    |
|                                                 |
|                                                 |
|X                                                |
| XX                                              |
+-------------------------------------------------+

 */
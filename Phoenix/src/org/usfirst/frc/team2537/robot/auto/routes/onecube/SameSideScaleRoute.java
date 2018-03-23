package org.usfirst.frc.team2537.robot.auto.routes.onecube;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SameSideScaleRoute extends CommandGroup {
	public SameSideScaleRoute(boolean left){
		addSequential(new DriveStraightCommand(345));
		if(left) addSequential(new RotateCommand(90));
		else addSequential(new RotateCommand(-90));

		addParallel(new LowerFlipperCommand(), Specs.FLIPPER_SCALE_LOWER_TIME);
		addParallel(new DriveStraightCommand(-40), 0.5);
		addSequential(new VertUpCommand(Specs.SCALE_HEIGHT));
		addSequential(new ExpelCommand(1), Specs.EXPEL_TIME);
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
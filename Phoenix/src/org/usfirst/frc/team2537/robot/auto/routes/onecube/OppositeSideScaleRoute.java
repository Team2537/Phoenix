package org.usfirst.frc.team2537.robot.auto.routes.onecube;

import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class OppositeSideScaleRoute extends CommandGroup {
	public OppositeSideScaleRoute(boolean left){
		addSequential(new DriveStraightCommand(225));
		if(left) addSequential(new RotateCommand(90));
		else addSequential(new RotateCommand(-90));

		addSequential(new DriveStraightCommand(250));
		if(left) addSequential(new RotateCommand(-90));
		else addSequential(new RotateCommand(90));

		addSequential(new DriveStraightCommand(8));
		if(left) addSequential(new RotateCommand(-90));
		else addSequential(new RotateCommand(90));

		addParallel(new LowerFlipperCommand(), 0.5);
		addParallel(new DriveStraightCommand(-40), 0.5);
		addSequential(new VertUpCommand(675000));
		addSequential(new ExpelCommand(0.8));
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
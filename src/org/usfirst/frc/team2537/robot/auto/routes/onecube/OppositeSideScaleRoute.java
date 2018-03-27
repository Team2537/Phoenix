package org.usfirst.frc.team2537.robot.auto.routes.onecube;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.ShittyAutoCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class OppositeSideScaleRoute extends CommandGroup {
	public OppositeSideScaleRoute(boolean left){
		addSequential(new DriveStraightCommand(230));
		
		if(left) addSequential(new RotateCommand(90));
		else addSequential(new RotateCommand(-90));

		addSequential(new DriveStraightCommand(270));		
		if(left) addSequential(new RotateCommand(-90));
		else addSequential(new RotateCommand(90));

		addSequential(new DriveStraightCommand(69));		
		if(left) addSequential(new RotateCommand(-90));
		else addSequential(new RotateCommand(90));

		addParallel(new LowerFlipperCommand(), Specs.FLIPPER_SCALE_LOWER_TIME);
		addSequential(new ShittyAutoCommand(-0.5), 0.69);
		addSequential(new VertUpCommand(Specs.SCALE_HEIGHT));
		addSequential(new ShittyAutoCommand(0.69), 0.420/2);
		addSequential(new ExpelCommand(1), Specs.EXPEL_TIME);
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
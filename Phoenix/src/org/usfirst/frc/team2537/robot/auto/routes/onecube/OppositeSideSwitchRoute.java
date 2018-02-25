package org.usfirst.frc.team2537.robot.auto.routes.onecube;

import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class OppositeSideSwitchRoute extends CommandGroup {
	public OppositeSideSwitchRoute(boolean left){
		addSequential(new DriveStraightCommand(215));
		if(left) addSequential(new RotateCommand(90));
		else addSequential(new RotateCommand(-90));

		addSequential(new DriveStraightCommand(215));
		if(left) addSequential(new RotateCommand(90));
		else addSequential(new RotateCommand(-90));

		addParallel(new LowerFlipperCommand());
		addParallel(new VertUpCommand(350000));
		addSequential(new DriveStraightCommand(60));
		if(left) addSequential(new RotateCommand(90));
		else addSequential(new RotateCommand(-90));

		addSequential(new DriveStraightCommand(30), 0.5);
		addSequential(new ExpelCommand(0.5));
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
|               +-----E------+     v              |
|                     ^            v              |
|                     o<<<<<<<<<<<<o              |
|X                                                |
| XX                                              |
+-------------------------------------------------+

 */
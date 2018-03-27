package org.usfirst.frc.team2537.robot.auto.routes.onecube;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.ShittyAutoCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SameSideSwitchRoute extends CommandGroup {
	public SameSideSwitchRoute(boolean left){
		addSequential(new DriveStraightCommand(148.625));
		if (left) addSequential(new RotateCommand(90));
		else addSequential(new RotateCommand(-90));
		addParallel(new LowerFlipperCommand());
		addSequential(new VertUpCommand(Specs.SWITCH_HEIGHT));

		addSequential(new ShittyAutoCommand(0.5), 0.69);
		addSequential(new ExpelCommand(0.5), Specs.EXPEL_TIME);
	}
}

/*

+-------------------------------------------------+
| XX                                              |
|X                                                |
S>>>>>>>>>>>>>>>>>>>>>o                           |
|                     v                           |
|                     v                           |
|               +-----E------+                    |
|               |          +-+           +--------+
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
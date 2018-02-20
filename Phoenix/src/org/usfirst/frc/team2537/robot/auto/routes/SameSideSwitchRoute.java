package org.usfirst.frc.team2537.robot.auto.routes;

import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SameSideSwitchRoute extends CommandGroup {
	public SameSideSwitchRoute(){
		addParallel(new LowerFlipperCommand());
		addParallel(new VertUpCommand(450000));
		addSequential(new DriveStraightCommand(148.625));
		addSequential(new RotateCommand(90));
		addSequential(new DriveStraightCommand(-30), 0.50);
		addSequential(new ExpelCommand(0.5));
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
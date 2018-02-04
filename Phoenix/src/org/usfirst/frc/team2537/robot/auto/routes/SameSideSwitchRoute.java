package org.usfirst.frc.team2537.robot.auto.routes;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SameSideSwitchRoute extends CommandGroup {
	public SameSideSwitchRoute(){
		addSequential(new DriveStraightCommand(168 - Specs.ROBOT_LENGTH));
		addSequential(new RotateCommand(90));
	//	addSequential(new LiftUpCommand()); TODO: merge subsystem
	//	addSequential(new UltrasonicDriveCommand()); TODO: rewrite ultrasonic command
	//	addSequential(new FlipDownCommand()); TODO: merge subsystem
	//	addSequential(new DropBoxCommand()); TODO: merge subsystem
	}
}

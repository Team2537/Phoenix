package org.usfirst.frc.team2537.robot.auto.routes;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.cube_manipulation.CubeFlipDownCommand;
import org.usfirst.frc.team2537.robot.cube_manipulation.CubeReleaseCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SameSideSwitchRoute extends CommandGroup {
	public SameSideSwitchRoute(){
		addSequential(new DriveStraightCommand(168 - Specs.ROBOT_LENGTH));
		addSequential(new RotateCommand(90));
		addSequential(new VertUpCommand());
	//	addSequential(new UltrasonicDriveCommand()); TODO: rewrite ultrasonic command
		addSequential(new CubeFlipDownCommand());
		addSequential(new CubeReleaseCommand());
	}
}

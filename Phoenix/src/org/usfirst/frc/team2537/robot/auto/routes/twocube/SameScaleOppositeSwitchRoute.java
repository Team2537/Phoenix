package org.usfirst.frc.team2537.robot.auto.routes.twocube;

import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.cuber.PickUpCommand;
import org.usfirst.frc.team2537.robot.vert.VertDownCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SameScaleOppositeSwitchRoute extends CommandGroup {
	public SameScaleOppositeSwitchRoute(boolean left) {
		addParallel(new LowerFlipperCommand(), .5);
		addParallel(new VertUpCommand(675000));
		addSequential(new DriveStraightCommand(270));
		if(left) addSequential(new RotateCommand(60);
		else addSequential(new RotateCommand(-60));
		addSequential(new ExpelCommand(.8), .5);
		
		addParallel(new VertDownCommand(675000));
		addParallel(new LowerFlipperCommand());
		if(left) addSequential(new RotateCommand(75));
		else addSequential(new RotateCommand(-75));
		
		addSequential(new DriveStraightCommand(75));
		if(left) addSequential(new RotateCommand(-45));
		else addSequential(new RotateCommand(45));
		
		addSequential(new DriveStraightCommand(135));
		if(left) addSequential(new RotateCommand(90));
		else addSequential(new RotateCommand(-90));
		addParallel(new PickUpCommand(), 1);
		addSequential(new DriveStraightCommand(20), 1);
		
		addSequential(new VertUpCommand(450000));
		if(left) addSequential(new RotateCommand(15), .2);
		else addSequential(new RotateCommand(-15), .2);
		addSequential(new DriveStraightCommand(10), .2);
		addSequential(new ExpelCommand(.5), 1);
	}
}

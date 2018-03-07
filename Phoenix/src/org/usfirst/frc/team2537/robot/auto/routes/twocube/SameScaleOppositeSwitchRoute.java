package org.usfirst.frc.team2537.robot.auto.routes.twocube;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.vision.VisionRotateCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.cuber.PickUpCommand;
import org.usfirst.frc.team2537.robot.vert.VertDownCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SameScaleOppositeSwitchRoute extends CommandGroup {
	public SameScaleOppositeSwitchRoute(boolean left) {
		addParallel(new LowerFlipperCommand(), Specs.FLIPPER_SCALE_LOWER_TIME);
		addParallel(new VertUpCommand(Specs.SCALE_HEIGHT));
		addSequential(new DriveStraightCommand(270));
		if(left) addSequential(new RotateCommand(60);
		else addSequential(new RotateCommand(-60));
		addSequential(new ExpelCommand(.8), Specs.EXPEL_TIME);
		
		addParallel(new VertDownCommand(Specs.SCALE_HEIGHT));
		addParallel(new LowerFlipperCommand());
		if(left) addSequential(new RotateCommand(75));
		else addSequential(new RotateCommand(-75));
		
		addSequential(new DriveStraightCommand(75));
		if(left) addSequential(new RotateCommand(-45));
		else addSequential(new RotateCommand(45));
		
		addSequential(new DriveStraightCommand(135));
		if(left) addSequential(new RotateCommand(90));
		else addSequential(new RotateCommand(-90));
		addSequential(new VisionRotateCommand(), Specs.VISION_TIMEOUT);
		addParallel(new PickUpCommand(), 1);
		addSequential(new DriveStraightCommand(20), 1);
		
		addSequential(new VertUpCommand(Specs.SWITCH_HEIGHT));
		if(left) addSequential(new RotateCommand(15), .5);
		else addSequential(new RotateCommand(-15), .5);
		addSequential(new DriveStraightCommand(10), .5);
		addSequential(new ExpelCommand(.5), Specs.EXPEL_TIME);
	}
}

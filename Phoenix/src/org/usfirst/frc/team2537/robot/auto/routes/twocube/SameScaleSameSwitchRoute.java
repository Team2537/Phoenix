package org.usfirst.frc.team2537.robot.auto.routes.twocube;

import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.SameSideScaleRoute;
import org.usfirst.frc.team2537.robot.auto.vision.VisionRotateCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.cuber.PickUpCommand;
import org.usfirst.frc.team2537.robot.vert.VertDownCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SameScaleSameSwitchRoute extends CommandGroup {
	public SameScaleSameSwitchRoute(boolean left) {
		addSequential(new SameSideScaleRoute(left));
		
		addParallel(new LowerFlipperCommand());
		addParallel(new VertDownCommand(675000));
		if(left) addSequential(new RotateCommand(90));
		else addSequential(new RotateCommand(-90));
		
		addSequential(new DriveStraightCommand(85));
		if(left) addSequential(new RotateCommand(-90));
		else addSequential(new RotateCommand(90));
		
		addSequential(new DriveStraightCommand(70));
		if(left) addSequential(new RotateCommand(90));
		else addSequential(new RotateCommand(-90));
		
		addSequential(new VisionRotateCommand());
		addParallel(new PickUpCommand(), .8);
		addSequential(new DriveStraightCommand(20), 1);
		
		addSequential(new VertUpCommand(450000));
		addSequential(new ExpelCommand(.5));
	}
}

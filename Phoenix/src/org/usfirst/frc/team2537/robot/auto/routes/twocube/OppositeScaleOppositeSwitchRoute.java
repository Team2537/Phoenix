package org.usfirst.frc.team2537.robot.auto.routes.twocube;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.vision.VisionInput;
import org.usfirst.frc.team2537.robot.auto.vision.VisionRotateCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.cuber.PickUpCommand;
import org.usfirst.frc.team2537.robot.vert.VertDownCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class OppositeScaleOppositeSwitchRoute extends CommandGroup {
	public OppositeScaleOppositeSwitchRoute(boolean left) {
		addSequential(new DriveStraightCommand(221));
		if(left) addSequential(new RotateCommand(90));
		else addSequential(new RotateCommand(-90));
		
		addSequential(new DriveStraightCommand(207));
		if(left) addSequential(new RotateCommand(-60));
		else addSequential(new RotateCommand(60));
		
		addParallel(new VertUpCommand(Specs.SCALE_HEIGHT));
		addParallel(new LowerFlipperCommand(), Specs.FLIPPER_SCALE_LOWER_TIME);
		addSequential(new DriveStraightCommand(64));
		if(left) addSequential(new RotateCommand(-90));
		else addSequential(new RotateCommand(90));
		addSequential(new ExpelCommand(.8), Specs.EXPEL_TIME);
		
		addParallel(new LowerFlipperCommand());
		addParallel(new VertDownCommand(Specs.SCALE_HEIGHT));
		if(left) addSequential(new RotateCommand(-90));
		else addSequential(new RotateCommand(90));
		addSequential(new DriveStraightCommand(60));
		addSequential(new VisionRotateCommand(), Specs.VISION_TIMEOUT);
		addParallel(new PickUpCommand(), 1.5);
		addSequential(new DriveStraightCommand(30), 1.5);
		
		addSequential(new VertUpCommand(Specs.SWITCH_HEIGHT));
		addSequential(new DriveStraightCommand(10), .5);
		if(left) addSequential(new RotateCommand(-15), .5);
		else addSequential(new RotateCommand(15), .5);
		addSequential(new ExpelCommand(.5), Specs.EXPEL_TIME);
	}
}

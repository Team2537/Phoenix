package org.usfirst.frc.team2537.robot.auto.routes.twocube;

import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.vision.VisionRotateCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LiftFlipperCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.cuber.PickUpCommand;
import org.usfirst.frc.team2537.robot.vert.VertDownCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class OppositeSwitchOppositeScaleRoute extends CommandGroup {
	public OppositeSwitchOppositeScaleRoute(boolean left) {
		addSequential(new DriveStraightCommand(225));
		if(left) addSequential(new RotateCommand(90));
		else addSequential(new RotateCommand(-90));
		
		addParallel(new LowerFlipperCommand());
		addSequential(new DriveStraightCommand(190));
		addParallel(new ExpelCommand(.8), .5);
		if(left) addSequential(new RotateCommand(90));
		else addSequential(new RotateCommand(-90));

		addParallel(new PickUpCommand(), 1);
		addSequential(new DriveStraightCommand(25), 1);
		addSequential(new VertUpCommand(450000));
		addSequential(new DriveStraightCommand(10), .5);
		addSequential(new ExpelCommand(.5), 1);
		
		addParallel(new VertDownCommand(450000));
		addSequential(new DriveStraightCommand(-18));
		if(left) addSequential(new RotateCommand(45));
		else addSequential(new RotateCommand(-45));
		
		addSequential(new VisionRotateCommand());
		addParallel(new PickUpCommand(), 1);
		addSequential(new DriveStraightCommand(18), 1);
		
		addSequential(new DriveStraightCommand(-111));
		addParallel(new VertUpCommand(675000));
		addParallel(new LiftFlipperCommand(), 1);
		if(left) addSequential(new RotateCommand(69)); // I just write what SuperGUI gives me.
		else addSequential(new RotateCommand(-69));
		addSequential(new ExpelCommand(.8), 1);
	}
}

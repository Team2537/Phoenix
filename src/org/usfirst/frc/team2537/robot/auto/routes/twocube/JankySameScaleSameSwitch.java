package org.usfirst.frc.team2537.robot.auto.routes.twocube;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.ShittyAutoCommand;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.SameSideScaleRoute;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.PickUpCommand;
import org.usfirst.frc.team2537.robot.vert.VertDownCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class JankySameScaleSameSwitch extends CommandGroup {
	public JankySameScaleSameSwitch(){
		/*
		addSequential(new DriveStraightCommand(345));
		if(left) addSequential(new RotateCommand(90));
		else addSequential(new RotateCommand(-90));

		addParallel(new LowerFlipperCommand(), Specs.FLIPPER_SCALE_LOWER_TIME);
		addParallel(new DriveStraightCommand(-40), 0.69);
		addSequential(new VertUpCommand(Specs.SCALE_HEIGHT));
		addSequential(new ExpelCommand(1), Specs.EXPEL_TIME);
		*/
		addSequential(new SameSideScaleRoute(true));
		
		addSequential(new VertDownCommand());
		addSequential(new DriveStraightCommand(21.45,0.5));
		addSequential(new RotateCommand(19.5));
		addParallel(new DriveStraightCommand(90.26,0.5));
		addSequential(new PickUpCommand(), 4000);
		addSequential(new VertUpCommand(Specs.SWITCH_HEIGHT));
		addSequential(new ShittyAutoCommand(1.0), 0.69);
		addSequential(new ExpelCommand(0.5), Specs.EXPEL_TIME);
	}
}
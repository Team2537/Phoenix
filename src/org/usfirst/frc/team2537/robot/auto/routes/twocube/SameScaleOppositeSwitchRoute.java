package org.usfirst.frc.team2537.robot.auto.routes.twocube;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.ShittyAutoCommand;
import org.usfirst.frc.team2537.robot.auto.routes.AutoRoute;
import org.usfirst.frc.team2537.robot.auto.routes.StartingSide;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.SameSideScaleRoute;
import org.usfirst.frc.team2537.robot.auto.vision.ResetVision;
import org.usfirst.frc.team2537.robot.auto.vision.VisionRotateCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.cuber.PickUpCommand;
import org.usfirst.frc.team2537.robot.vert.VertDownCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class SameScaleOppositeSwitchRoute extends AutoRoute {
	@Override
	public void scheduleCommands() {
		addSequential(new SameSideScaleRoute());
		
		addSequential(new VertDownCommand());
		addSequential(new DriveStraightCommand(21));
		addSequential(new RotateCommand(90 * sideMultiplier()));
		
		addSequential(new DriveStraightCommand(84));
		addSequential(new RotateCommand(-90 * sideMultiplier()));
		
		addSequential(new DriveStraightCommand(190));
		addSequential(new RotateCommand(90 * sideMultiplier()));
		addSequential(new ResetVision());
		addSequential(new WaitCommand(1));
		addSequential(new VisionRotateCommand(), Specs.VISION_TIMEOUT);
		addSequential(new LowerFlipperCommand(), 0.8);
		addParallel(new PickUpCommand(), 2);
		addSequential(new ShittyAutoCommand(.5), 2);
		
		addSequential(new VertUpCommand(Specs.SWITCH_HEIGHT));
		addSequential(new RotateCommand(10 * sideMultiplier()), .5);
		addSequential(new ShittyAutoCommand(.4), 1);
		addSequential(new ExpelCommand(.5), Specs.EXPEL_TIME);
	}
	
	@Override
	public StartingSide defaultSide() {
		return StartingSide.LEFT;
	}
}

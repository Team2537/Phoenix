package org.usfirst.frc.team2537.robot.auto.routes.twocube;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.ShittyAutoCommand;
import org.usfirst.frc.team2537.robot.auto.routes.AutoRoute;
import org.usfirst.frc.team2537.robot.auto.routes.StartingSide;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.OppositeSideSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.vision.ResetVision;
import org.usfirst.frc.team2537.robot.auto.vision.VisionRotateCommand;
import org.usfirst.frc.team2537.robot.cuber.LiftFlipperCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.cuber.PickUpCommand;
import org.usfirst.frc.team2537.robot.vert.VertDownCommand;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class OppositeSwitchSecondCubeRoute extends AutoRoute {
	@Override
	public void scheduleCommands() {
		addSequential(new OppositeSideSwitchRoute());
		
		addSequential(new DriveStraightCommand(-25));
		addSequential(new RotateCommand(-90 * sideMultiplier()));

		addParallel(new VertDownCommand());
		addSequential(new DriveStraightCommand(-101));
		addSequential(new RotateCommand(60 * sideMultiplier()));
		addSequential(new ShittyAutoCommand(.5), .5);

		addParallel(new LiftFlipperCommand());
		addSequential(new ResetVision());
		addSequential(new WaitCommand(1));
		addSequential(new VisionRotateCommand(), Specs.VISION_TIMEOUT);
		addSequential(new LowerFlipperCommand());
		addParallel(new PickUpCommand(), 2);
		addSequential(new ShittyAutoCommand(.6), 2);

	}
	
	@Override
	public StartingSide defaultSide() {
		return StartingSide.LEFT;
	}
}

package org.usfirst.frc.team2537.robot.auto.routes.twocube;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.routes.AutoRoute;
import org.usfirst.frc.team2537.robot.auto.routes.StartingSide;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.OppositeSideScaleRoute;
import org.usfirst.frc.team2537.robot.auto.vision.ResetVision;
import org.usfirst.frc.team2537.robot.auto.vision.VisionRotateCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.cuber.PickUpCommand;
import org.usfirst.frc.team2537.robot.vert.VertDownCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class OppositeScaleSecondCubeRoute extends AutoRoute {
	@Override
	public void scheduleCommands() {
		addSequential(new OppositeSideScaleRoute());

		addSequential(new VertDownCommand());
		addSequential(new DriveStraightCommand(20));
		addSequential(new RotateCommand(-60 * sideMultiplier()));
		
		addSequential(new DriveStraightCommand(75));
		addSequential(new ResetVision());
		addSequential(new WaitCommand(1));
		addSequential(new VisionRotateCommand(), Specs.VISION_TIMEOUT);

		addSequential(new LowerFlipperCommand(), 0.8);
		addParallel(new PickUpCommand(), 2);
		addSequential(new DriveStraightCommand(30, 0.3), 2);
		addSequential(new VertUpCommand(1000));
	}

	@Override
	public StartingSide defaultSide() {
		return StartingSide.LEFT;
	}
	
}

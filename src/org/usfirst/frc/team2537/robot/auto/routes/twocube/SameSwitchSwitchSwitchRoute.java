package org.usfirst.frc.team2537.robot.auto.routes.twocube;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.ShittyAutoCommand;
import org.usfirst.frc.team2537.robot.auto.routes.AutoRoute;
import org.usfirst.frc.team2537.robot.auto.routes.StartingSide;
import org.usfirst.frc.team2537.robot.auto.vision.ResetVision;
import org.usfirst.frc.team2537.robot.auto.vision.VisionRotateCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LiftFlipperCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.cuber.PickUpCommand;
import org.usfirst.frc.team2537.robot.vert.VertDownCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

import edu.wpi.first.wpilibj.command.WaitCommand;

//I genuinely don't think this will work. We probably won't even test it. But I'm bored
//- Daniel O

public class SameSwitchSwitchSwitchRoute extends AutoRoute {
	@Override
	public void scheduleCommands() {
		addSequential(new SameSwitchSameSwitchRoute());
		
		addSequential(new DriveStraightCommand(-25));
		addSequential(new RotateCommand(90 * sideMultiplier()));

		addParallel(new VertDownCommand());
		addSequential(new DriveStraightCommand(-190));
		addSequential(new RotateCommand(-85 * sideMultiplier()));
		addSequential(new DriveStraightCommand(30, 0.5), 1);

		addParallel(new LiftFlipperCommand());
		addSequential(new ResetVision());
		addSequential(new WaitCommand(1));
		addSequential(new VisionRotateCommand(), Specs.VISION_TIMEOUT);
		addSequential(new LowerFlipperCommand());
		addParallel(new PickUpCommand(), 3);
		addSequential(new DriveStraightCommand(30, 0.3), 3);
		addSequential(new VertUpCommand(1000));
		
		addSequential(new DriveStraightCommand(-30));
		addSequential(new RotateCommand(50));
		addSequential(new ShittyAutoCommand(.420), 1);
		addSequential(new ExpelCommand(.5), Specs.EXPEL_TIME);
	}
	
	@Override
	public StartingSide defaultSide() {
		return StartingSide.LEFT;
	}

}

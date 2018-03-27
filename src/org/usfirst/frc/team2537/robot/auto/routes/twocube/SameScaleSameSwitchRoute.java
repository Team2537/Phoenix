package org.usfirst.frc.team2537.robot.auto.routes.twocube;

import org.usfirst.frc.team2537.robot.Specs;
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
		addParallel(new VertDownCommand());
		if(left) addSequential(new RotateCommand(60));
		else addSequential(new RotateCommand(-60));

		addSequential(new DriveStraightCommand(95));
		addSequential(new VisionRotateCommand(), Specs.VISION_TIMEOUT);
		addParallel(new PickUpCommand(), 1);
		addSequential(new DriveStraightCommand(30), 1);

		addSequential(new VertUpCommand(Specs.SWITCH_HEIGHT));
		addSequential(new DriveStraightCommand(10), .5);
		if(left) addSequential(new RotateCommand(15), .5);
		else addSequential(new RotateCommand(-15), .5);
		addSequential(new ExpelCommand(.5), Specs.EXPEL_TIME);
	}
}

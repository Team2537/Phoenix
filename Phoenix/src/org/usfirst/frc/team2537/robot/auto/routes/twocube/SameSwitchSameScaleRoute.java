package org.usfirst.frc.team2537.robot.auto.routes.twocube;

import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.SameSideSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.vision.VisionRotateCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LiftFlipperCommand;
import org.usfirst.frc.team2537.robot.cuber.PickUpCommand;
import org.usfirst.frc.team2537.robot.vert.VertDownCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SameSwitchSameScaleRoute extends CommandGroup {
	public SameSwitchSameScaleRoute(boolean left) {
		addSequential(new SameSideSwitchRoute(left));

		addSequential(new DriveStraightCommand(-40), 0.50);
		addParallel(new VertDownCommand(450000));
		if(left) addSequential(new RotateCommand(-90));
		else addSequential(new RotateCommand(90));

		addSequential(new DriveStraightCommand(65));
		if(left) addSequential(new RotateCommand(120));
		else addSequential(new RotateCommand(-120));

		addSequential(new VisionRotateCommand());
		addParallel(new PickUpCommand(), 2);
		addSequential(new DriveStraightCommand(40), 2);
		addSequential(new DriveStraightCommand(-40), 2);
		if(left) addSequential(new RotateCommand(-120));
		else addSequential(new RotateCommand(120));

		addSequential(new DriveStraightCommand(90));
		if(left) addSequential(new RotateCommand(90));
		else addSequential(new RotateCommand(-90));

		addParallel(new LiftFlipperCommand(), .5);
		addParallel(new DriveStraightCommand(-40), 0.5);
		addSequential(new VertUpCommand(675000));
		addSequential(new ExpelCommand(0.8));
	}
}

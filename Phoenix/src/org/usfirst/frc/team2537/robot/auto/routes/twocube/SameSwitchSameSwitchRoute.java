package org.usfirst.frc.team2537.robot.auto.routes.twocube;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.SameSideSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.vision.VisionRotateCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.PickUpCommand;
import org.usfirst.frc.team2537.robot.vert.VertDownCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SameSwitchSameSwitchRoute extends CommandGroup {
	public SameSwitchSameSwitchRoute(boolean left) {
		addSequential(new SameSideSwitchRoute(left));

		addSequential(new DriveStraightCommand(-25));
		addParallel(new VertDownCommand(Specs.SWITCH_HEIGHT));
		if(left) addSequential(new RotateCommand(-90));
		else addSequential(new RotateCommand(90));

		addSequential(new DriveStraightCommand(65));
		if(left) addSequential(new RotateCommand(120));
		else addSequential(new RotateCommand(-120));

		addSequential(new VisionRotateCommand(), Specs.VISION_TIMEOUT);
		addParallel(new PickUpCommand(), 2);
		addSequential(new DriveStraightCommand(40), 2);
		addSequential(new VertUpCommand(Specs.SWITCH_HEIGHT));
		addSequential(new DriveStraightCommand(10), .5);
		addSequential(new RotateCommand(15), .5);
		addSequential(new ExpelCommand(.5), Specs.EXPEL_TIME);
	}
}

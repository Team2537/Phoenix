package org.usfirst.frc.team2537.robot.auto.routes.twocube;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.routes.AutoRoute;
import org.usfirst.frc.team2537.robot.auto.routes.StartingSide;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

import edu.wpi.first.wpilibj.command.WaitCommand;


public class SameScaleSameScaleRoute extends AutoRoute{
	@Override
	public void scheduleCommands() {
		addSequential(new SameScaleSecondCubeRoute());
		
		addSequential(new DriveStraightCommand(-30));
		addSequential(new RotateCommand());
		addSequential(new DriveStraightCommand(-120));
		addSequential(new RotateCommand(-60));
		
		addSequential(new DriveStraightCommand(-40), 0.5);
		addSequential(new VertUpCommand(Specs.SCALE_HEIGHT));
		addSequential(new WaitCommand(0.5));
		addSequential(new ExpelCommand(1), Specs.EXPEL_TIME);
		
		
		
		
		
	}

	@Override
	public StartingSide defaultSide() {
		return StartingSide.LEFT;
	}

}

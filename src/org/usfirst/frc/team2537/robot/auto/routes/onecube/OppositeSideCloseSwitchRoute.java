package org.usfirst.frc.team2537.robot.auto.routes.onecube;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.routes.AutoRoute;
import org.usfirst.frc.team2537.robot.auto.routes.StartingSide;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class OppositeSideCloseSwitchRoute extends AutoRoute {
	public void scheduleCommands(){
		addSequential(new DriveStraightCommand(50));
		addSequential(new RotateCommand(90*sideMultiplier()));

		addSequential(new WaitCommand(2000));
		addSequential(new DriveStraightCommand(225));
		addSequential(new RotateCommand(-90*sideMultiplier()));

		addParallel(new LowerFlipperCommand());
		addParallel(new VertUpCommand(Specs.SWITCH_HEIGHT));
		addSequential(new DriveStraightCommand(105));
		addSequential(new RotateCommand(-90*sideMultiplier()));

		addSequential(new DriveStraightCommand(45), 1.5);
		addSequential(new ExpelCommand(0.5), Specs.EXPEL_TIME);
	}
	
	@Override
	public StartingSide defaultSide() {
		return StartingSide.LEFT;
	}
}
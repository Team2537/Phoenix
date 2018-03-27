package org.usfirst.frc.team2537.robot.auto.routes.onecube;

import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class OppositeSideCloseSwitchRoute extends CommandGroup {
	public OppositeSideCloseSwitchRoute(boolean left){
		addSequential(new DriveStraightCommand(50));
		if(left) addSequential(new RotateCommand(90));
		else addSequential(new RotateCommand(-90));

		addSequential(new WaitCommand(2000));
		addSequential(new DriveStraightCommand(225));
		if(left) addSequential(new RotateCommand(-90));
		else addSequential(new RotateCommand(90));

		addParallel(new LowerFlipperCommand());
		addParallel(new VertUpCommand(Specs.SWITCH_HEIGHT));
		addSequential(new DriveStraightCommand(105));
		if(left) addSequential(new RotateCommand(-90));
		else addSequential(new RotateCommand(90));

		addSequential(new DriveStraightCommand(45), 1.5);
		addSequential(new ExpelCommand(0.5), Specs.EXPEL_TIME);
	}
}
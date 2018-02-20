package org.usfirst.frc.team2537.robot.auto.routes;

import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.ShittyAutoCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class OppositeSideSwitchRoute extends CommandGroup {
	public OppositeSideSwitchRoute(){
		addSequential(new DriveStraightCommand(215));
		addSequential(new RotateCommand(90));
		addSequential(new DriveStraightCommand(215));
		addSequential(new RotateCommand(90));
		addParallel(new LowerFlipperCommand());
		addParallel(new VertUpCommand(350000));
		addSequential(new DriveStraightCommand(60));
		addSequential(new RotateCommand(90));
		addSequential(new ShittyAutoCommand(.69));
		addSequential(new ExpelCommand(false));
	}
}

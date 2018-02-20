package org.usfirst.frc.team2537.robot.auto.routes;

import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.ShittyAutoCommand;
import org.usfirst.frc.team2537.robot.auto.ShittyLowerCubeCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class OppositeSideScaleRoute extends CommandGroup {
	public OppositeSideScaleRoute(){
		addSequential(new DriveStraightCommand(215));
		addSequential(new RotateCommand(90));
		addSequential(new DriveStraightCommand(240));
		addSequential(new RotateCommand(-90));
		addSequential(new DriveStraightCommand(85));
		addSequential(new RotateCommand(-90));
		addParallel(new ShittyLowerCubeCommand(0.5));
		addParallel(new ShittyAutoCommand(0.69, true));
		addSequential(new VertUpCommand(675000));
		addSequential(new ExpelCommand(true));
	}
}

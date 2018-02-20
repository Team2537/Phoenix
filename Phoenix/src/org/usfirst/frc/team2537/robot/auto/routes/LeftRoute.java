package org.usfirst.frc.team2537.robot.auto.routes;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.RotateCommand;
import org.usfirst.frc.team2537.robot.auto.ShittyAutoCommand;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.vert.VertUpCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftRoute extends CommandGroup {
	public LeftRoute(){
		if(Robot.fmsData.charAt(0) == 'L') {
			addParallel(new LowerFlipperCommand());
			addParallel(new VertUpCommand(450000));
			addSequential(new DriveStraightCommand(148.625));
			addSequential(new RotateCommand(90));
			addSequential(new ShittyAutoCommand(.69));
			addSequential(new ExpelCommand(false));
		} else {
			addSequential(new DriveStraightCommand(200));			
		}
	}
}

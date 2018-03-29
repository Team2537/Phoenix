package org.usfirst.frc.team2537.robot.auto.routes;

import edu.wpi.first.wpilibj.command.CommandGroup;

public abstract class AutoRoute extends CommandGroup {
	private final StartingSide defaultSide;
	private double sideMultiplier;
	public AutoRoute(){
		defaultSide = defaultSide();
		sideMultiplier = 1;
		scheduleCommands();
	}
	public double sideMultiplier(){
		return sideMultiplier;
	}
	public AutoRoute setStartingSide(StartingSide side){
		sideMultiplier = side == defaultSide ? 1 : -1;
		return this;
	}
	public abstract StartingSide defaultSide();
	public abstract void scheduleCommands();
}

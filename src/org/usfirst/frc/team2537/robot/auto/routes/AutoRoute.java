package org.usfirst.frc.team2537.robot.auto.routes;

import edu.wpi.first.wpilibj.command.CommandGroup;

public abstract class AutoRoute extends CommandGroup {
	private final StartingSide defaultSide;
	private double sideMultiplier;
	private double delay;
	public AutoRoute(){
		defaultSide = defaultSide();
		sideMultiplier = 1;
	}
	public double sideMultiplier(){
		return sideMultiplier;
	}
	public double delay() {
		return delay;
	}
	public AutoRoute setStartingSide(StartingSide side){
		sideMultiplier = side == defaultSide ? 1 : -1;
		return this;
	}
	public AutoRoute setDelayTime(double time) {
		delay = time;
		return this;
	}
	public abstract StartingSide defaultSide();
	public abstract void scheduleCommands();
}

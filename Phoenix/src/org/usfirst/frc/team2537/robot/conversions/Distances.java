package org.usfirst.frc.team2537.robot.conversions;

import org.usfirst.frc.team2537.robot.Specs;

public enum Distances{
	TICKS			(1),
	REVOLUTIONS		(Specs.TICKS_PER_REVOLUTION),
	INCHES			(REVOLUTIONS.getTicks()/(Math.PI*Specs.WHEEL_DIAMETER)),
	FEET			(INCHES.getTicks()*12),
	CENTIMETERS		(INCHES.getTicks()/2.54),
	METERS			(CENTIMETERS.getTicks()*100),
	NAUTICAL_MILES	(METERS.getTicks()*1852);
	
	private final double toTicks;
	
	Distances(double toTicks){
		this.toTicks = toTicks;
	}
	
	public double getTicks(){
		return toTicks;
	}
}

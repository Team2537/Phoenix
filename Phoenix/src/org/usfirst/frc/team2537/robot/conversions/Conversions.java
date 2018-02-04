package org.usfirst.frc.team2537.robot.conversions;

public class Conversions {
	
	public static double convertDistance(double value, Distances currentType, Distances desiredType){
		return value * currentType.getTicks() / desiredType.getTicks();
	}
	
	public static double convertTime(double value, Times currentType, Times desiredType){
		return value *  currentType.getMillis() / desiredType.getMillis();
	}
	
	public static double convertSpeed(double value, Distances currentDistanceType, Times currentTimeType,
			Distances desiredDistanceType, Times desiredTimeType){
		return value * (currentDistanceType.getTicks() / currentTimeType.getMillis()) 
				* (desiredTimeType.getMillis() / desiredDistanceType.getTicks());
	}
	
	public static double roundDigits(double value, int digits){
		return (int)(value * Math.pow(10, digits))/Math.pow(10, digits);
	}
}

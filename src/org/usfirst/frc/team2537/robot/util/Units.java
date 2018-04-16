package org.usfirst.frc.team2537.robot.util;

import org.usfirst.frc.team2537.robot.Specs;

public class Units {
	
	/** Base Unit: encoder ticks per millisecond (tick/ms) **/
	public static final double
	
		// Distances
		tick	= 1.0,										//encoder ticks
		rev 	= Specs.TICKS_PER_REVOLUTION * tick,		//wheel revolution
		in		= 1/(Math.PI*Specs.WHEEL_DIAMETER) * rev,	//inches
		ft		= 12 * in,									//feet
		cm		= (1/2.54) * in,							//centimeters
		m		= 100 * cm,									//meters
		
		//Times
		ns		= 1e-6,					//nanoseconds
		ms		= 1.0,					//milliseconds
		cycle	= 20 * ms,				//WPILib cycles
		ds		= 100 * ms,				//deciseconds (100ms)
		s		= 1000 * ms,			//seconds
		min		= 60 * s				//minutes
		;
		
	public static double convert(double value, double currentUnits, double desiredUnits){
		return value*currentUnits/desiredUnits;
	}
	
    public static boolean epsilonEquals(double a, double b, double epsilon) {
        return (a - epsilon <= b) && (a + epsilon >= b);
    }
}

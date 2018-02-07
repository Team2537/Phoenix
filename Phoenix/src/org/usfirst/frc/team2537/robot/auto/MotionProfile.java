package org.usfirst.frc.team2537.robot.auto;

import java.util.ArrayList;
import java.util.List;

public class MotionProfile {

	private List<MotionSegment> segments;
	private long timestamp;
	
	public MotionProfile(double dx, double accMax, double velMax, double velStart, double velEnd) {
		timestamp = System.currentTimeMillis();
		List<MotionSegment> segments = new ArrayList<>();
		
		double velIntercept = Math.sqrt((velStart * velStart + velEnd * velEnd) / 2.0 + dx * accMax);
		double tIntercept = (velIntercept - velStart) / accMax;
		
		velMax = Math.min(velMax, velIntercept);
		
		double dtAccel = (velMax - velStart) / accMax;
		double dxAccel = (velMax + velStart) * dtAccel / 2;
		
		double dtDecel = (velMax - velEnd) / accMax;
		double dxDecel = (velMax + velEnd) * dtDecel / 2;
		
		double dxCruise = dx - dxAccel - dxDecel;
		double dtCruise = dxCruise / velMax;

		double tTotal = 0, xTotal = 0;
		
		if(tIntercept > 0){
			segments.add(new MotionSegment(0, dtAccel, 0, dxAccel, velStart, velMax, accMax));
			tTotal += dtAccel;
			xTotal += dxAccel;
		}
		
		if(dxCruise > 0){
			segments.add(new MotionSegment(tTotal, tTotal + dtCruise, xTotal, xTotal + dxCruise, velMax, velMax, 0));
			tTotal += dtCruise;
			xTotal += dxCruise;
		}
		
		if(tIntercept < tTotal + dtDecel){
			segments.add(new MotionSegment(tTotal, tTotal + dtDecel, xTotal, xTotal + dxDecel, velMax, velEnd, -accMax));
		}
	}

}

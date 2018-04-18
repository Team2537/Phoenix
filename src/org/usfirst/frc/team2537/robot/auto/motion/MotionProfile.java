package org.usfirst.frc.team2537.robot.auto.motion;

import static org.usfirst.frc.team2537.robot.util.Units.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MotionProfile {

	private List<MotionSegment> segments;

	public MotionProfile(double d, double vel_i, double vel_f, double velMax, double accMax) {
		if(Math.abs(vel_i) > velMax || Math.abs(vel_f) > velMax){
			throw new IllegalStateException("The vel_i and vel_f arguments must be within the bounds of the velMax argument");
		}
		
		boolean backwards = d < 0;
		if(backwards){
			vel_i = -vel_i;
			vel_f = -vel_f;
			d = -d;
		}
		
		double vel_mid = Math.sqrt((vel_i * vel_i + vel_f * vel_f)/2 + accMax * d);
		double t_f = (2 * vel_mid - (vel_i + vel_f)) / accMax;
		double t_mid = (t_f + (vel_f - vel_i) / accMax) / 2;
		
		if (Math.abs(vel_mid) <= velMax) {
			if (t_mid < 0 || t_mid > t_f) {
				throw new IllegalStateException("Cannot generate MotionProfile within the given distance and constraints");
			}
			
			LinearMotionSegment rampUp = new LinearMotionSegment(t_mid, 0, vel_i, accMax);
			LinearMotionSegment rampDown = new LinearMotionSegment(rampUp, t_f, -accMax);

			List<MotionSegment> segments = new ArrayList<>();
			segments.add(rampUp);
			segments.add(rampDown);
			this.segments = segments;
		} else {
			double t_A = (velMax - vel_i) / accMax;
			double t_B = t_f + (vel_f - velMax) / accMax;
			double t_increase = d / velMax - velMax / accMax + (vel_i * vel_i + vel_f * vel_f) / (2 * accMax * velMax) + t_A - t_B;
			t_B += t_increase;
			t_f += t_increase;

			LinearMotionSegment rampUp = new LinearMotionSegment(t_A, 0, vel_i, accMax);
			LinearMotionSegment cruise = new LinearMotionSegment(rampUp, t_B-t_A, 0);
			LinearMotionSegment rampDown = new LinearMotionSegment(cruise, t_f-t_B, -accMax);

			List<MotionSegment> segments = new ArrayList<>();
			segments.add(rampUp);
			segments.add(cruise);
			segments.add(rampDown);
			this.segments = segments;
		}
		
		if(backwards){
			this.segments = this.flip().segments;
		}
		
		removeEmptySegments();
	}

	public MotionProfile(List<MotionSegment> segments) {
		this.segments = segments;
	}
	
	public void removeEmptySegments(){
		Iterator<MotionSegment> iter = segments.iterator();
		while(iter.hasNext()){
			if(epsilonEquals(iter.next().dt, 0, 1E-3)){
				iter.remove();
			}
		}
	}

	public MotorState getSetpoint(double t){
		for(MotionSegment segment : segments){
			if(segment.dt > t){
				t -= segment.dt;
			} else {
				return segment.getSetpoint(t);
			}
		}
		throw new IllegalStateException("Setpoint at time t is not defined within this MotionProfile");
	}
	
	public MotionProfile flip(){
		List<MotionSegment> flippedSegments = new ArrayList<>();
		for (MotionSegment segment : segments) {
			flippedSegments.add(segment.flip());
		}
		return new MotionProfile(flippedSegments);
	}
	
	@Override
	public String toString(){
		String header = String.format("[>>%15sMotion Profile%15s<<]\n","","");
		String footer = String.format("[>>%44s<<]","","");
		
		StringBuilder str = new StringBuilder();
		str.append(header);
		for(MotionSegment segment : segments){
			if(str.length() > header.length()){
				str.append('\n');
			}
			str.append(segment);
		}
		str.append(footer);
		return str.toString();
	}

}

package org.usfirst.frc.team2537.robot.auto;

public class MotionSegment {
	public final double tStart, tEnd, xStart, xEnd, vStart, vEnd, a;
	public MotionSegment(double tStart, double tEnd, double xStart, double xEnd, double vStart, double vEnd, double a){
		this.tStart = tStart;
		this.tEnd   = tEnd;
		this.xStart = xStart;
		this.xEnd   = xEnd;
		this.vStart = vStart;
		this.vEnd   = vEnd;
		this.a      = a;
	}
	public double interpolateV(double t){
		double dt = t - tStart;
		return vStart + a*dt;
	}
	public double interpolateX(double t){
		double dt = t - tStart;
		return xStart + vStart*dt + a*dt*dt;
	}
}

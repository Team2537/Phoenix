package org.usfirst.frc.team2537.robot.auto.motion;

public abstract class MotionSegment {
	public final double dt;
	public MotionSegment(double dt){
		this.dt = dt;
	}
	public abstract MotorState getSetpoint(double t);
	public abstract MotionSegment flip();
}

package org.usfirst.frc.team2537.robot.auto.motion;

public class MotorState {
	public final double pos, vel, acc;
	public MotorState(double pos, double vel, double acc){
		this.pos = pos;
		this.vel = vel;
		this.acc = acc;
	}
}

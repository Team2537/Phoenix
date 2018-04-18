package org.usfirst.frc.team2537.robot.auto.motion;

public class LinearMotionSegment extends MotionSegment {
	public final double pos_i, pos_f, vel_i, vel_f, acc;
	
	public LinearMotionSegment(double dt, double pos_i, double pos_f, double vel_i, double vel_f, double acc){
		super(dt);
		this.pos_i = pos_i;
		this.pos_f = pos_f;
		this.vel_i = vel_i;
		this.vel_f = vel_f;
		this.acc   = acc;
	}
	
	public LinearMotionSegment(double dt, double pos_i, double vel_i, double acc){
		super(dt);
		this.pos_i = pos_i;
		this.vel_i = vel_i;
		this.acc = acc;
		MotorState finalState = getSetpoint(dt);
		this.vel_f = finalState.vel;
		this.pos_f = finalState.pos;
	}
	
	public LinearMotionSegment(LinearMotionSegment prev, double dt, double pos_f, double vel_f, double acc){
		this(dt, prev.pos_f, pos_f, prev.vel_f, vel_f, acc);
	}
	
	public LinearMotionSegment(LinearMotionSegment prev, double dt, double arg){
		this(dt, prev.pos_f, prev.vel_f, arg);
	}
	
	@Override
	public MotorState getSetpoint(double t){
		double pos = pos_i + vel_i*t + acc/2*t*t;
		double vel = vel_i + acc*(t);
		return new MotorState(pos,vel,acc);
	}
	
	@Override
	public LinearMotionSegment flip(){
		return new LinearMotionSegment(dt, -pos_i, -pos_f, -vel_i, -vel_f, -acc);
	}
	
	@Override
	public String toString(){
		return String.format("       %-10s %-10s %-10s %-10s\n" +
							 "init.: %-10f %-10f %-10f %-10f\n" +
							 "final: %-10f %-10f %-10f %-10f\n", 
					"t","pos","vel","acc",0.0,pos_i,vel_i,acc,dt,pos_f,vel_f,acc);
	}
	
}

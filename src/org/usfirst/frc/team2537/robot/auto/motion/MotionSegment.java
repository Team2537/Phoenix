package org.usfirst.frc.team2537.robot.auto.motion;

public class MotionSegment {
	public final double t_i, t_f, dt, pos_i, pos_f, vel_i, vel_f, acc;
	
	public MotionSegment(double t_i, double t_f, double pos_i, double pos_f, double vel_i, double vel_f, double acc){
		this.t_i = t_i;
		this.t_f = t_f;
		this.dt = t_f - t_i;
		this.pos_i = pos_i;
		this.pos_f = pos_f;
		this.vel_i = vel_i;
		this.vel_f = vel_f;
		this.acc   = acc;
	}
	
	public MotionSegment(double t_i, double t_f, double pos_i, double vel_i, double arg/*, CreationMode mode*/){
		this.t_i = t_i;
		this.t_f = t_f;
		this.dt = t_f - t_i;
		this.pos_i = pos_i;
		this.vel_i = vel_i;
//		switch(mode){
//		case POS_F:
//			this.pos_f = arg;
//			this.acc = (pos_f - pos_i - vel_i*dt)*2/(dt*dt);
//			this.vel_f = interpolateVel(t_f);
//			break;
//		case VEL_F:
//			this.vel_f = arg;
//			this.acc = (vel_f - vel_i)/dt;
//			this.pos_f = pos_i + (vel_f + vel_i)/2 * dt;
//			break;
//		default:
//		case ACC:
			this.acc = arg;
			this.vel_f = interpolateVel(t_f);
			this.pos_f = interpolatePos(t_f);
//			break;
//		}
	}
	
//	public static enum CreationMode {
//		POS_F, VEL_F, ACC
//	}
	
	public MotionSegment(MotionSegment prev, double t_f, double pos_f, double vel_f, double acc){
		this(prev.t_f, t_f, prev.pos_f, pos_f, prev.vel_f, vel_f, acc);
	}
	
	public MotionSegment(MotionSegment prev, double t_f, double arg/*, CreationMode mode*/){
		this(prev.t_f, t_f, prev.pos_f, prev.vel_f, arg/*, mode*/);
	}
	
	public double interpolateVel(double t){
		return vel_i + acc*(t-t_i);
	}
	
	public double interpolatePos(double t){
		double t_past = t-t_i;
		return pos_i + vel_i*t_past + acc/2*t_past*t_past;
	}
	
	public MotionSegment inverse(double t_offset){
		return new MotionSegment(t_offset-t_f, t_offset-t_i, pos_f, pos_i, -vel_f, -vel_i, acc);
	}
	
	public MotionSegment flip(){
		return new MotionSegment(t_i, t_f, -pos_i, -pos_f, -vel_i, -vel_f, -acc);
	}
	
	@Override
	public String toString(){
		return String.format("       %-10s %-10s %-10s %-10s\n" +
							 "init.: %-10f %-10f %-10f %-10f\n" +
							 "final: %-10f %-10f %-10f %-10f\n", 
					"t","pos","vel","acc",t_i,pos_i,vel_i,acc,t_f,pos_f,vel_f,acc);
	}
	
}

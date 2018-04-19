package org.usfirst.frc.team2537.robot.auto.motion;

import static org.usfirst.frc.team2537.robot.util.Units.ft;
import static org.usfirst.frc.team2537.robot.util.Units.in;
import static org.usfirst.frc.team2537.robot.util.Units.ms;
import static org.usfirst.frc.team2537.robot.util.Units.s;
import static org.usfirst.frc.team2537.robot.util.Units.tick;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.drive.Motor;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraightCommandFeedforward extends Command {
	private static final double dt = 5*ms;
	
	private static final double VEL_MAX = 15.5 * ft/s;
	private static final double ACC_MAX = 31 * ft/s/s;
	
	private static final double Kv = 1.00 * 1/VEL_MAX;
	private static final double Ka = 0.00 * 1/ACC_MAX;
	private static final double Kp = 1/(2000*tick);

	private MotionProfile profile;
	private ScheduledFuture<?> future;
	private AtomicInteger stepCount;

	public DriveStraightCommandFeedforward(double distance) {
		requires(Robot.driveSys);
		profile = new MotionProfile(distance, 0, 0, VEL_MAX, ACC_MAX);
		stepCount = new AtomicInteger();
	}
	
	private void step(){
		double t = stepCount.getAndIncrement()*dt;
		try {
			MotorState setpoint = profile.getSetpoint(t);
			
			double posLeft = Robot.driveSys.getEncoderDistance(Motor.LEFT);
			double posLeftErr = setpoint.pos - posLeft;
			
			double posRight = Robot.driveSys.getEncoderDistance(Motor.RIGHT);
			double posRightErr = setpoint.pos - posRight;
			
			double powerBase = Kv*setpoint.vel + Ka*setpoint.acc;
			Robot.driveSys.setMotors(powerBase + Kp*posLeftErr,  Motor.LEFT);
			Robot.driveSys.setMotors(powerBase + Kp*posRightErr, Motor.RIGHT);
		} catch(IllegalStateException e) {
			future.cancel(true);
		}
	}

	@Override
	protected void initialize() {
		System.out.println(profile);
		
		Robot.driveSys.resetEncoders();
		
		Thread thread = new Thread(() -> {
			step();
		});
		
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		future = executor.scheduleAtFixedRate(thread, 0, (long)dt, TimeUnit.MILLISECONDS);
	}

	@Override
	protected boolean isFinished() {
		return future.isCancelled();
	}
	
	@Override
	protected void end() {
		
	}
	
	public static void main(String[] args){
		MotionProfile p = new MotionProfile(200*in, 0, 0, VEL_MAX, ACC_MAX);
		System.out.println(p);
	}

}

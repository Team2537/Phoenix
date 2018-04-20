package org.usfirst.frc.team2537.robot.auto.motion;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.auto.Navx;
import org.usfirst.frc.team2537.robot.drive.Motor;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

public class DriveSpline extends Command {

	Trajectory trajectory;
	EncoderFollower left;
	EncoderFollower right;

	final static double MAX_VELOCITY = 4.72;
	final static double MAX_ACCEL = 4.72 * 5;
	final static double MAX_JERK = 60.0;
	final static double P = 2.0;
	final static double I = 0.0;
	final static double D = 0.0;
	final static double GAIN = 0.0;

	public DriveSpline(double dist) {
		requires(Robot.driveSys);
		Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
				Trajectory.Config.SAMPLES_HIGH, 0.02, MAX_VELOCITY, MAX_ACCEL, MAX_JERK);
		Waypoint[] points = new Waypoint[] { 
				new Waypoint(0, 0, 0),
				new Waypoint(dist * 0.0254, -1, 0)
			};
		trajectory = Pathfinder.generate(points, config);
		TankModifier modifier = new TankModifier(trajectory).modify(0.59);
		left = new EncoderFollower(modifier.getLeftTrajectory());
		right = new EncoderFollower(modifier.getRightTrajectory());
		left.configureEncoder((int) Robot.driveSys.getEncoderDistance(Motor.LEFT), Specs.TICKS_PER_REVOLUTION,
				Specs.WHEEL_DIAMETER * 0.0254); // meters
		right.configureEncoder((int) Robot.driveSys.getEncoderDistance(Motor.RIGHT), Specs.TICKS_PER_REVOLUTION,
				Specs.WHEEL_DIAMETER * 0.0254);
		left.configurePIDVA(P, I, D, 1 / MAX_VELOCITY, GAIN);
		right.configurePIDVA(P, I, D, 1 / MAX_VELOCITY, GAIN);
	}
	
	@Override
	protected void initialize() {
		Robot.driveSys.resetEncoders();
		Navx.getInstance().reset();
		Robot.driveSys.setMode(ControlMode.Velocity);
	}

	@Override
	public void execute() {
		double l = left.calculate((int) Robot.driveSys.getEncoderDistance(Motor.LEFT));
		double r = right.calculate((int) Robot.driveSys.getEncoderDistance(Motor.RIGHT));
		
		Robot.driveSys.setMotors(l, Motor.LEFT);
		Robot.driveSys.setMotors(r, Motor.RIGHT);
	}

	@Override
	protected boolean isFinished() {
		return left.isFinished() && right.isFinished();
	}
	
	@Override
	protected void end() {
		Robot.driveSys.setMotors(0, Motor.ALL);
	}
	
	@Override
	protected void interrupted() {
		end();
	}
}

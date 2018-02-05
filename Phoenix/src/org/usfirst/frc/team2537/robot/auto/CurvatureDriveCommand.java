package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.conversions.Conversions;
import org.usfirst.frc.team2537.robot.conversions.Distances;
import org.usfirst.frc.team2537.robot.conversions.Times;
import org.usfirst.frc.team2537.robot.drive.Motor;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class CurvatureDriveCommand extends Command {

	private static final double DEFAULT_SPEED = 5;
	private Curvature curvatureFunc;
	private double speed;

	public CurvatureDriveCommand(Curvature curvatureFunc, double speed) {
		requires(Robot.driveSys);
		this.curvatureFunc = curvatureFunc;
		this.speed = speed;
	}
	
	public CurvatureDriveCommand(Curvature curvatureFunc) {
		this(curvatureFunc, DEFAULT_SPEED);
	}
	
	public CurvatureDriveCommand(double radius, double speed) {
		this(new Curvature(){public double getCurvature(){ return radius; }}, speed);
	}
	
	public CurvatureDriveCommand(double radius) {
		this(new Curvature(){public double getCurvature(){ return radius; }});
	}

	@Override
	protected void initialize() {
		Robot.driveSys.setMode(ControlMode.Velocity);
	}

	@Override
	protected void execute() {
		double curvature = curvatureFunc.getCurvature();
		double leftVelocity = speed * (1 - curvature * Specs.ROBOT_WIDTH / 2);
		double rightVelocity = speed * (1 + curvature * Specs.ROBOT_WIDTH / 2);
		leftVelocity  = Conversions.convertSpeed(leftVelocity,  Distances.INCHES, Times.SECONDS, Distances.TICKS,
				Times.HUNDRED_MS);
		rightVelocity = Conversions.convertSpeed(rightVelocity, Distances.INCHES, Times.SECONDS, Distances.TICKS,
				Times.HUNDRED_MS);
		Robot.driveSys.setMotors(leftVelocity, Motor.LEFT);
		Robot.driveSys.setMotors(rightVelocity, Motor.RIGHT);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.driveSys.setMode(ControlMode.PercentOutput);
		Robot.driveSys.setMotors(0);
	}

	@Override
	protected void interrupted() {
		end();
	}

	public interface Curvature {
		double getCurvature();
	}

}

package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.conversions.Conversions;
import org.usfirst.frc.team2537.robot.conversions.Distances;
import org.usfirst.frc.team2537.robot.conversions.Times;
import org.usfirst.frc.team2537.robot.drive.Motor;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class PurePursuit extends Command {
	
	private static final double DIVIDE_BY_ZERO_THRESHOLD = 0.001;
	private final double speed, displacement;
	private final double followDistance;
	private final boolean stopOnEnd;
	private final Vector2d endPoint;
	
	private double prevCurvature, prevHeading;
	private double xPos, yPos;
	private boolean finished;
	
	public PurePursuit(Vector2d endPoint, double followDistance, double speed, boolean stopOnEnd){
		this.followDistance = followDistance;
		this.stopOnEnd = stopOnEnd;
		this.endPoint = endPoint;
		this.speed = speed;
		this.displacement = Conversions.convertSpeed(speed, Distances.INCHES, Times.SECONDS, Distances.INCHES, Times.CYCLES);
		this.prevCurvature = 0;
		this.prevHeading = Math.toRadians(Navx.getInstance().getAngle());
		this.xPos = 0;
		this.yPos = 0;
		this.finished = false;
	}
	
	private double getCurvature() {
		double deltaRadians = displacement * prevCurvature;
		if(Math.abs(prevCurvature) > DIVIDE_BY_ZERO_THRESHOLD){
			xPos += (Math.cos(prevHeading + deltaRadians) - Math.cos(prevHeading)) / prevCurvature;
			yPos += (Math.sin(prevHeading + deltaRadians) - Math.sin(prevHeading)) / prevCurvature;
		} else {	// apply L'Hospital's rule
			xPos += displacement * Math.cos(prevHeading);
			yPos += displacement * Math.sin(prevHeading);
		}
		
		double slope = endPoint.slope();
		double perpSlope = -1/slope;	// perpendicular
		double perpX = ((perpSlope*xPos + yPos) - (slope*endPoint.x + endPoint.y))/(slope - perpSlope);
		double perpY = slope*(perpX + endPoint.x) + endPoint.y;
		Vector2d perpPoint = new Vector2d(perpX, perpY);
		Vector2d goalPoint = Vector2d.add(perpPoint, Vector2d.scale(Vector2d.normalize(endPoint), followDistance));
		
		finished = goalPoint.length() >= endPoint.length();
		
		double heading = Math.toRadians(Navx.getInstance().getAngle());
		double rotatedGoalX = (goalPoint.x - xPos)*Math.cos(heading) + (goalPoint.y - yPos)*Math.sin(heading);
		
		prevHeading = heading;
		prevCurvature = 2*rotatedGoalX/(followDistance * followDistance);
		return prevCurvature;
	}
	
	@Override
	protected void initialize() {
		Robot.driveSys.setMode(ControlMode.Velocity);
	}

	@Override
	protected void execute() {
		double curvature = getCurvature();
		double leftVelocity  = speed * (1 - curvature * Specs.ROBOT_WIDTH / 2);
		double rightVelocity = speed * (1 + curvature * Specs.ROBOT_WIDTH / 2);
		leftVelocity  = Conversions.convertSpeed(leftVelocity,  Distances.INCHES, Times.SECONDS, Distances.TICKS,
				Times.HUNDRED_MS);
		rightVelocity = Conversions.convertSpeed(rightVelocity, Distances.INCHES, Times.SECONDS, Distances.TICKS,
				Times.HUNDRED_MS);
		Robot.driveSys.setMotors(leftVelocity,  Motor.LEFT);
		Robot.driveSys.setMotors(rightVelocity, Motor.RIGHT);
	}

	@Override
	protected boolean isFinished() {
		return finished;
	}

	@Override
	protected void end() {
		Robot.driveSys.setMode(ControlMode.PercentOutput);
		if(stopOnEnd){
			Robot.driveSys.setMotors(0);
		}
	}

	@Override
	protected void interrupted() {
		end();
	}


}

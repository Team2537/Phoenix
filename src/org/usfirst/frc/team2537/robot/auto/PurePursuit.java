package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.Specs;
import org.usfirst.frc.team2537.robot.drive.Motor;
import org.usfirst.frc.team2537.robot.units.Units;
import org.usfirst.frc.team2537.robot.units.Distances;
import org.usfirst.frc.team2537.robot.units.Times;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class PurePursuit extends Command {

	private final static double kEpsilon = 1E-9;

	private final double speed, followDistance;
	private final boolean stopOnEnd;
	private final Vector2d endPoint;

	private double prevCurvature, prevHeading;
	private double xPos, yPos;
	private boolean finished;

	public PurePursuit(Vector2d endPoint, double speed, double followDistance, boolean stopOnEnd) {
		this.speed = speed;
		this.followDistance = followDistance;
		this.stopOnEnd = stopOnEnd;
		this.endPoint = endPoint;
		this.prevCurvature = 0;
		this.prevHeading = Navx.getInstance().getRadians();
		this.xPos = 0;
		this.yPos = 0;
		this.finished = false;
	}

	@Override
	protected void initialize() {
		Robot.driveSys.resetEncoders();
		Robot.driveSys.setMode(ControlMode.Velocity);
		Navx.getInstance().reset();

	}

	@Override
	protected void execute() {
		updatePos();
		double curvature = getCurvature();
		double leftVelocity = speed * (1 - curvature * Specs.ROBOT_WIDTH / 2);
		double rightVelocity = speed * (1 + curvature * Specs.ROBOT_WIDTH / 2);
		leftVelocity = Units.convertSpeed(leftVelocity, Distances.INCHES, Times.SECONDS, Distances.TICKS,
				Times.HUNDRED_MS);
		rightVelocity = Units.convertSpeed(rightVelocity, Distances.INCHES, Times.SECONDS, Distances.TICKS,
				Times.HUNDRED_MS);
		Robot.driveSys.setMotors(leftVelocity, Motor.LEFT);
		Robot.driveSys.setMotors(rightVelocity, Motor.RIGHT);
	}

	private void updatePos() {
		double displacement = Robot.driveSys.getEncoderDistance();
		double deltaRadians = displacement * prevCurvature;
		if (Math.abs(prevCurvature) > kEpsilon) {
			xPos += (Math.sin(prevHeading + deltaRadians) - Math.sin(prevHeading)) / prevCurvature;
			yPos += -(Math.cos(prevHeading + deltaRadians) - Math.cos(prevHeading)) / prevCurvature;
		} else {
			xPos += displacement * Math.cos(prevHeading);
			yPos += displacement * Math.sin(prevHeading);
		}
		Robot.driveSys.resetEncoders();
	}

	private double getCurvature() {
		double slope = endPoint.slope();
		double perpSlope = -1 / slope; // perpendicular
		double perpX = ((perpSlope * xPos + yPos) - (slope * endPoint.x + endPoint.y)) / (slope - perpSlope);
		double perpY = slope * (perpX + endPoint.x) + endPoint.y;
		Vector2d perpPoint = new Vector2d(perpX, perpY);
		Vector2d goalPoint = Vector2d.add(perpPoint, Vector2d.scale(Vector2d.normalize(endPoint), followDistance));

		finished = Math.abs(goalPoint.x) >= Math.abs(endPoint.x) && Math.signum(goalPoint.x) == Math.signum(endPoint.x);

		double heading = Navx.getInstance().getRadians();
		double rotatedGoalX = (goalPoint.x - xPos) * Math.cos(heading) + (goalPoint.y - yPos) * Math.sin(heading);

		prevHeading = heading;
		prevCurvature = 2 * rotatedGoalX / (followDistance * followDistance);
		return prevCurvature;
	}

	@Override
	protected boolean isFinished() {
		return finished;
	}

	@Override
	protected void end() {
		Robot.driveSys.setMode(ControlMode.PercentOutput);
		if (stopOnEnd) {
			Robot.driveSys.setMotors(0);
		}
	}

	@Override
	protected void interrupted() {
		end();
	}

}

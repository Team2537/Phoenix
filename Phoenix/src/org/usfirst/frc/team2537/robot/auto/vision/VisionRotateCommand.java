package org.usfirst.frc.team2537.robot.auto.vision;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.drive.Motor;

import edu.wpi.first.wpilibj.command.Command;

public class VisionRotateCommand extends Command {

	/* when the pi cannot see the target, we spin faster to try to find the target */
	private static final double FAST_SPEED = 0.75;
	/* we spin slower when the pi can see the target so that we do not overshoot */
	private static final double SLOW_SPEED = 0.5;
	
	private static final double TURNING_TOLERANCE = 0.1;
	
	private double centerX;
	
	public VisionRotateCommand(){
		requires(Robot.driveSys);
		requires(Robot.serialSys);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Target[] targets = Robot.serialSys.getVisionPacket();
		
		/* if we cannot see the target, we spin faster */
		if(targets.length == 0){
			Robot.driveSys.setMotors(FAST_SPEED,  Motor.LEFT);
			Robot.driveSys.setMotors(-FAST_SPEED, Motor.RIGHT);
		} else {
			Target largestTarget = new Target();
			for(Target target : targets){
				if(target.getBoundingBoxArea() > largestTarget.getBoundingBoxArea()){
					largestTarget = target;
				}
			}
			centerX = largestTarget.getBoundingBoxCenter().getX(CoordinateSystems.CARTESIAN_NORMALIZED);
			if(centerX > 0){
				Robot.driveSys.setMotors(SLOW_SPEED,  Motor.LEFT);
				Robot.driveSys.setMotors(-SLOW_SPEED, Motor.RIGHT);
			} else {
				Robot.driveSys.setMotors(-SLOW_SPEED, Motor.LEFT);
				Robot.driveSys.setMotors(SLOW_SPEED,  Motor.RIGHT);
			}
		}
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(centerX) < TURNING_TOLERANCE;
	}

	@Override
	protected void end() {
		Robot.driveSys.setMotors(0, Motor.ALL);
	}

	@Override
	protected void interrupted() {
		Robot.driveSys.setMotors(0, Motor.ALL);
	}

}

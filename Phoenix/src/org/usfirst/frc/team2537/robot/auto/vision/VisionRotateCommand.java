package org.usfirst.frc.team2537.robot.auto.vision;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.drive.Motor;

import edu.wpi.first.wpilibj.command.Command;

public class VisionRotateCommand extends Command {

	/* when the pi cannot see the target, we spin faster to try to find the target */
	private static final double DEFAULT_PERCENT_OUTPUT = 0.69;
	private static final double CENTER_kP = 2;
	private static final double TURNING_TOLERANCE = 0.1;
	
	private double centerX;
	
	public VisionRotateCommand(){
		requires(Robot.driveSys);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Target[] targets = Robot.visionSerial.getVisionPacket();
		
		/* if we cannot see the target, we spin faster */
		double power = DEFAULT_PERCENT_OUTPUT;
		
		if(targets.length > 0){
			Target largestTarget = new Target();
			for(Target target : targets){	// focus on the largest target only
				if(target.getBoundingBoxArea() > largestTarget.getBoundingBoxArea()){
					largestTarget = target;
				}
			}
			centerX = largestTarget.getBoundingBoxCenter().getX(CoordinateSystems.CARTESIAN_NORMALIZED);
			power = Math.min(power, Math.abs(centerX/180*power*CENTER_kP)) * Math.signum(centerX);
		}
		
		Robot.driveSys.setMotors( power,  Motor.LEFT);
		Robot.driveSys.setMotors(-power, Motor.RIGHT);
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

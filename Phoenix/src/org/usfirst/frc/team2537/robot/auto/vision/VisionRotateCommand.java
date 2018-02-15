package org.usfirst.frc.team2537.robot.auto.vision;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.drive.Motor;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionRotateCommand extends Command {

	/* when the pi cannot see the target, we spin faster to try to find the target */
	private static final double DEFAULT_PERCENT_OUTPUT = 0.3;
	private static final double CENTER_kP = 1;
	private static final double TURNING_TOLERANCE = 0.1;
	
	private double centerX;
	private Side lastSide;
	private boolean stopAtTarget;
	
	public VisionRotateCommand(Side defaultTurn, boolean stopAtTarget){
		requires(Robot.driveSys);
		this.centerX = Double.POSITIVE_INFINITY;
		this.lastSide = defaultTurn;
		this.stopAtTarget = stopAtTarget;
	}
	
	public VisionRotateCommand(Side defaultTurn) {
		this(defaultTurn, true);
	}
	
	public VisionRotateCommand() {
		this(Side.LEFT);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Target[] targets = Robot.visionSerial.getVisionPacket();
		
		/* if we cannot see the target, we spin faster */
		double power = DEFAULT_PERCENT_OUTPUT;
		if(lastSide == Side.LEFT){
			power *= -1;
		}

		if(targets.length > 0){
			Target largestTarget = new Target();
			for(Target target : targets){	// focus on the largest target only
				if(target.getBoundingBoxArea() > largestTarget.getBoundingBoxArea()){
					largestTarget = target;
				}
			}
			centerX = largestTarget.getBoundingBoxCenter().x / 320.0 - 1;
			lastSide = centerX < 0 ? Side.LEFT : Side.RIGHT;

			SmartDashboard.putNumber("center", centerX);
			
			power = Math.min(Math.abs(power), Math.abs(centerX*power*CENTER_kP)) * Math.signum(centerX);
		}
		
		Robot.driveSys.setMotors( power,  Motor.LEFT);
		Robot.driveSys.setMotors(-power, Motor.RIGHT);
	}

	@Override
	protected boolean isFinished() {
		return stopAtTarget && Math.abs(centerX) < TURNING_TOLERANCE;
	}

	@Override
	protected void end() {
		Robot.driveSys.setMotors(0, Motor.ALL);
	}

	@Override
	protected void interrupted() {
		Robot.driveSys.setMotors(0, Motor.ALL);
	}
	
	enum Side {
		LEFT, RIGHT;
	}

}

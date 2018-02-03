package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.drive.Motor;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateCommand extends Command {
	private double targetAngle;
	private static final double DEFAULT_SPEED = 0.75;
	private static final double REDUCED_SPEED = 0.5;
	private static final double TOLERANCE = 1; // degrees
	private static final int SLOW_DOWN_ANGLE = 10;
	private double currentAngle;
    public RotateCommand(double angle) {
    	requires(Robot.driveSys);
    	targetAngle = angle;
    	if(targetAngle > 180){
    		targetAngle -= 360;
    	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Navx.getInstance().reset();
    	Robot.driveSys.setMode(ControlMode.PercentOutput);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentAngle = Navx.getInstance().getAngle();
    	double speed = DEFAULT_SPEED;
    	if (Math.abs(currentAngle-targetAngle) < SLOW_DOWN_ANGLE) { //reduces speed if angle is close to finishing angle
			speed=REDUCED_SPEED;
		}
    	double deltaAngle = currentAngle - targetAngle;
		if (deltaAngle > TOLERANCE){
			Robot.driveSys.setMotors(-speed, Motor.LEFT);
			Robot.driveSys.setMotors( speed, Motor.RIGHT);
		} else if (deltaAngle < -TOLERANCE) {
			Robot.driveSys.setMotors( speed, Motor.LEFT);
			Robot.driveSys.setMotors(-speed, Motor.RIGHT);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double absoluteDeltaAngle = Math.abs(currentAngle - targetAngle);
    	return (absoluteDeltaAngle <= TOLERANCE);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSys.setMotors(0, Motor.ALL);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
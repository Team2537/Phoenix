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
	private static final double DEFAULT_PERCENT_OUTPUT = 0.75;
	private static final double ANGLE_kP = 2;
	private static final double TOLERANCE = 1; // degrees
	private double currentAngle;
    public RotateCommand(double angle) {
    	requires(Robot.driveSys);
    	targetAngle = angle;
    	if(targetAngle > 180){
    		targetAngle -= 360;
    	}
    }

    @Override
    protected void initialize() {
    	Navx.getInstance().reset();
    	Robot.driveSys.setMode(ControlMode.PercentOutput);
    }

    @Override
    protected void execute() {
    	currentAngle = Navx.getInstance().getAngle();
    	double deltaAngle = currentAngle - targetAngle;
    	double power = DEFAULT_PERCENT_OUTPUT;
    	power = Math.min(power, Math.abs(deltaAngle/180*power*ANGLE_kP)) * Math.signum(deltaAngle);
		Robot.driveSys.setMotors(-power,  Motor.LEFT);
		Robot.driveSys.setMotors( power, Motor.RIGHT);
    }

    @Override
    protected boolean isFinished() {
    	double absoluteDeltaAngle = Math.abs(currentAngle - targetAngle);
    	return (absoluteDeltaAngle <= TOLERANCE);
    }

    @Override
    protected void end() {
    	Robot.driveSys.setMotors(0, Motor.ALL);
    }

    @Override
    protected void interrupted() {
    }
}
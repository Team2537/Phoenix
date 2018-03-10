package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.drive.Motor;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class RotateCommand extends Command {
	private double targetAngle;
	private static final double DEFAULT_PERCENT_OUTPUT = 0.90;
	private static final double MIN_PERCENT_OUTPUT = 0.70;
	private static final double ANGLE_kP = 2;
	private static final double TOLERANCE = 2; // degrees
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
    	Navx.getInstance().reset();
    	Robot.driveSys.setMode(ControlMode.PercentOutput);
    }

    @Override
    protected void execute() {
    	currentAngle = Navx.getInstance().getAngle();
    	double deltaAngle = currentAngle - targetAngle;
    	double power = DEFAULT_PERCENT_OUTPUT;
    	power = Math.min(power, Math.abs(deltaAngle/180*power*ANGLE_kP)) * Math.signum(deltaAngle);
		power = Math.max(Math.abs(power), Math.abs(MIN_PERCENT_OUTPUT)) * Math.signum(power);
    	Robot.driveSys.setMotors(-power,  Motor.LEFT);
		Robot.driveSys.setMotors( power, Motor.RIGHT);
		System.out.println(Navx.getInstance().getAngle());
    }

    @Override
    protected boolean isFinished() {
    	double absoluteDeltaAngle = Math.abs(currentAngle - targetAngle);
    	return (absoluteDeltaAngle <= TOLERANCE);
    }

    @Override
    protected void end() {
    	System.out.println("ending rotatecommand");
    	Robot.driveSys.setMotors(0);
    }

    @Override
    protected void interrupted() {
    	end();
    }
}
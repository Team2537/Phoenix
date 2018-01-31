package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.command.Command;

public class CubeGrabCommand extends Command {
	
	private final static double TARGET_SPEED = .5;
	private final static double INNER_TARGET_1 = .45;
	private final static double INNER_TARGET_2 = .55;
	private final static double P = .01;
	private final static double I = .001;
	private final static double TOLERANCE = 10;
	private final static double endTime = 500;
	private static double error = 0;
	private static double integral = 0;
	private double currentVoltage = 0;
	private double distanceForward = 0;
	private long startTime;
	
	public CubeGrabCommand() {
		requires(Robot.cubeSys);
	}
	
	protected void initialize() {
		startTime = System.currentTimeMillis();
		Robot.cubeSys.setBothFlywheels(.3);
		currentVoltage = .5;
	}
	
	protected void execute() {
		error = Math.abs(Robot.cubeSys.getFlywheelA() - TARGET_SPEED);
		integral += error;
		if(System.currentTimeMillis() - startTime >= 200) {
			if(Robot.cubeSys.getFlywheelA() < TARGET_SPEED - TOLERANCE || Robot.cubeSys.getFlywheelB() > TARGET_SPEED + TOLERANCE) {
				currentVoltage += (TARGET_SPEED - Robot.cubeSys.getFlywheelA())*P;
				Robot.cubeSys.setBothFlywheels(currentVoltage);
			}
//			if(Robot.cubeSys.getFlywheelA() < INNER_TARGET_1 || Robot.cubeSys.getFlywheelA() > INNER_TARGET_2){
//				Robot.cubeSys.setBothFlywheels(.5);
//			}
			
			if(System.currentTimeMillis() - startTime >= endTime){
				Robot.cubeSys.setBothFlywheels(0);
				Robot.cubeSys.startCompression();
			}
				
//			
			
		}
	}

	protected boolean isFinished() {
		if(HumanInput.clawGrabButton.get()){
			return false;
		}
		else return true;
	}

	protected void end() {
		Robot.cubeSys.endCloseArm();
	}

	protected void interrupted() {
		end();
	}
}
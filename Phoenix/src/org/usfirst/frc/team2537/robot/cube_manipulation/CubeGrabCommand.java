package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.command.Command;

public class CubeGrabCommand extends Command {
	
	private final static double TARGET_SPEED = .5;
	private final static double INNER_TARGET_1 = .45;
	private final static double INNER_TARGET_2 = .55;
	private final static double P = .01;
	private final static double TOLERANCE = 10;
	private double currentVoltage = 0;
	private double distanceForward = 0;
	private long startTime;
	
	public CubeGrabCommand() {
		requires(Robot.cubeSys);
		requires(Robot.PIDSys);
	}
	
	protected void initialize() {
		startTime = System.currentTimeMillis();
		Robot.PIDSys.setBothFlywheels(.5);
		currentVoltage = .5;
	}
	
	protected void execute() {
		Robot.PIDSys.encoderOneToDistance();
		if(System.currentTimeMillis() - startTime <= 200) {
			if(Robot.PIDSys.getFlywheelA() < TARGET_SPEED - TOLERANCE || Robot.PIDSys.getFlywheelB() > TARGET_SPEED + TOLERANCE) {
				currentVoltage += (TARGET_SPEED - Robot.PIDSys.getFlywheelA())*P;
				Robot.PIDSys.setBothFlywheels(currentVoltage);
			}
			
			if(Robot.PIDSys.encOneDistance >= distanceForward) {
				Robot.PIDSys.setBothFlywheels(0);
				Robot.cubeSys.startCompression();
			}
			
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

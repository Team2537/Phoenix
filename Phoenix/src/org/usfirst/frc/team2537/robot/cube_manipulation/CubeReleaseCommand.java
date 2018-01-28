package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.command.Command;

public class CubeReleaseCommand extends Command {
	
	private final static double TARGET_SPEED = -.5;
	private final static double INNER_TARGET_1 = -.45;
	private final static double INNER_TARGET_2 = -.55;
	private final static double P = .01;
	private final static double I = .001;
	private final static double TOLERANCE = .01;
	private double currentVoltage = 0;
	private double distanceForward = 0;
	private long startTime;
	
	public CubeReleaseCommand() {
		requires(Robot.cubeSys);
	}
	
	protected void initialize() {
		startTime = System.currentTimeMillis();
		Robot.cubeSys.setBothFlywheels(-.3);
		currentVoltage = -.5;
	}
	protected void execute() {
		Robot.cubeSys.encoderOneToDistance();
		Robot.cubeSys.encoderOneToDistance();
		if(System.currentTimeMillis() - startTime >= 200) {
			if(Robot.cubeSys.getFlywheelA() < TARGET_SPEED - TOLERANCE || Robot.cubeSys.getFlywheelB() > TARGET_SPEED + TOLERANCE) {
				currentVoltage += (TARGET_SPEED - Robot.cubeSys.getFlywheelA())*P;
				Robot.cubeSys.setBothFlywheels(currentVoltage);
			}
		}
//		if(Robot.cubeSys.encOneDistance >= distanceForward) {
//			Robot.cubeSys.setBothFlywheels(0);
//			Robot.cubeSys.endCompression();
//		}
	}

	protected boolean isFinished() {
		if(HumanInput.clawReleaseButton.get()){
			return false;
		}
		else return true;
	}

	protected void end() {
//		Robot.cubeSys.endOpenArm();
	}

	protected void interrupted() {
		end();
	}
}

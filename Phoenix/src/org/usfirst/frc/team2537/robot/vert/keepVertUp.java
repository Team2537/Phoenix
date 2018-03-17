package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class keepVertUp extends Command {
	long startTime;
	double speedTest; 
	
	protected void initialize() {
	
		startTime = System.currentTimeMillis(); //timer
	
	}
	
	protected void execute() {
		speedTest = Robot.vertSys.getSpeedVertMotorOne();
		//checks how long the motor has gone without any joystick inputs; currently, it only checks if the cuber is falling and 
		if (speedTest < 0 && startTime >= 4000) { //when vertMotorOne begins sliding down vert actuator as timer reaches 4 seconds
			while(speedTest < 0) {                //motor will boost up back actuator to original position whenever it slides down
				speedTest = speedTest + .1;		 
				Robot.vertSys.setVertMotors(-speedTest);
			}

		}
	}
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() { 
		
	}
	
}

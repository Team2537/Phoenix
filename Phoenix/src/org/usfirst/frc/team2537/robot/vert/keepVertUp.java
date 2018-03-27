package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class keepVertUp extends Command {
	long startTime;
	double speedTest; 
	long elapsedTime;
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		speedTest = Robot.vertSys.getSpeedVertMotorOne();
		//checks how long the motor has gone without any joystick inputs; currently, it only checks if the cuber is falling and 
		startTime = System.nanoTime()/1000000; //timer
		
		while (speedTest < 0 ){
			elapsedTime = (System.nanoTime()/1000000)-startTime;//checks time since the vert started to fall
			if(elapsedTime >= 4000) {
				//when vertMotorOne begins sliding down vert actuator as timer reaches 4 seconds
				speedTest = speedTest - .1;		 
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

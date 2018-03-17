package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class keepVertUp extends Command {
	long startTime;
	double speedTest; 
	protected void initialize() {
		startTime = System.currentTimeMillis();
	}
	
	protected void execute() {
		speedTest = Robot.vertSys.getSpeedVertMotorOne();
		//checks how long the motor has gone without any joystick inputs; currently, it only checks if the cuber is falling and 
		if (speedTest < 0 && startTime >= 4000) { //when vertMotorOne begins sliding down vert actuator and timer reaches 4 seconds
			while(speedTest < 0) {                //while vertMotor is still sliding down
				speedTest = speedTest + .1;		  //motor will boost up back actuator to original position
				Robot.vertSys.setVertMotors(-speedTest);
			}
		speedTest = Robot.vertSys.getSpeedVertMotorOne(); 
		Robot.vertSys.setVertMotors(-speedTest); //sets motors to the opposite direction and power they are currently going
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

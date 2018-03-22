package org.usfirst.frc.team2537.robot.auto.recording;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.drive.Motor;

import edu.wpi.first.wpilibj.command.Command;

public class PlaybackCommand extends Command {
	
	String[][][] recordedArray;
	int count = 0;
	
	public PlaybackCommand() {
		requires(Robot.driveSys);
		requires(Robot.vertSys);
		requires(Robot.cuberSys);
	}
	
	@Override
	protected void initialize() {
		String recordedString = "";
		try {
			recordedString = new String(Files.readAllBytes(Paths.get("/home/lvuser/record")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] temp = recordedString.split("\n");
		recordedArray = new String[temp.length][][];
		for (int i = 0; i < temp.length; i++) {
			String[] temp2 = temp[i].split(";");
			for (int t = 0; t < temp2.length; t++) {
				recordedArray[i][t] = temp2[t].split(",");
			}
		}
	}
	
	@Override
	protected void execute() {
		Robot.driveSys.setMotors(new Double(recordedArray[count][0][0]), Motor.LEFT);
		Robot.driveSys.setMotors(new Double(recordedArray[count][0][1]), Motor.RIGHT);
		if (recordedArray[count][1][0] == "true") {
			if (!Robot.vertSys.getLimitSwitch())
				Robot.vertSys.setVertMotors(1);
		} else if (recordedArray[count][1][1] == "true") {
			Robot.vertSys.setVertMotors(-0.6);
		} else {
			if (!Robot.vertSys.getLimitSwitch())
				Robot.vertSys.setVertMotors(0.1);
		}
		
		if (recordedArray[count][2][0] == "true") {
			Robot.cuberSys.setFlywheelMotors(0.8);
		} else if (recordedArray[count][2][1] == "true") {
			Robot.cuberSys.setFlywheelMotors(-0.5);
		} else if (recordedArray[count][2][2] == "true") {
			Robot.cuberSys.setFlywheelMotors(-0.8);
		} else {
			Robot.cuberSys.setFlywheelMotors(0);
		}
		
		if (recordedArray[count][2][3] == "true") {
			if(!Robot.cuberSys.getHolifaxOne()) {
				Robot.cuberSys.setLiftMotor(1); //reverses direction to lift motor upwards
			} else {
				Robot.cuberSys.setLiftMotor(0);
			}		
		} else if (recordedArray[count][2][4] == "true") {
			if(!Robot.cuberSys.getHolifaxTwo()) {
				Robot.cuberSys.setLiftMotor(-1); //reverses direction to lift motor upwards
			} else {
				Robot.cuberSys.setLiftMotor(0);
			}
		} else {
			Robot.cuberSys.setLiftMotor(0);
		}
		count++;
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		Robot.driveSys.setMotors(0, Motor.ALL);
		Robot.vertSys.setVertMotors(0);
		Robot.cuberSys.setFlywheelMotors(0);
	}

	@Override
	protected void interrupted() {
		
	}
}

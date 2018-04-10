package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.drive.Motor;

import edu.wpi.first.wpilibj.command.Command;

public class ShittyAutoCommand extends Command{
	
	double speed;
	
	public ShittyAutoCommand(Double speed) {
		this.speed = speed;
	}

	@Override
	protected void initialize() {
		Robot.driveSys.setMotors(speed, Motor.ALL);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		Robot.driveSys.setMotors(0, Motor.ALL);
	}
	
	@Override
	protected void interrupted() {
		end();
	}

}

package org.usfirst.frc.team2537.robot.drive;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command {
	
	public DriveCommand() {
		requires(Robot.driveSys);
	}
	
	public void initialize() {
		
	}
	
	public void execute() {
		Robot.driveSys.setLeftMotors(Robot.driveSys.getLeftJoystick());
		Robot.driveSys.setRightMotors(Robot.driveSys.getRightJoystick());
	}

	@Override
	protected boolean isFinished() {
		
		return false;
	}
	
	@Override
	public void end() {
		Robot.driveSys.setLeftMotors(0);
		Robot.driveSys.setRightMotors(0);
	}
	
	public void interrupted() {
		Robot.driveSys.setLeftMotors(0);
		Robot.driveSys.setRightMotors(0);

	}

}

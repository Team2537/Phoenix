package org.usfirst.frc.team2537.robot.drive;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command {

	public DriveCommand() {
		requires(Robot.driveSys);
	}
	
	@Override
	protected void initialize() {

	}
	
	@Override 
	protected void execute() {
		Robot.driveSys.setMotors(Robot.driveSys.getLeftJoystick(), Robot.driveSys.getRightJoystick());
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

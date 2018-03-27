package org.usfirst.frc.team2537.robot.drive;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;

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
		Robot.driveSys.setMotors(-HumanInput.rightJoystick.getRawAxis(1), Motor.RIGHT);
		Robot.driveSys.setMotors(-HumanInput.leftJoystick.getRawAxis(1), Motor.LEFT);
//		Robot.driveSys.fixingDrive();
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

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
		Robot.driveSys.setLeftMotors(HumanInput.leftJoystick.getRawAxis(1), HumanInput.leftJoystick.getRawAxis(1));
		Robot.driveSys.setRightMotors(HumanInput.rightJoystick.getRawAxis(1),HumanInput.rightJoystick.getRawAxis(1)); 
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
}

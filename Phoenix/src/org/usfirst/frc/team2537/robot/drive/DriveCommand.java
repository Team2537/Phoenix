package org.usfirst.frc.team2537.robot.drive;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.cuber.ExpelCommand;
import org.usfirst.frc.team2537.robot.cuber.LiftFlipperCommand;
import org.usfirst.frc.team2537.robot.cuber.LowerFlipperCommand;
import org.usfirst.frc.team2537.robot.cuber.PickUpCommand;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command {

	public DriveCommand() {
		requires (Robot.driveSys);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Robot.driveSys.setRightMotorsSpeed(Robot.driveSys.checkRightJoystickValue());
		Robot.driveSys.setLeftMotorsSpeed(Robot.driveSys.checkLeftJoystickValue());
	}
	

	@Override
	protected boolean isFinished() {
		
		return false;
	}
	
	@Override
	protected void end() {
		Robot.driveSys.setLeftMotorsSpeed(0);
		Robot.driveSys.setRightMotorsSpeed(0);	
	}

	@Override
	protected void interrupted() {
		Robot.driveSys.setLeftMotorsSpeed(0);
		Robot.driveSys.setRightMotorsSpeed(0);
	}

}

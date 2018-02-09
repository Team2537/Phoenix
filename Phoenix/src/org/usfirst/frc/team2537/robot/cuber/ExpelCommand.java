package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ExpelCommand extends Command {
	double speed;
	public ExpelCommand() {
		requires(Robot.cuberSys);
	}
	
	@Override
	protected void initialize() {
		Robot.cuberSys.setFlywheelMotors(-speed);
		
		
	}
	
	@Override
	protected void execute() {
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void end() {
		Robot.cuberSys.setFlywheelMotors(0);
		
	}
	
	@Override
	protected void interrupted() {
		Robot.cuberSys.setFlywheelMotors(0);
		
	}

}

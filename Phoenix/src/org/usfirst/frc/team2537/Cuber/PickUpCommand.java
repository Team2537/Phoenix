package org.usfirst.frc.team2537.Cuber;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

public class PickUpCommand extends Command {
 double speed;
	public PickUpCommand() {
		requires(Robot.cuberSys);
	}
	
	@Override
	protected void initialize() {
		Robot.cuberSys.setFlywheelMotors(speed);
		
		
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

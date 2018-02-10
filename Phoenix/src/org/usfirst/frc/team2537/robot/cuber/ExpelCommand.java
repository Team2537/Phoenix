package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ExpelCommand extends Command {
	double speed; //local var for flywheel motor speed
	public ExpelCommand() {
		requires(Robot.cuberSys); //requires variables and methods form cuberSys
	}
	
	@Override
	protected void initialize() {
		Robot.cuberSys.setFlywheelMotors(-speed); // sets speed to reverse to expel out cube
		
		
	}
	
	@Override
	protected void execute() {
		
	}
	
	@Override
	protected boolean isFinished() { //returns true when Flywheel motors exceed max amp
		return(Robot.cuberSys.getRightFlywheelCurrent() >=  Robot.cuberSys.currentLimit || Robot.cuberSys.getLeftFlywheelCurrent() >=  Robot.cuberSys.currentLimit); 
	
	}
	
	@Override
	protected void end() { //sets Flywheel motor speed to zero
		Robot.cuberSys.setFlywheelMotors(0);
		
	}
	
	@Override
	protected void interrupted() { //sets Flywheel motor speed to zero
		Robot.cuberSys.setFlywheelMotors(0);
		
	}

}

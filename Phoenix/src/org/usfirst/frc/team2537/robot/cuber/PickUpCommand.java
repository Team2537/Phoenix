package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PickUpCommand extends Command {
 double speed;
	public PickUpCommand() {
		requires(Robot.cuberSys); //requires cuberSys variables and methods
	}
	
	@Override
	protected void initialize() {
		Robot.cuberSys.setFlywheelMotors(speed); //initializes Flywheel motors to designated speed
	}
	
	@Override
	protected void execute() {
		
	}
	
	@Override
	protected boolean isFinished() { //returns true when flywheel motors exceed max amp
		
		return(Robot.cuberSys.getRightFlywheelCurrent() >=  Robot.cuberSys.currentLimit || Robot.cuberSys.getLeftFlywheelCurrent() >=  Robot.cuberSys.currentLimit); 
	}
	
	@Override
	protected void end() {
		Robot.cuberSys.setFlywheelMotors(0);  //sets Flywheel motor speed to zero
	}
	
	@Override
	protected void interrupted() {
		Robot.cuberSys.setFlywheelMotors(0); //sets Flywheel motor speed to zero
	}

}









































































































// this is just here because it can be

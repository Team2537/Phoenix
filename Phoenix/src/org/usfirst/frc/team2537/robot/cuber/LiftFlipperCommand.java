package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftFlipperCommand extends Command {
	
	//	this is only here and not in cuberSys because eclipse hates me
	
	double speedLift = 0.3;
	
	protected LiftFlipperCommand() {
		requires(Robot.cuberSys);
		
	}

	protected void initialized() {
			
		Robot.cuberSys.setLiftMotor(-speedLift); //reverses direction to lift motor upwards
		
	}

	protected void execute() {
		
	
	}
	
	protected boolean isFinished() {
	
	return(Robot.cuberSys.getDegrees() <= 0); //returns true if motor turns over or equal to 0 degrees
}
	
	protected void end() {
		
		Robot.cuberSys.setLiftMotor(0);  //sets lift motor speed to zero
		Robot.cuberSys.resetEncoder();
		
	}
	
	protected void interrupted() {
		
		Robot.cuberSys.setLiftMotor(0);
		Robot.cuberSys.resetEncoder();
	}
	
}

package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;

public class LowerFlipperCommand extends Command {

	// this is only here and not in cuberSys because eclipse hates me

	double speedLower = 0.3; //local var for speed of lift/window motor
	
	protected LowerFlipperCommand() {
		requires(Robot.cuberSys); //requires cuberSys variables and methods

	}

	protected void initialized() {

		Robot.cuberSys.setLiftMotor(speedLower); //initializes speed  of lift motor to lower

	}

	protected void execute() {

		// Robot.cuberSys.getDegrees();

	}

	protected boolean isFinished() { //returns true if motor turns over or equal to 90 degrees or when flywheel motors exceed max amp
		
		return(Robot.cuberSys.getDegrees() >= 90 || Robot.cuberSys.getRightFlywheelCurrent() >= Robot.cuberSys.currentLimit) || Robot.cuberSys.getLeftFlywheelCurrent() >= Robot.cuberSys.currentLimit; //returns true if motor turns over or equal to 90 degrees

	}

	protected void end() {

		Robot.cuberSys.setLiftMotor(0); //sets lift motor speed to zero

	}

	protected void interrupted() { //sets lift motor speed to zero

		Robot.cuberSys.setLiftMotor(0);
		
	}
}

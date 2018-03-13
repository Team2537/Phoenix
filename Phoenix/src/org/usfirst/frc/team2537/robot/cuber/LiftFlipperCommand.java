package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class LiftFlipperCommand extends Command {

	// "this is only here and not in cuberSys because eclipse hates me" - alex

	double speedLift = 0.3; // local var used for window/lift motor
	
	protected LiftFlipperCommand() {
		requires(Robot.cuberSys);

	}

	protected void initialize() {
		// turns on motor only if limit switch isn't pressed or current limit not
		// exceeded
		if (Robot.cuberSys.checkLowerSwitch()
				|| Robot.cuberSys.getWindowMotorCurrent() >= Robot.cuberSys.currentLimit) {
			Robot.cuberSys.setLiftMotor(0);
		} else {
			Robot.cuberSys.setLiftMotor(-speedLift);
		}
	} 
	
	protected void execute() {
		
	}

	protected boolean isFinished() { //stops motor whenever flipper lowers cuber too much(could break bot) or current of window motor exceeds limit
		return ( Robot.cuberSys.checkLiftSwitch() || Robot.cuberSys.getWindowMotorCurrent() >= Robot.cuberSys.currentLimit);
			
	}

	protected void end() {

		Robot.cuberSys.setLiftMotor(0); // sets lift motor speed to zero
		//Robot.cuberSys.resetEncoder();

	}

	protected void interrupted() {

		Robot.cuberSys.setLiftMotor(0); // sets lift motor speed to zero
		//Robot.cuberSys.resetEncoder();
	}

}

//things that need to be done:
//when button is false, motor stops but keeps arm in place
//stop it from looping back to initialized
//use timeout in case limit switch breaks__

//if pressed, don't stop?
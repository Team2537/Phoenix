package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LowerFlipperCommand extends Command {

	// this is only here and not in cuberSys because eclipse hates me - alex

	double speedLower = 0.3; // local var for speed of lift/window motor
	double speedLift = .1;
	protected LowerFlipperCommand() {
		requires(Robot.cuberSys); // requires cuberSys variables and methods

	}

	protected void initialize() {
		// turns on motor only if limit switch isn't pressed or current limit not
		// exceeded
		if (Robot.cuberSys.checkLowerSwitch()
				|| Robot.cuberSys.getWindowMotorCurrent() >= Robot.cuberSys.currentLimit) {
			Robot.cuberSys.setLiftMotor(0);
		} else {
			Robot.cuberSys.setLiftMotor(speedLower);
		}
	} 

	protected void execute() {
		//prevents cuber from getting stuck 
		//by checking if vertical actuator is still moving 
		//while cuber stops and if cuber is also horizontal
		if (Robot.cuberSys.getFlipperRate() == 0) {
			if (Robot.cuberSys.getAngleFlipper() >= 80 && Robot.cuberSys.getAngleFlipper() <=100) { //measures angles 
				if (Robot.vertSys.getSpeedVertMotorOne() < 0 || Robot.vertSys.getSpeedVertMotorOne() > 0) { 
					Robot.cuberSys.setLiftMotor(speedLift); 
				}
			}
		}

	}

	/**
	 * prevents stalling by shutting off window motor when lower switch is on or
	 * motor amps exceed limit
	 */
	protected boolean isFinished() {
		return (Robot.cuberSys.checkLowerSwitch() //stops motor whenever flipper lowers cuber too much(could break bot) or current of window motor exceeds limit
				|| Robot.cuberSys.getWindowMotorCurrent() >= Robot.cuberSys.currentLimit);

	}

	protected void end() {

		Robot.cuberSys.setLiftMotor(0); // sets lift motor speed to zero

	}

	protected void interrupted() { // sets lift motor speed to zero

		Robot.cuberSys.setLiftMotor(0);

	}
}

// return (Robot.cuberSys.getDegrees() >= 90
// || Robot.cuberSys.getRightFlywheelCurrent() >= Robot.cuberSys.currentLimit)
// || Robot.cuberSys.getLeftFlywheelCurrent() >= Robot.cuberSys.currentLimit; //
// returns true if motor
// turns over or equal to 90
// degrees

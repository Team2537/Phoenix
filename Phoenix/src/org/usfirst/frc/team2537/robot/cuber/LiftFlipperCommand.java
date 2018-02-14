package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftFlipperCommand extends Command {

	// "this is only here and not in cuberSys because eclipse hates me" - alex

	double speedLift = 0.3; // local var used for window/lift motor

	protected LiftFlipperCommand() {
		requires(Robot.cuberSys);

	}

	protected void initialized() {

		Robot.cuberSys.setLiftMotor(-speedLift); // reverses direction to lift motor upwards

	}

	protected void execute() {

	}

	protected boolean isFinished() { // returns true if motor turns under or equal to 0 degrees or when flywheel
										// motors exceed max amp

		return (Robot.cuberSys.getDegrees() <= 0)
				|| Robot.cuberSys.getRightFlywheelCurrent() >= Robot.cuberSys.currentLimit
				|| Robot.cuberSys.getLeftFlywheelCurrent() >= Robot.cuberSys.currentLimit;
	}

	protected void end() {

		Robot.cuberSys.setLiftMotor(0); // sets lift motor speed to zero
		Robot.cuberSys.resetEncoder();

	}

	protected void interrupted() {

		Robot.cuberSys.setLiftMotor(0); // sets lift motor speed to zero
		Robot.cuberSys.resetEncoder();
	}

}

package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LowerFlipperCommand extends Command {

	// this is only here and not in cuberSys because eclipse hates me

	double speedLower = 0.3;

	protected LowerFlipperCommand() {
		requires(Robot.cuberSys);

	}

	protected void initialized() {

		Robot.cuberSys.setLiftMotor(speedLower);

	}

	protected void execute() {

		// Robot.cuberSys.getDegrees();

	}

	protected boolean isFinished() {

		return (Robot.cuberSys.getDegrees() >= 90); //returns true if motor turns over or equal to 90 degrees
	}

	protected void end() {

		Robot.cuberSys.setLiftMotor(0); //sets lift motor speed to zero

	}

	protected void interrupted() {

		Robot.cuberSys.setLiftMotor(0);
		
	}
}

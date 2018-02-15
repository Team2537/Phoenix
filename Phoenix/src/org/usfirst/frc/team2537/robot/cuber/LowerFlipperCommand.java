package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LowerFlipperCommand extends Command {

	private long startTime;

	protected LowerFlipperCommand() {
		requires(Robot.cuberSys); // requires cuberSys variables and methods

	}

	protected void initialized() {
		startTime = System.currentTimeMillis();
		Robot.cuberSys.setLiftMotor(0.3); // initializes speed of lift motor to lower

	}

	protected void execute() {

	}

	protected boolean isFinished() { // returns true if motor turns over or equal to 90 degrees or when flywheel
										// motors exceed max amp

		return (System.currentTimeMillis() - startTime >= CuberSubsystem.FLIPPER_TIMEOUT);
	}

	protected void end() {

		Robot.cuberSys.setLiftMotor(0); // sets lift motor speed to zero

	}

	protected void interrupted() { // sets lift motor speed to zero

		Robot.cuberSys.setLiftMotor(0);

	}
}

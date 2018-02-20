package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShittyLowerCubeCommand extends Command {

	double numSeconds;
	long startTime;

	public ShittyLowerCubeCommand(double numSeconds) {
		requires(Robot.cuberSys); // requires cuberSys variables and methods
		this.numSeconds=numSeconds;
	}

	@Override
	protected void initialize() {
		System.out.println("trying to lower");
		Robot.cuberSys.setLiftMotor(-1); // initializes speed of lift motor to lower
		startTime = System.currentTimeMillis();

	}

	@Override
	protected void execute() {

	}

	protected boolean isFinished() { // returns true if motor turns over or equal to 90 degrees or when flywheel
		return System.currentTimeMillis() - startTime > numSeconds * 1000;
	}

	protected void end() {

		Robot.cuberSys.setLiftMotor(0); // sets lift motor speed to zero
		System.out.println("hi");

	}

	protected void interrupted() { // sets lift motor speed to zero

		Robot.cuberSys.setLiftMotor(0);

	}
}

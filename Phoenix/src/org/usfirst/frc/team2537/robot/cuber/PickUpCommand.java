package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PickUpCommand extends Command {
	

	public PickUpCommand() {
		requires(Robot.cuberSys);
	}

	@Override
	protected void initialize() {
		Robot.cuberSys.setFlywheelMotors(0);
			if (Robot.cuberSys.getUltrasonicInches() > CuberSubsystem.ULTRASONIC_RANGE) {
			Robot.cuberSys.setFlywheelMotors(0.8);
		}

	}

	@Override
	protected void execute() {
		if (Robot.cuberSys.getUltrasonicInches() < CuberSubsystem.ULTRASONIC_RANGE) {
			Robot.cuberSys.setFlywheelMotors(0);
		}
		
		System.out.println(Robot.cuberSys.getUltrasonicInches());
		

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.cuberSys.setFlywheelMotors(0);
	}

	@Override
	protected void interrupted() {
		Robot.cuberSys.setFlywheelMotors(0);
	}

}

package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PickUpCommand extends Command {
	

	public PickUpCommand() {
		requires(Robot.cuberSys);
		requires(Robot.vertSys);
	}

	@Override
	protected void initialize() {
		Robot.vertSys.setVertMotors(-.1);
		Robot.cuberSys.setFlywheelMotors(0);
		if (Robot.cuberSys.getUltrasonicInches() > CuberSubsystem.ULTRASONIC_RANGE || Robot.cuberSys.ultrasonicOverride || Robot.cuberSys.getUltrasonicInches() <= 0.05) {
			Robot.cuberSys.setFlywheelMotors(0.75);
		}

	}

	@Override
	protected void execute() {
		if (Robot.cuberSys.getUltrasonicInches() < CuberSubsystem.ULTRASONIC_RANGE && Robot.cuberSys.getUltrasonicInches() > 0.05 && !Robot.cuberSys.ultrasonicOverride) {
			Robot.cuberSys.setFlywheelMotors(0);
		}
		if (Robot.vertSys.getBottomSwitch() == true) {
			Robot.vertSys.setVertMotors(0);
		}
		
//		System.out.println(Robot.cuberSys.getUltrasonicInches());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.vertSys.setVertMotors(0);
		Robot.cuberSys.setFlywheelMotors(0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}

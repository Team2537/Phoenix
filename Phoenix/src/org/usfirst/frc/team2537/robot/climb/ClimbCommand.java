package org.usfirst.frc.team2537.robot.climb;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
	/**
	 * 
	 * @author Space RAIDers
	 *
	 */
public class ClimbCommand extends Command {

	public ClimbCommand() {
		requires(Robot.climbSys);
	}

	protected void initialize() {
		Robot.climbSys.setClimbMotors(0.7);
	}

	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return (Robot.climbSys.getCurrentClimbMotorOne() > ClimbSubsystem.MAX_CURRENT) || 
				(Robot.climbSys.getCurrentClimbMotorTwo() > ClimbSubsystem.MAX_CURRENT) || 
				(Robot.climbSys.getCurrentClimbMotorThree() > ClimbSubsystem.MAX_CURRENT);
	}

	protected void end() {
		Robot.climbSys.setClimbMotors(0);
	}

	protected void interrupted() {
		Robot.climbSys.setClimbMotors(0);
	}
}

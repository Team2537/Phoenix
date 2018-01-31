package org.usfirst.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;
import org.usfirst.frc.team2537.robot.resources.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class VertUpCommand extends Command {

	private boolean moveUp;
	private boolean ending;
	private CANTalon vertMotor;
	
	public boolean moveUp(int stopMotorValue) {
		boolean isFinished = false;

		vertMotor.set(.3);
		System.out.println(vertMotor.getMotorOutputPercent());
		return isFinished;
	}

	public VertUpCommand(boolean moveUp) {
		requires(Robot.vertSys);
		this.moveUp = moveUp;
		
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.vertSys.moveUp(15);
		if (Robot.vertSys.getDistance() >=123456789) {
			Robot.vertSys.stopMotor();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {

		if (ending) {
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.vertSys.stopMotor();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.vertSys.stopMotor();
	}
}

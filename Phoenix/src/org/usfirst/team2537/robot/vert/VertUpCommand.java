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

	private boolean moveDown;
	private boolean isFinished;
	private final int STOP_ONE = 5;
	private Encoder vertEncoder;
	private CANTalon vertMotor;
	
	public boolean moveUp(int stopMotorValue) {
		boolean isFinished = false;

		// if(encoderValue == 0)
		vertMotor.set(.3);
		System.out.println(vertMotor.getMotorOutputPercent());
		// if(encoderValue == stopMotorValue)
		// {
		// stopMotor();
		// isFinished = true;
		// }

		return isFinished;
	}

	public VertUpCommand(boolean moveDown) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		requires(Robot.vertSys);
		this.moveDown = moveDown;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// int encoderValue = Robot.vertSys.getEncoder();

		if (!moveDown) {

			isFinished = (Robot.vertSys.moveUp(STOP_ONE));
			if (!HumanInput.raiseButton.get())
				isFinished = true;
		}

		if (moveDown) {
			isFinished = Robot.vertSys.moveDown(STOP_ONE);

			if (!HumanInput.lowerButton.get())
				isFinished = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {

		if (isFinished) {
			System.out.println("hi");
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

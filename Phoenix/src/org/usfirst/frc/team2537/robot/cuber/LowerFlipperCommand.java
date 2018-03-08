package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LowerFlipperCommand extends Command {


	public LowerFlipperCommand() {
		requires(Robot.cuberSys); // requires cuberSys variables and methods
		setTimeout(1.1);
	}

	@Override
	protected void initialize() {
		if(!Robot.cuberSys.getHolifaxTwo()) {
			Robot.cuberSys.setLiftMotor(-1); //reverses direction to lift motor upwards
		} else {
			Robot.cuberSys.setLiftMotor(0);
		}
	}

	@Override
	protected void execute() {
		if(Robot.cuberSys.getHolifaxTwo()) {
			Robot.cuberSys.setLiftMotor(0);
		}
	}

	protected boolean isFinished() { // returns true if motor turns over or equal to 90 degrees or when flywheel
		return (Robot.cuberSys.getHolifaxTwo()) || this.isTimedOut();
	}

	protected void end() {
		Robot.cuberSys.setLiftMotor(0); // sets lift motor speed to zero
	}

	protected void interrupted() { // sets lift motor speed to zero
		Robot.cuberSys.setLiftMotor(0);
	}
}

package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class VertDownCommand extends Command {

	private static final int AMP_LIMIT = 5;  //5 amps HECKKA TBD
	
	public VertDownCommand() {
		requires(Robot.vertSys);
		
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		Robot.vertSys.initDefaultCommand();
		//stops bot when it exceeds amp limit for channel 5
		if (Robot.vertSys.getCurrentOne() >= AMP_LIMIT) {
			Robot.vertSys.setVertMotors(0);
		} else {
			Robot.vertSys.setVertMotors(-Robot.vertSys.targetVelocity);
		}	
		//stops bot when it exceeds amp limit for channel 4
		if (Robot.vertSys.getCurrentTwo() >= AMP_LIMIT) {
			Robot.vertSys.setVertMotors(0);
		} else {
			Robot.vertSys.setVertMotors(-Robot.vertSys.targetVelocity);
		}	
			
}

	@Override
	protected boolean isFinished() {
		return Robot.vertSys.getLimitSwitchDown(); //this prevents actuator from moving too far down and breaking the robot.
	}

	@Override
	protected void end() {
		Robot.vertSys.setVertMotors(0); //turns off vertActuator whenever something listed in isFinished goes wrong 
	}

	@Override
	protected void interrupted() {
		Robot.vertSys.setVertMotors(0); //turns off vertActuator whenever switching to different command
	}

}

package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VertUpCommand extends Command {
	
	private static final int AMP_LIMIT = 5; //5 amps TBD

		// PID Loop
		private double kp;
		private double ki;
		private double kd;
		private double integralActivityZone = 2;

		private double computedSpeed;
		private double totalError;
		private double currentError;
		private double lastError;
		private double proportionTerm;
		private double integralTerm;
		private double derivativeTerm;
		
	
	public VertUpCommand() {
		requires(Robot.vertSys);
		currentError = 0.8 - Robot.vertSys.getCurrentOne();
	}

	protected void initialize() {
		
	}

	protected void execute() {
		
		//stops bot when it exceeds amp limit for channel 5
		if (Robot.vertSys.getCurrentOne() >= AMP_LIMIT) {
			Robot.vertSys.setVertMotors(0);
		} else {
			Robot.vertSys.setVertMotors(-0.8);
		}	
		//stops bot when it exceeds amp limit for channel 4
		if (Robot.vertSys.getCurrentTwo() >= AMP_LIMIT) {
			Robot.vertSys.setVertMotors(0);
		} else {
			Robot.vertSys.setVertMotors(-0.8);
		}	
		
		while(true) {

			// Placing limits on Integral term so it doesn't go wild
			if (lastError < integralActivityZone && lastError != 0) {
				totalError += lastError;
			} else {
				totalError = 0;
			}
			// Places cap on how large the integral term can be
			if (totalError >= 50 / ki) {
				totalError = 50 / ki;
			}
			if (lastError == 0) {
				derivativeTerm = 0;
			}

			proportionTerm = lastError * kp;
			integralTerm = totalError * ki;
			derivativeTerm = (currentError - lastError) * kd;
			// reset for next loop
			lastError = currentError;

			computedSpeed = proportionTerm + derivativeTerm + integralTerm;
			Robot.vertSys.setVertMotors(computedSpeed);

		}
		
	}

	protected boolean isFinished() {

		return (Robot.vertSys.getLimitSwitch());
		
	}

	protected void end() {
		Robot.vertSys.setVertMotors(0);
	}

	protected void interrupted() {
		Robot.vertSys.setVertMotors(0);
	}
}

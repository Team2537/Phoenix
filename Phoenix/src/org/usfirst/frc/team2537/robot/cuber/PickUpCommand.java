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
		if (Robot.cuberSys.voltageToDistance(Robot.cuberSys.getIRSensorVoltage()) < Robot.cuberSys.CUTOFF_DISTANCE)
			Robot.cuberSys.setFlywheelMotors(Robot.cuberSys.FLYWHEEL_SPEED);
	}
	
	@Override
	protected void execute() {
		
	}
	
	@Override
	protected boolean isFinished() {
		return (Robot.cuberSys.getRightFlywheelCurrent() >=  CuberSubsystem.FLYWHEEL_CURRENT_LIMIT || 
				Robot.cuberSys.getLeftFlywheelCurrent() >=  CuberSubsystem.FLYWHEEL_CURRENT_LIMIT || 
				Robot.cuberSys.voltageToDistance(Robot.cuberSys.getIRSensorVoltage()) < Robot.cuberSys.CUTOFF_DISTANCE);
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

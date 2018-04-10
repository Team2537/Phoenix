package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HoldCommand extends Command {
	
	public HoldCommand() {
		this.requires(Robot.vertSys);
	}
	
	@Override
	protected void initialize() {
		if (!Robot.vertSys.getBottomSwitch())
			Robot.vertSys.setVertMotors(0.1);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	

}

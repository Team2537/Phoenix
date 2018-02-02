package org.usfirst.frc.team2537.robot.vert;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.input.HumanInput;
import org.usfirst.frc.team2537.robot.resources.CANTalon;

import edu.wpi.first.wpilibj.command.Command;

public class VertDownCommand extends Command {
	
	private boolean ending;
	private boolean moveDown;
	private CANTalon vertMotor;
	
	public VertDownCommand(boolean moveDown) {
		requires(Robot.vertSys);
		this.moveDown = moveDown;
	}
	@Override 
	protected void initialize() {
		
	}
	
	@Override 
	protected void execute() {
		Robot.vertSys.moveDown(15);
		if (Robot.vertSys.getDistance() >=123456789) {
			Robot.vertSys.stopMotor();
		}
	}

	@Override
	protected boolean isFinished() {
		
		if (ending) {
			return true; 
			}
		return false;
	}
	
	@Override
	protected void end() {
		Robot.vertSys.stopMotor();
	}
	
	@Override 
	protected void interrupted() {
		Robot.vertSys.stopMotor();
	}

}

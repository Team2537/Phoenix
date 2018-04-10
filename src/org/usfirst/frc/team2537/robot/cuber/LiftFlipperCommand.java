package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftFlipperCommand extends Command {
		
	public LiftFlipperCommand() {
		requires(Robot.cuberSys);
		
	}

	protected void initialize() {
		if(!Robot.cuberSys.getHallEffectOne()) {
			Robot.cuberSys.setLiftMotor(1); //reverses direction to lift motor upwards
		} else {
			Robot.cuberSys.setLiftMotor(0);
		}		
	}

	protected void execute() {
		if(Robot.cuberSys.getHallEffectOne()) {
			Robot.cuberSys.setLiftMotor(0);
		}
	}
	
	protected boolean isFinished() { //returns true if motor turns under or equal to 0 degrees or when flywheel motors exceed max amp
		return (Robot.cuberSys.getHallEffectOne());
	}
	
	protected void end() {		
		Robot.cuberSys.setLiftMotor(0);  //sets lift motor speed to zero
	}
	
	protected void interrupted() {
		
		Robot.cuberSys.setLiftMotor(0); //sets lift motor speed to zero
	}
	
}

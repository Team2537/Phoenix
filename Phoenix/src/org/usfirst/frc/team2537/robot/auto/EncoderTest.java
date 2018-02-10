package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderTest extends Command {
	
	@Override
	protected void initialize(){
		Robot.driveSys.resetEncoders();
	}
	
	@Override
	protected void execute(){
//		System.out.println(Robot.driveSys.getEncoderDistance());
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

}

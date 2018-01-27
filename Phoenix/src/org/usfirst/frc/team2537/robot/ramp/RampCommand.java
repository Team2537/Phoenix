//package org.usfirst.frc.team2537.robot.ramp;
//
//import org.usfirst.frc.team2537.robot.Ports;
//import org.usfirst.frc.team2537.robot.Robot;
//
//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.command.Command;
//
//public class RampCommand extends Command {
//
//	public RampCommand() {
//		requires(Robot.rampSys);
//
//	}
//	@Override 
//	protected void initialize() {
//		Robot.rampSys.setRampMotor(.5);
//	}
//	
//	@Override
//	protected void execute() {
//		if(Robot.rampSys.getLimitSwitchA()) {
//			Robot.rampSys.setRampMotor(0);
//		}
//	
//		if(Robot.rampSys.getLimitSwitchB()) {
//			Robot.rampSys.setRightBackMotor(0);
//		}
//	}
//	
//	@Override
//	protected boolean isFinished() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	
//	@Override
//	protected void end() {
//		
//	}
//
//	@Override 
//	protected void interrupted() {
//		
//	}
//	
//}

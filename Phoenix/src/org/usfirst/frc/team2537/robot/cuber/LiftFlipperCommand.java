package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftFlipperCommand extends Command {
	
	//	"this is only here and not in cuberSys because eclipse hates me" - alex
	
	private long startTime;
	
	protected LiftFlipperCommand() {
		requires(Robot.cuberSys);
		
	}

	protected void initialize() {
		System.out.println("trying to lift");
//		startTime = System.currentTimeMillis();
		Robot.cuberSys.setLiftMotor(1); //reverses direction to lift motor upwards
		
	}

	protected void execute() {
		
	
	}
	
	protected boolean isFinished() { //returns true if motor turns under or equal to 0 degrees or when flywheel motors exceed max amp
//		return (System.currentTimeMillis() - startTime >= CuberSubsystem.FLIPPER_TIMEOUT);
		return false;
	}
	
	protected void end() {
		
		Robot.cuberSys.setLiftMotor(0);  //sets lift motor speed to zero
		
	}
	
	protected void interrupted() {
		
		Robot.cuberSys.setLiftMotor(0); //sets lift motor speed to zero
	}
	
}

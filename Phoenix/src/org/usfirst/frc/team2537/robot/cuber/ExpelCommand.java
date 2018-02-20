package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ExpelCommand extends Command {
	private long startTime;
	private final boolean isFast;
	
	public ExpelCommand(boolean isFast) {
		requires(Robot.cuberSys); //requires variables and methods form cuberSys
		this.isFast = isFast;
	}
	
	@Override
	protected void initialize() {
		if (isFast) {
			Robot.cuberSys.setFlywheelMotors(-0.8); // sets speed to reverse to expel out cube
			startTime = System.currentTimeMillis();
		} else {
			Robot.cuberSys.setFlywheelMotors(-0.5);
			startTime = System.currentTimeMillis();
		}
		
	}
	
	@Override
	protected void execute() {
		
	}
	
	@Override
	protected boolean isFinished() { //returns true when Flywheel motors exceed max amp
		/*return(Robot.cuberSys.getRightFlywheelCurrent() >= CuberSubsystem.FLYWHEEL_CURRENT_LIMIT
				|| Robot.cuberSys.getLeftFlywheelCurrent() >= CuberSubsystem.FLYWHEEL_CURRENT_LIMIT
				||*/ return System.currentTimeMillis() - startTime >= 2000;
	
	}
	
	@Override
	protected void end() { //sets Flywheel motor speed to zero
		Robot.cuberSys.setFlywheelMotors(0);
		
	}
	
	@Override
	protected void interrupted() { //sets Flywheel motor speed to zero
		Robot.cuberSys.setFlywheelMotors(0);
		
	}

}

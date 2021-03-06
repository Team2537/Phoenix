package org.usfirst.frc.team2537.robot.cuber;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ExpelCommand extends Command {
	private long startTime;
	private final double percentOutput;
	
	public ExpelCommand(double percentOutput) {
		requires(Robot.cuberSys); //requires variables and methods form cuberSys
		this.percentOutput = percentOutput;
	}
	
	@Override
	protected void initialize() {
			Robot.cuberSys.setFlywheelMotors(-percentOutput); // sets speed to reverse to expel out cube
			startTime = System.currentTimeMillis();
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

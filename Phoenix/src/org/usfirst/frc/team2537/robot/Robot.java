package org.usfirst.frc.team2537.robot;

import org.usfirst.frc.team2537.robot.cameras.Cameras;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
	public static Cameras cameras;
	
	@Override
	public void robotInit() {
		DriverStation.getInstance().getGameSpecificMessage();
	}

	@Override
	public void autonomousInit() {
		cameras = new Cameras();
		cameras.start();
	}

	@Override
	public void autonomousPeriodic() {
		
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		
	}
}

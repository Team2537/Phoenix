package org.usfirst.frc.team2537.robot;

import org.usfirst.frc.team2537.robot.cameras.Cameras;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
	public static Cameras cameras;
	
	@Override
	public void robotInit() {
		cameras = new Cameras();
		cameras.start();
		//things that could be added to the camera: if ultraviolet is attached, cube line shows when 1 foot away
	}

	@Override
	public void autonomousInit() {
		
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

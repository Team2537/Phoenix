package org.usfirst.frc.team2537.robot;

import org.usfirst.team2537.robot.vert.VertSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {



	public static VertSubsystem vertSys;

	@Override
	public void robotInit() {
		vertSys = new VertSubsystem();
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

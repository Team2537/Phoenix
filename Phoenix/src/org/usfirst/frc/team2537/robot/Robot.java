package org.usfirst.frc.team2537.robot;

import org.usfirst.frc.team2537.robot.climb.ClimbSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {

	public static ClimbSubsystem climbSys;

	@Override
	public void robotInit() {
		climbSys = new ClimbSubsystem();
		climbSys.registerButtons();

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

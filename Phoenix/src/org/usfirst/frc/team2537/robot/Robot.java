package org.usfirst.frc.team2537.robot;

import org.usfirst.frc.team2537.robot.cuber.CuberSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {

	public static CuberSubsystem cuberSys;
	public static DigitalInput infra;

	@Override
	public void robotInit() {
		DriverStation.getInstance().getGameSpecificMessage();
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

package org.usfirst.frc.team2537.robot;

import org.usfirst.frc.team2537.robot.ramp.RampSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
	
	public static RampSubsystem rampSys;
	@Override
	public void robotInit() {
		rampSys = new RampSubsystem();
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

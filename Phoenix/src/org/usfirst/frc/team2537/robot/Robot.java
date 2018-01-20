package org.usfirst.frc.team2537.robot;

import org.usfirst.frc.team2537.robot.drive.DriveSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Robot extends IterativeRobot {

	public static DriveSubsystem driveSys;

	@Override
	public void robotInit() {
		driveSys = new DriveSubsystem();
		driveSys.initDefaultCommand();
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

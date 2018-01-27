package org.usfirst.frc.team2537.robot;

import org.usfirst.frc.team2537.robot.cube_manipulation.CubeSubsystem;
import org.usfirst.frc.team2537.robot.cube_manipulation.PIDSubsystem;
import org.usfirst.frc.team2537.robot.drive.DriveSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Robot extends IterativeRobot {

	public static DriveSubsystem driveSys;
	public static CubeSubsystem cubeSys;
	public static PIDSubsystem PIDSys;

	@Override
	public void robotInit() {
		driveSys = new DriveSubsystem();
		driveSys.initDefaultCommand();
		cubeSys = new CubeSubsystem();
		cubeSys.registerButtons();
		PIDSys = new PIDSubsystem();
		
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

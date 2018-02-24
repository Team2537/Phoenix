package org.usfirst.frc.team2537.robot;

import org.usfirst.frc.team2537.robot.cuber.CuberSubsystem;
import org.usfirst.frc.team2537.robot.drive.DriveSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {

	public static DriveSubsystem driveSys;
	public static CuberSubsystem cuberSys;
	public static PowerDistributionPanel pdp;

	@Override
	public void robotInit() {
		cuberSys =  new CuberSubsystem();
		pdp = new PowerDistributionPanel();
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

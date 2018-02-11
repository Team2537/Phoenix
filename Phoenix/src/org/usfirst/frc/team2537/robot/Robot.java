package org.usfirst.frc.team2537.robot;

import org.usfirst.frc.team2537.robot.auto.EncoderTest;
import org.usfirst.frc.team2537.robot.auto.vision.SerialSubsystem;
import org.usfirst.frc.team2537.robot.climb.ClimbSubsystem;
import org.usfirst.frc.team2537.robot.cuber.CuberSubsystem;
import org.usfirst.frc.team2537.robot.drive.DriveSubsystem;
import org.usfirst.frc.team2537.robot.ramp.RampSubsystem;
import org.usfirst.frc.team2537.robot.vert.VertSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
	
	public static DriveSubsystem driveSys;
	public static VertSubsystem vertSys;
	public static ClimbSubsystem climbSys;
	public static RampSubsystem rampSys;
	public static SerialSubsystem serialSys;	
	public static CuberSubsystem cuberSys;

	

	
	public static long startTime;
	public static PowerDistributionPanel pdp;

	@Override
	public void robotInit() {
		driveSys = new DriveSubsystem();
		driveSys.initDefaultCommand();
		driveSys.resetEncoders();
		
		vertSys = new VertSubsystem();
		vertSys.registerButtons();
		
		climbSys = new ClimbSubsystem();
		climbSys.registerButtons();
		
		rampSys = new RampSubsystem();
		rampSys.registerButtons();
		
		cuberSys = new CuberSubsystem();
		cuberSys.registerButtons();
		
		serialSys = new SerialSubsystem();
		

	
		pdp = new PowerDistributionPanel(Ports.PDP);
		
		

	}

	@Override
	public void autonomousInit() {
	}

	@Override
	public void autonomousPeriodic() {

		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		new EncoderTest().start();
		startTime = System.currentTimeMillis();
		
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		System.out.println(Robot.vertSys.getLimitSwitch());

	}

	@Override
	public void testPeriodic() {
		
	}
	
}

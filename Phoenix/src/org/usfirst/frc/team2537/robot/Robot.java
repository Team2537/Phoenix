package org.usfirst.frc.team2537.robot;

import org.usfirst.frc.team2537.robot.auto.EncoderTest;
import org.usfirst.frc.team2537.robot.auto.vision.SerialSubsystem;
import org.usfirst.frc.team2537.robot.climb.ClimbSubsystem;
import org.usfirst.frc.team2537.robot.cube_manipulation.CubeSubsystem;
import org.usfirst.frc.team2537.robot.drive.DriveSubsystem;
import org.usfirst.frc.team2537.robot.ramp.RampSubsystem;
import org.usfirst.frc.team2537.robot.vert.VertSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static DriveSubsystem driveSys;
	public static VertSubsystem vertSys;
	public static ClimbSubsystem climbSys;
	public static RampSubsystem rampSys;
	public static SerialSubsystem serialSys;	
	public static CubeSubsystem cubeSys;

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
//		rampSys.registerButtons();
		
		serialSys = new SerialSubsystem();
		
		cubeSys = new CubeSubsystem();
		cubeSys.registerButtons();

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
		//serialSys.initDefaultCommand();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

	}

	@Override
	public void testPeriodic() {
	}
	
}

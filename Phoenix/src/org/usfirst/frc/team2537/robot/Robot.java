package org.usfirst.frc.team2537.robot;

import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.Navx;
import org.usfirst.frc.team2537.robot.auto.vision.ReadSerialCommand;
import org.usfirst.frc.team2537.robot.auto.vision.VisionInput;
import org.usfirst.frc.team2537.robot.cameras.Cameras;
import org.usfirst.frc.team2537.robot.climb.ClimbSubsystem;
import org.usfirst.frc.team2537.robot.cube_manipulation.CubeSubsystem;
import org.usfirst.frc.team2537.robot.drive.DriveSubsystem;
import org.usfirst.frc.team2537.robot.ramp.RampSubsystem;
import org.usfirst.frc.team2537.robot.vert.VertSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	public static CubeSubsystem cubeSys;
	public static Cameras cameras;
	public static SmartDashboard smartDashboard;
	public static VisionInput visionSerial;

	@Override
	public void robotInit() {
		driveSys = new DriveSubsystem();
		driveSys.initDefaultCommand();
		driveSys.resetEncoders();
		smartDashboard = new SmartDashboard();
		Navx.getInstance().reset();
		/*
		 * vertSys = new VertSubsystem(); vertSys.registerButtons();
		 * 
		 * climbSys = new ClimbSubsystem(); climbSys.registerButtons();
		 * 
		 * rampSys = new RampSubsystem(); // rampSys.registerButtons();
		 * 
		 * serialSys = new SerialSubsystem();
		 * 
		 * cubeSys = new CubeSubsystem(); cubeSys.registerButtons();
		 * 
		 * cameras = new Cameras(); cameras.start();
		 */
	}

	@Override
	public void autonomousInit() {
		new ReadSerialCommand().start();
		new DriveStraightCommand(100).start();
	}

	@Override
	public void autonomousPeriodic() {
		 Scheduler.getInstance().run();
		 Robot.driveSys.justFuckMyShitUpFam();
	}

	@Override
	public void teleopInit() {
		Scheduler.getInstance().removeAll();
		Robot.driveSys.resetEncoders();
	}

	@Override
	public void teleopPeriodic() {
		SmartDashboard.putNumber("angle",  Navx.getInstance().getAngle());
		SmartDashboard.putNumber("yaw", Navx.getInstance().getYaw());
		Scheduler.getInstance().run();
		System.out.println(Robot.driveSys.justFuckMyShitUpFam());
	}

	@Override
	public void testPeriodic() {
	}

}

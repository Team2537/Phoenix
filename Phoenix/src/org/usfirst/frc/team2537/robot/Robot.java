package org.usfirst.frc.team2537.robot;

import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.Navx;
import org.usfirst.frc.team2537.robot.auto.vision.VisionInput;
import org.usfirst.frc.team2537.robot.cameras.Cameras;
import org.usfirst.frc.team2537.robot.climb.ClimbSubsystem;
import org.usfirst.frc.team2537.robot.cuber.CuberSubsystem;
import org.usfirst.frc.team2537.robot.drive.DriveSubsystem;
import org.usfirst.frc.team2537.robot.ramp.RampSubsystem;
import org.usfirst.frc.team2537.robot.vert.VertSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	public static DriveSubsystem driveSys;
	public static VertSubsystem vertSys;
	public static ClimbSubsystem climbSys;
	public static RampSubsystem rampSys;
	public static CuberSubsystem cuberSys;
	
	public static Cameras cameras;
	
	public static PowerDistributionPanel pdp;
	
	public static SmartDashboard smartDashboard;
	public static VisionInput visionSerial;
	
	public static long startTime;
	

	@Override
	public void robotInit() {
		driveSys = new DriveSubsystem();
		driveSys.initDefaultCommand();
		driveSys.resetEncoders();
		
	/*	smartDashboard = new SmartDashboard();
		Navx.getInstance().reset();
		
	
		vertSys = new VertSubsystem();
		vertSys.registerButtons();
		
		climbSys = new ClimbSubsystem();
		climbSys.registerButtons();
		
		rampSys = new RampSubsystem();
		rampSys.registerButtons();*/
		
		cuberSys = new CuberSubsystem();
		cuberSys.registerButtons();

		/*visionSerial = new VisionInput();
	
		cameras = new Cameras();
		cameras.start();
		
		pdp = new PowerDistributionPanel();*/
		
		
	}

	@Override
	public void autonomousInit() {
		//new ReadSerialCommand().start();
		new DriveStraightCommand(50).start();
	}

	@Override
	public void autonomousPeriodic() {
		 Scheduler.getInstance().run();
		 Robot.driveSys.justFuckMyShitUpFam();
	}

	@Override
	public void teleopInit() {
		Scheduler.getInstance().removeAll();
		Navx.getInstance().reset();
		Robot.driveSys.resetEncoders();
		startTime = System.currentTimeMillis();
	}

	@Override
	public void teleopPeriodic() {
		SmartDashboard.putNumber("angle",  Navx.getInstance().getAngle());
		SmartDashboard.putNumber("pitch", Navx.getInstance().getPitch());
		SmartDashboard.putNumber("yaw", Navx.getInstance().getYaw());
		SmartDashboard.putNumber("roll", Navx.getInstance().getRoll());
		Scheduler.getInstance().run();
//		System.out.println(Robot.driveSys.justFuckMyShitUpFam());
	}

	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
		Robot.cuberSys.setOutput();
		System.out.println(Robot.cuberSys.getUltrasonicInches());
	
	}

}

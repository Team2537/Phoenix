package org.usfirst.frc.team2537.robot;

import static org.usfirst.frc.team2537.robot.util.Units.ft;
import static org.usfirst.frc.team2537.robot.util.Units.s;

import org.usfirst.frc.team2537.robot.auto.AutoChooser;
import org.usfirst.frc.team2537.robot.auto.Navx;
import org.usfirst.frc.team2537.robot.auto.motion.DriveSpline;
import org.usfirst.frc.team2537.robot.auto.vision.CoordinateSystems;
import org.usfirst.frc.team2537.robot.auto.vision.VisionInput;
import org.usfirst.frc.team2537.robot.climb.ClimbSubsystem;
import org.usfirst.frc.team2537.robot.cuber.CuberSubsystem;
import org.usfirst.frc.team2537.robot.drive.DriveSubsystem;
import org.usfirst.frc.team2537.robot.input.Cameras;
import org.usfirst.frc.team2537.robot.ramp.RampSubsystem;
import org.usfirst.frc.team2537.robot.vert.VertSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static DriveSubsystem driveSys;
	public static VertSubsystem vertSys;
	public static ClimbSubsystem climbSys;
	public static RampSubsystem rampSys;
	public static CuberSubsystem cuberSys;

//	public static PowerDistributionPanel pdp;

	public static SmartDashboard smartDashboard;
	public static VisionInput visionSerial;
	public static Cameras cameras;

	public static long startTime;
	public static String fmsData="OOO";
	public Command driveStraight;

	private static AutoChooser autoChooser;
	
	
	private static double maxVel = 0, maxAcc = 0, lastVel = 0;

	@Override
	public void robotInit() {
		driveSys = new DriveSubsystem();
		driveSys.initDefaultCommand();
		driveSys.resetEncoders();

		smartDashboard = new SmartDashboard();
		Navx.getInstance().reset();

		vertSys = new VertSubsystem();
		vertSys.registerButtons();
		vertSys.initDefaultCommand();

		climbSys = new ClimbSubsystem();
		climbSys.registerButtons();

		rampSys = new RampSubsystem();
		rampSys.registerButtons();

		cuberSys = new CuberSubsystem();
		cuberSys.registerButtons();

		visionSerial = new VisionInput();
		visionSerial.initDefaultCommand();
		
		cameras = new Cameras();
		cameras.start();

//		pdp = new PowerDistributionPanel();

		autoChooser = new AutoChooser();
		driveStraight = new DriveSpline(200);
	}

	@Override
	public void autonomousInit() {
		Scheduler.getInstance().removeAll();
//
		final int FMS_TIMEOUT=2; //num of seconds to wait before giving up on FMS
		long startTime=System.currentTimeMillis();
		while (DriverStation.getInstance().getGameSpecificMessage().length()==0 &&
				System.currentTimeMillis()-startTime < FMS_TIMEOUT*1000);
		fmsData=DriverStation.getInstance().getGameSpecificMessage();
		if (fmsData.length()==0)
			fmsData="OOO"; //if we can't get FMS data within 2 seconds, make dummy data

//		Scheduler.getInstance().add(autoChooser.getRoute(fmsData));
		System.out.println("HERE GOES NOTHING :^)");
		Scheduler.getInstance().add(driveStraight);
		//uncomment above or youre an idiot
//		Scheduler.getInstance().add(new DriveStraightCommand(180));
//		Scheduler.getInstance().add(new RotateCommand(90));
		//todo: comment below
//		Scheduler.getInstance().add(new VisionRotateCommand());
//		Scheduler.getInstance().add(new SameScaleSameSwitchRoute(true));
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		Robot.driveSys.justFuckMyShitUpFam();
//		if (visionSerial.getVisionPacket().length!=0) {
//			SmartDashboard.putString("center", visionSerial.getVisionPacket()[0].getBoundingBoxCenter().toString());
//		}
//		if (visionSerial.getVisionPacket().length!=0) {
//			SmartDashboard.putNumber("RPi Value", visionSerial.getVisionPacket()[0].getBoundingBoxCenter().getY(CoordinateSystems.CARTESIAN));
//		}
//		System.out.println(Robot.driveSys.justFuckMyShitUpFam());

	}

	@Override
	public void teleopInit() {
//		Robot.vertSys.resetEncoder();
		Scheduler.getInstance().removeAll();
		Navx.getInstance().reset();
//		Robot.driveSys.resetEncoders();
		startTime = System.currentTimeMillis();
		Robot.vertSys.resetEncoder(); 
		Robot.driveSys.resetEncoders();
		
		maxVel = 0;
		maxAcc = 0;
		lastVel = 0;
	}

	@Override
	public void teleopPeriodic() {
		Robot.driveSys.justFuckMyShitUpFam();
/*		SmartDashboard.putNumber("angle",  Navx.getInstance().getAngle());
		SmartDashboard.putNumber("pitch", Navx.getInstance().getPitch());
		SmartDashboard.putNumber("yaw", Navx.getInstance().getYaw());
		SmartDashboard.putNumber("roll", Navx.getInstance().getRoll());
		SmartDashboard.putNumber("Cuber Ultrasonic", Robot.cuberSys.getUltrasonicInches());
		SmartDashboard.putNumber("Drive Ultrasonic", Robot.driveSys.getUltrasonicRange());*/
		SmartDashboard.putBoolean("Lift override enabled", !Robot.vertSys.enableReedSwitch);
		Scheduler.getInstance().run();
		if (visionSerial.getVisionPacket().length!=0) {
			SmartDashboard.putNumber("RPi Value", visionSerial.getVisionPacket()[0].getBoundingBoxCenter().getY(CoordinateSystems.CARTESIAN));
		}
//		if(Robot.rampSys.isOpen) {
//			SmartDashboard.putString("Ramp is Open", "THE RAMP IS OPEN YOU SURE YOU WANT THIS");
//		}
		
		double vel = Robot.driveSys.getEncoderVelocity()/(ft/s);
		double acc = (vel-lastVel)/(0.02*s); // 20 ms (WPILib cycle time)
		
		maxVel = Math.max(vel, maxVel);
		maxAcc = Math.max(acc, maxAcc);
		lastVel = vel;
		
		SmartDashboard.putNumber("MaxVel", maxVel);
		SmartDashboard.putNumber("MaxAcc", maxAcc);
		
	}
	
	@Override
	public void testInit() {

	}

	@Override
	public void testPeriodic() {
	
	}

	@Override
	public void disabledPeriodic() {
		SmartDashboard.putBoolean("Hall Effect", cuberSys.getHallEffectOne());
		SmartDashboard.putBoolean("Bottom reed switch", vertSys.getBottomSwitch());
		SmartDashboard.putBoolean("Top reid switch", vertSys.getTopSwitch());
		if (visionSerial.getVisionPacket().length!=0) {
			SmartDashboard.putNumber("RPi Value", visionSerial.getVisionPacket()[0].getBoundingBoxCenter().getY(CoordinateSystems.CARTESIAN));
		}
		SmartDashboard.putNumber("Angle", Navx.getInstance().getAngle());
	}
	

}

package org.usfirst.frc.team2537.robot.cuber;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.usfirst.frc.team2537.robot.Ports;
import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PickUpCommand extends Command {
	
	private String filename;
	private Path dataPath;
	private PrintWriter writer;
	private double avgAmps;
	private long startTime;


	public PickUpCommand() {
		requires(Robot.cuberSys);
	}

	@Override
	protected void initialize() {
		Robot.cuberSys.setFlywheelMotors(0);
			if (Robot.cuberSys.getUltrasonicInches() > CuberSubsystem.ULTRASONIC_RANGE) {
			Robot.cuberSys.setFlywheelMotors(0.8);
		}
//		
//		filename = "/home/lvuser/cuberAmps"
//				+ new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()) + ".csv";
//		dataPath = Paths.get(filename);
//		if (Files.exists(dataPath)) {
//			System.out.println("File " + dataPath + " already exists. It shouldn't.");
//		}
//
//		try {
//			Files.createFile(dataPath);
//			writer = new PrintWriter(filename);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		writer.println("Time (ms),Current (amps)");
//		startTime = System.currentTimeMillis();
//		avgAmps = (Robot.pdp.getCurrent(Ports.LEFT_FLYWHEEL_PDP_CHANNEL) + Robot.pdp.getCurrent(Ports.RIGHT_FLYWHEEL_PDP_CHANNEL)) / 2;
//		writer.println(System.currentTimeMillis() - startTime + "," + avgAmps);
	}

	@Override
	protected void execute() {
		Robot.cuberSys.setOutput();
		if (Robot.cuberSys.getUltrasonicInches() < CuberSubsystem.ULTRASONIC_RANGE
				/*||Robot.cuberSys.getRightFlywheelCurrent() >= CuberSubsystem.FLYWHEEL_CURRENT_LIMIT
				|| Robot.cuberSys.getLeftFlywheelCurrent() >= CuberSubsystem.FLYWHEEL_CURRENT_LIMIT*/) {
			Robot.cuberSys.setFlywheelMotors(0);
		}
		
		System.out.println(Robot.cuberSys.getUltrasonicInches());
		
//		avgAmps = (Robot.pdp.getCurrent(Ports.LEFT_FLYWHEEL_PDP_CHANNEL) + Robot.pdp.getCurrent(Ports.RIGHT_FLYWHEEL_PDP_CHANNEL)) / 2;
//		writer.println(System.currentTimeMillis() - startTime + "," + avgAmps);

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.cuberSys.setFlywheelMotors(0);
//		writer.flush();
//		writer.close();
	}

	@Override
	protected void interrupted() {
		Robot.cuberSys.setFlywheelMotors(0);
//		writer.flush();
//		writer.close();
	}

}

package org.usfirst.frc.team2537.robot.climb;

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

public class ClimbCommand extends Command {
	
	private static final int BUTTON_LOCK = 105000; // 1:45 fron teleop starts until we can climb
	
	private static final double SPEED = .75;
	
	private long startTime;
	private String filename;
	private Path dataPath;
	private PrintWriter writer;
	private double avgAmps;

	public ClimbCommand() {
		requires(Robot.climbSys);
	}

	protected void initialize() {
//		if (System.currentTimeMillis() - Robot.startTime >= BUTTON_LOCK) {
			Robot.climbSys.setClimbMotors(SPEED);
//		} 
		
		filename = "/home/lvuser/climberAmps"
				+ new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()) + ".csv";
		dataPath = Paths.get(filename);
		if (Files.exists(dataPath)) {
			System.out.println("File " + dataPath + " already exists. It shouldn't.");
		}

		try {
			Files.createFile(dataPath);
			writer = new PrintWriter(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		writer.println("Time (ms),Current (amps)");
		startTime = System.currentTimeMillis();
		avgAmps = (Robot.pdp.getCurrent(Ports.CLIMB_MOTOR_ONE_PDP) + Robot.pdp.getCurrent(Ports.CLIMB_MOTOR_TWO_PDP) + Robot.pdp.getCurrent(Ports.CLIMB_MOTOR_THREE_PDP)) / 3;
		writer.println(System.currentTimeMillis() - startTime + "," + avgAmps);
	}

	protected void execute() {
		avgAmps = (Robot.pdp.getCurrent(Ports.CLIMB_MOTOR_ONE_PDP) + Robot.pdp.getCurrent(Ports.CLIMB_MOTOR_TWO_PDP) + Robot.pdp.getCurrent(Ports.CLIMB_MOTOR_THREE_PDP)) / 3;
		writer.println(System.currentTimeMillis() - startTime + "," + avgAmps);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.climbSys.setClimbMotors(0);
		writer.flush();
		writer.close();
	}

	protected void interrupted() {
		Robot.climbSys.setClimbMotors(0);
		writer.flush();
		writer.close();
	}
}
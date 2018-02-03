package org.usfirst.frc.team2537.robot.cube_manipulation;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CubeReleaseCommand extends Command {
	private long startTime;
	private static final int WAIT_TIME = 1000; // 1 second

	public CubeReleaseCommand() {
		requires(Robot.cubeSys);
	}

	protected void initialize() {
		startTime = System.currentTimeMillis();
		Robot.cubeSys.openReleasePiston();
	}

	protected void execute() {

	}

	protected boolean isFinished() {
		return (System.currentTimeMillis() - startTime > WAIT_TIME);
	}

	protected void end() {
		Robot.cubeSys.closeReleasePiston();
	}

	protected void interrupted() {
		Robot.cubeSys.closeReleasePiston();
	}
}

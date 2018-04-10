package org.usfirst.frc.team2537.robot.auto.vision;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetVision extends Command {

    public ResetVision() {
    	requires(Robot.visionSerial);
    }
    protected void initialize() {
    	Robot.visionSerial.clearCache();
    }
    protected boolean isFinished() {
        return true;
    }
}

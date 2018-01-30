package org.usfirst.frc.team2537.robot.drive;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {

	@Override
	public void initDefaultCommand() {
		this.setDefaultCommand(new DriveCommand());
	}

}

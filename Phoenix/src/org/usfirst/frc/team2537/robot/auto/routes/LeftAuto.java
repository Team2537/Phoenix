package org.usfirst.frc.team2537.robot.auto.routes;

import org.usfirst.frc.team2537.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftAuto extends CommandGroup {
	public LeftAuto() {
		switch(Robot.fmsData.substring(0, 2)) {
		case "LL":
			break;
		case "LR":
			break;
		case "RL":
			break;
		case "RR":
			break;
		default:
			System.out.println("fmsData is " + Robot.fmsData + ", and LeftAuto did not recognize it.");
			break;
		}
	}
}

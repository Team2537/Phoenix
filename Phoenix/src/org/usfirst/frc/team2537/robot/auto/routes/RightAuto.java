package org.usfirst.frc.team2537.robot.auto.routes;

import org.usfirst.frc.team2537.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightAuto extends CommandGroup {
	public RightAuto() {
		switch(Robot.fmsData.substring(0, 2)) {
		case "RR":
			break;
		case "RL":
			break;
		case "LR":
			break;
		case "LL":
			break;
		default:
			System.out.println("fmsData is " + Robot.fmsData + ", and RightAuto did not recognize it.");
			break;
		}
	}
}

package org.usfirst.frc.team2537.robot.auto.routes;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.SameScaleSameSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.SameSwitchSameSwitchRoute;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftSoloAuto extends CommandGroup {
	public LeftSoloAuto() {
		switch(Robot.fmsData.substring(0, 2)) {
		case "LL":
			addSequential(new SameScaleSameSwitchRoute(true));
			break;
		case "LR":
			addSequential(new SameSwitchSameSwitchRoute(true));
			break;
		case "RL":
			break;
		case "RR":
			break;
		default:
			System.out.println("fmsData is " + Robot.fmsData + ", and LeftSoloAuto did not recognize it.");
			break;
		}
	}
}

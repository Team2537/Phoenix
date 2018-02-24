package org.usfirst.frc.team2537.robot.auto.routes;

import org.usfirst.frc.team2537.robot.Robot;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.SameScaleSameSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.SameSwitchSameSwitchRoute;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightCoopAuto extends CommandGroup {
	public RightCoopAuto() {
		switch(Robot.fmsData.substring(0, 2)) {
		case "RR":
			addSequential(new SameScaleSameSwitchRoute(false));
			break;
		case "RL":
			addSequential(new SameSwitchSameSwitchRoute(false));
			break;
		case "LR":
			break;
		case "LL":
			break;
		default:
			System.out.println("fmsData is " + Robot.fmsData + ", and RightCoopAuto did not recognize it.");
			break;
		}
	}
}

package org.usfirst.frc.team2537.robot.auto.routes.twocube;

import org.usfirst.frc.team2537.robot.auto.routes.onecube.SameSideSwitchRoute;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SameSwitchSameSwitchRoute extends CommandGroup {
	public SameSwitchSameSwitchRoute(boolean left) {
		addSequential(new SameSideSwitchRoute(left));
	}
}

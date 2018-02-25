package org.usfirst.frc.team2537.robot.auto.routes.twocube;

import org.usfirst.frc.team2537.robot.auto.routes.onecube.SameSideScaleRoute;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SameScaleSameSwitchRoute extends CommandGroup {
	public SameScaleSameSwitchRoute(boolean left) {
		addSequential(new SameSideScaleRoute(left));
	}
}

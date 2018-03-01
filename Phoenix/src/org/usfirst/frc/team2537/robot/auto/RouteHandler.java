package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.SameScaleSameSwitchRoute;

public class RouteHandler extends CommandGroup {
	public RouteHandler(AutoChooserOption autoChooserOption) {
		String fmsCroppedConfiguration = Robot.fmsData.substring(0, 2);
		if(autoChooserOption == AutoChooserOption.SOLO_LEFT) {
			switch(fmsCroppedConfiguration) {
			case "LL":
				addSequential(new SameScaleSameSwitchRoute(true));
				break;
			case "LR":
				//addSequential(new SameSwitchOppositeScale(true));
				break;
			case "RL":
				break;
			case "RR":
				break;
			}
		} else if(autoChooserOption == AutoChooserOption.SOLO_RIGHT) {
			switch(fmsCroppedConfiguration) {
			case "LL":
				break;
			case "LR":
				break;
			case "RL":
				break;
			case "RR":
				break;
			}
		} else if(autoChooserOption == AutoChooserOption.CO_OP_LEFT) {
			switch(fmsCroppedConfiguration) {
			case "LL":
				break;
			case "LR":
				break;
			case "RL":
				break;
			case "RR":
				break;
			}
		} else if(autoChooserOption == AutoChooserOption.CO_OP_RIGHT){
			switch(fmsCroppedConfiguration) {
			case "LL":
				break;
			case "LR":
				break;
			case "RL":
				break;
			case "RR":
				break;
			}
		} else {
			System.err.println("ERROR: invalid AutoChooserOption");
		}
	}
	
	public enum AutoChooserOption{
		SOLO_LEFT,
		SOLO_RIGHT,
		CO_OP_LEFT,
		CO_OP_RIGHT
	}
}

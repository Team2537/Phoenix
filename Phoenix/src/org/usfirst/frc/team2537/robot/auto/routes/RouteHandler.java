package org.usfirst.frc.team2537.robot.auto.routes;

import org.usfirst.frc.team2537.robot.auto.routes.twocube.SameScaleSameSwitchRoute;

import edu.wpi.first.wpilibj.command.Command;

public class RouteHandler {
	public static Command HandleRoute(AutoChooserOption autoChooserOption, String fmsData) {
		String fmsCroppedConfiguration = fmsData.substring(0, 2);
		if(autoChooserOption == AutoChooserOption.SOLO_LEFT) {
			switch(fmsCroppedConfiguration) {
			case "LL":
				return new SameScaleSameSwitchRoute(true);
			case "LR":
				//addSequential(new SameSwitchOppositeScale(true));
				break;
			case "RL":
				break;
			case "RR":
				break;
			default:
				System.out.println("Invalid fmsData " + fmsData + " was cropped to " + fmsCroppedConfiguration);	
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
			default:
				System.out.println("Invalid fmsData " + fmsData + " was cropped to " + fmsCroppedConfiguration);	
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
			default:
				System.out.println("Invalid fmsData " + fmsData + " was cropped to " + fmsCroppedConfiguration);	
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
			default:
				System.out.println("Invalid fmsData " + fmsData + " was cropped to " + fmsCroppedConfiguration);	
				break;
			}
		} else {
			System.err.println("ERROR: invalid AutoChooserOption");
		}
		System.err.println("Something should have returned before you reach this code :(");
		return null;
	}
	
	public enum AutoChooserOption{
		SOLO_LEFT,
		SOLO_RIGHT,
		CO_OP_LEFT,
		CO_OP_RIGHT
	}
}

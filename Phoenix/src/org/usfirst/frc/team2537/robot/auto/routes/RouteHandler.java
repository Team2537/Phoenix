package org.usfirst.frc.team2537.robot.auto.routes;

import org.usfirst.frc.team2537.robot.auto.routes.onecube.OppositeSideScaleRoute;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.OppositeSideSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.SameSideScaleRoute;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.SameSideSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.OppositeSwitchOppositeScaleRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.SameScaleOppositeSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.SameScaleSameSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.SameSwitchSameScaleRoute;

import edu.wpi.first.wpilibj.command.Command;

public class RouteHandler {
	public static Command HandleRoute(AutoChooserOption autoChooserOption, String fmsData) {
		String fmsCroppedConfiguration = fmsData.substring(0, 2);
		if(autoChooserOption == AutoChooserOption.SOLO_LEFT) {
			switch(fmsCroppedConfiguration) {
			case "LL":
				return new SameSwitchSameScaleRoute(true);
			case "LR":
				return new SameSideSwitchRoute(true);
			case "RL":
				return new SameScaleOppositeSwitchRoute(true);
			case "RR":
				return new OppositeSwitchOppositeScaleRoute(true);
			default:
				System.out.println("Invalid fmsData " + fmsData + " was cropped to " + fmsCroppedConfiguration);	
				return null;
			}
		} else if(autoChooserOption == AutoChooserOption.SOLO_RIGHT) {
			switch(fmsCroppedConfiguration) {
			case "LL":
				return new OppositeSwitchOppositeScaleRoute(false);
			case "LR":
				return new SameScaleOppositeSwitchRoute(false);
			case "RL":
				return new SameSideSwitchRoute(false);
			case "RR":
				return new SameSwitchSameScaleRoute(false);
			default:
				System.out.println("Invalid fmsData " + fmsData + " was cropped to " + fmsCroppedConfiguration);	
				return null;
			}
		} else if(autoChooserOption == AutoChooserOption.CO_OP_LEFT) {
			switch(fmsCroppedConfiguration) {
			case "LL":
				return new SameSwitchSameScaleRoute(true);
			case "LR":
				return new SameSideSwitchRoute(true);
			case "RL":
				return new SameScaleOppositeSwitchRoute(true);
			case "RR":
				return new OppositeSideScaleRoute(true);
			default:
				System.out.println("Invalid fmsData " + fmsData + " was cropped to " + fmsCroppedConfiguration);	
				return null;
			}
		} else if(autoChooserOption == AutoChooserOption.CO_OP_RIGHT){
			switch(fmsCroppedConfiguration) {
			case "LL":
				return new OppositeSideScaleRoute(false);
			case "LR":
				return new SameScaleOppositeSwitchRoute(false);
			case "RL":
				return new SameSideSwitchRoute(false);
			case "RR":
				return new SameSwitchSameScaleRoute(false);
			default:
				System.out.println("Invalid fmsData " + fmsData + " was cropped to " + fmsCroppedConfiguration);	
				return null;
			}
        } else if(autoChooserOption == AutoChooserOption.SCALE_LEFT) {
			switch(fmsCroppedConfiguration) {
			case "LL":
                return new SameScaleSameSwitchRoute(true);
			case "LR":
				return new OppositeSideScaleRoute(true);
			case "RL":
                return new SameScaleOppositeSwitchRoute(true);
			case "RR":
				return new OppositeSideScaleRoute(true);
			default:
				System.out.println("Invalid fmsData " + fmsData + " was cropped to " + fmsCroppedConfiguration);	
				return null;
			}
        } else if(autoChooserOption == AutoChooserOption.SCALE_RIGHT) {
			switch(fmsCroppedConfiguration) {
			case "LL":
				return new OppositeSideScaleRoute(false);
			case "LR":
                return new SameScaleOppositeSwitchRoute(false);
			case "RL":
				return new OppositeSideScaleRoute(false);
			case "RR":
                return new SameScaleSameSwitchRoute(false);
			default:
				System.out.println("Invalid fmsData " + fmsData + " was cropped to " + fmsCroppedConfiguration);	
				return null;
			}
		} else {
			System.err.println("ERROR: invalid AutoChooserOption");
			return null;
		}
	}
	
	public enum AutoChooserOption{
		SOLO_LEFT,
		SOLO_RIGHT,
		CO_OP_LEFT,
		CO_OP_RIGHT,
		SCALE_LEFT,
		SCALE_RIGHT
	}
}

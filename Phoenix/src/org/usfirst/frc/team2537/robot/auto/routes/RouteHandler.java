package org.usfirst.frc.team2537.robot.auto.routes;

import org.usfirst.frc.team2537.robot.auto.DriveStraightCommand;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.OppositeSideScaleRoute;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.OppositeSideSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.SameSideScaleRoute;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.SameSideSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.OppositeScaleOppositeSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.OppositeSwitchOppositeScaleRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.SameScaleOppositeSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.SameScaleSameSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.SameSwitchOppositeScaleRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.SameSwitchSameScaleRoute;

import edu.wpi.first.wpilibj.command.Command;

public class RouteHandler {
	private static final boolean TWO_CUBE = false;
	
	public static Command HandleRoute(AutoChooserOption autoChooserOption, String fmsData) {
		String fmsCroppedConfiguration = fmsData.substring(0, 2);
		if(autoChooserOption == AutoChooserOption.DRIVE_STRAIGHT) {
			System.out.println("Why are you doing this");
			return new DriveStraightCommand(180);
		} else if(autoChooserOption == AutoChooserOption.SOLO_LEFT) {
			switch(fmsCroppedConfiguration) {
			case "LL":
				if(TWO_CUBE) return new SameSwitchSameScaleRoute(true);
				else return new SameSideSwitchRoute(true);
			case "LR":
				if(TWO_CUBE) return new SameSwitchOppositeScaleRoute(true);
				else return new SameSideSwitchRoute(true);
			case "RL":
				if(TWO_CUBE) return new SameScaleOppositeSwitchRoute(true);
				else return new OppositeSideSwitchRoute(true);
			case "RR":
				if(TWO_CUBE) return new OppositeSwitchOppositeScaleRoute(true);
				else return new OppositeSideSwitchRoute(true);
			default:
				System.out.println("Invalid fmsData " + fmsData + " was cropped to " + fmsCroppedConfiguration);	
				return null;
			}
		} else if(autoChooserOption == AutoChooserOption.SOLO_RIGHT) {
			switch(fmsCroppedConfiguration) {
			case "LL":
				if(TWO_CUBE) return new OppositeSwitchOppositeScaleRoute(false);
				else return new OppositeSideSwitchRoute(false);
			case "LR":
				if(TWO_CUBE) return new SameScaleOppositeSwitchRoute(false);
				else return new OppositeSideSwitchRoute(false);
			case "RL":
				if(TWO_CUBE) return new SameSwitchOppositeScaleRoute(false);
				else return new SameSideSwitchRoute(false);
			case "RR":
				if(TWO_CUBE) return new SameSwitchSameScaleRoute(false);
				else return new SameSideSwitchRoute(false);
			default:
				System.out.println("Invalid fmsData " + fmsData + " was cropped to " + fmsCroppedConfiguration);	
				return null;
			}
		} else if(autoChooserOption == AutoChooserOption.CO_OP_LEFT) {
			switch(fmsCroppedConfiguration) {
			case "LL":
				if(TWO_CUBE) return new SameSwitchSameScaleRoute(true);
				else return new SameSideSwitchRoute(true);
			case "LR":
				if(TWO_CUBE) return new SameSwitchOppositeScaleRoute(true);
				else return new SameSideSwitchRoute(true);
			case "RL":
				if(TWO_CUBE) return new SameScaleOppositeSwitchRoute(true);
				else return new SameSideScaleRoute(true);
			case "RR":
				if(TWO_CUBE) return new OppositeScaleOppositeSwitchRoute(true);
				else return new OppositeSideScaleRoute(true);
			default:
				System.out.println("Invalid fmsData " + fmsData + " was cropped to " + fmsCroppedConfiguration);	
				return null;
			}
		} else if(autoChooserOption == AutoChooserOption.CO_OP_RIGHT){
			switch(fmsCroppedConfiguration) {
			case "LL":
				if(TWO_CUBE) return new OppositeScaleOppositeSwitchRoute(false);
				else return new OppositeSideScaleRoute(false);
			case "LR":
				if(TWO_CUBE) return new SameScaleOppositeSwitchRoute(false);
				else return new SameSideScaleRoute(false);
			case "RL":
				if(TWO_CUBE) return new SameSwitchOppositeScaleRoute(false);
				else return new SameSideSwitchRoute(false);
			case "RR":
				if(TWO_CUBE) return new SameSwitchSameScaleRoute(false);
				else return new SameSideSwitchRoute(false);
			default:
				System.out.println("Invalid fmsData " + fmsData + " was cropped to " + fmsCroppedConfiguration);	
				return null;
			}
        } else if(autoChooserOption == AutoChooserOption.SCALE_LEFT) {
			switch(fmsCroppedConfiguration) {
			case "LL":
                if(TWO_CUBE) return new SameScaleSameSwitchRoute(true);
                else return new SameSideScaleRoute(true);
			case "LR":
				if(TWO_CUBE) return new OppositeSideScaleRoute(true);
				else return new OppositeSideScaleRoute(true);
			case "RL":
                if(TWO_CUBE) return new SameScaleOppositeSwitchRoute(true);
                else return new SameSideScaleRoute(true);
			case "RR":
				if(TWO_CUBE) return new OppositeScaleOppositeSwitchRoute(true);
				else return new OppositeSideScaleRoute(true);
			default:
				System.out.println("Invalid fmsData " + fmsData + " was cropped to " + fmsCroppedConfiguration);	
				return null;
			}
        } else if(autoChooserOption == AutoChooserOption.SCALE_RIGHT) {
			switch(fmsCroppedConfiguration) {
			case "LL":
				if(TWO_CUBE) return new OppositeScaleOppositeSwitchRoute(false);
				else return new OppositeSideScaleRoute(false);
			case "LR":
                if(TWO_CUBE) return new SameScaleOppositeSwitchRoute(false);
                else return new SameSideScaleRoute(false);
			case "RL":
				if(TWO_CUBE) return new OppositeSideScaleRoute(false);
				else return new OppositeSideScaleRoute(false);
			case "RR":
                if(TWO_CUBE) return new SameScaleSameSwitchRoute(false);
                else return new SameSideScaleRoute(false);
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
		DRIVE_STRAIGHT,
		SOLO_LEFT,
		SOLO_RIGHT,
		CO_OP_LEFT,
		CO_OP_RIGHT,
		SCALE_LEFT,
		SCALE_RIGHT,
		DRIVE_STRAIGHT_WITH_COMPETENT_TEAMMATE
	}
}

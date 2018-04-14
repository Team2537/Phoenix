package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.auto.routes.AutoRoute;
import org.usfirst.frc.team2537.robot.auto.routes.DriveStraightRoute;
import org.usfirst.frc.team2537.robot.auto.routes.StartingSide;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.OppositeSideScaleRoute;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.OppositeSideSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.SameSideScaleRoute;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.SameSideSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.OppositeScaleOppositeScaleRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.OppositeScaleOppositeSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.OppositeScaleSecondCubeRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.OppositeSwitchOppositeSwitch;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.OppositeSwitchSecondCubeRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.SameScaleSameScaleRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.SameScaleSameSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.SameScaleSecondCubeRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.SameSwitchSameSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.routes.twocube.SameSwitchSecondCubeRoute;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoChooser {

	private SendableChooser<StartingSide> startingSide;
	private SendableChooser<AutoRoute> sameSwitch_sameScale, sameSwitch_oppScale, oppSwitch_sameScale,
			oppSwitch_oppScale;

	@SuppressWarnings("unchecked")
	public AutoChooser() {
		startingSide = new SendableChooser<>();
		startingSide.setName("Robot Starting Side");
		startingSide.addDefault("Left", StartingSide.LEFT);
		startingSide.addObject("Right", StartingSide.RIGHT);
		SmartDashboard.putData("Robot Starting Side", startingSide);

		sameSwitch_sameScale = new SendableChooser<>();
		sameSwitch_oppScale = new SendableChooser<>();
		oppSwitch_sameScale = new SendableChooser<>();
		oppSwitch_oppScale = new SendableChooser<>();
		
		
		/** AutoChooser options **/
		
		/* same switch same scale */
		SendableChooser currentChooser = sameSwitch_sameScale;
		addOption("Same Switch :: Same Scale", null, currentChooser);
		addOption("Switch", new SameSideSwitchRoute(), currentChooser);
		addOption("Scale", new SameSideScaleRoute(), currentChooser);
		addOption("Switch + Grab Cube", new SameSwitchSecondCubeRoute(), currentChooser);
		addOption("Switch + Switch", new SameSwitchSameSwitchRoute(), currentChooser);
		addOption("Scale + Switch (risky)", new SameScaleSameSwitchRoute(), currentChooser);
		addOption("Scale + Grab Cube", new SameScaleSecondCubeRoute(), currentChooser);
		addOption("Scale + Scale", new SameScaleSameScaleRoute(), currentChooser);
		addOptionDefault("Drive Straight", new DriveStraightRoute(), currentChooser);
		
		/* same switch opposite scale */
		currentChooser = sameSwitch_oppScale;
		addOption("Same Switch :: Opp. Scale", null, currentChooser);
		addOption("Switch", new SameSideSwitchRoute(), currentChooser);
		addOption("Scale", new OppositeSideScaleRoute(), currentChooser);
		addOption("Scale + Grab Cube", new OppositeScaleSecondCubeRoute(), currentChooser);
		addOption("Switch + Grab Cube", new SameSwitchSecondCubeRoute(), currentChooser);
		addOption("Switch + Switch", new SameSwitchSameSwitchRoute(), currentChooser);
		addOption("Scale + Scale", new OppositeScaleOppositeScaleRoute(), currentChooser);
		addOptionDefault("Drive Straight", new DriveStraightRoute(), currentChooser);
		
		/* opposite switch same scale */
		currentChooser = oppSwitch_sameScale;
		addOption("Opp. Switch :: Same Scale", null, currentChooser);
		addOption("Switch", new OppositeSideSwitchRoute(), currentChooser);
		addOption("Scale", new SameSideScaleRoute(), currentChooser);
		addOption("Switch + Grab Cube", new OppositeSwitchSecondCubeRoute(), currentChooser);
		addOption("Switch + Switch", new OppositeSwitchOppositeSwitch(), currentChooser);
		addOption("Scale + Grab Cube", new SameScaleSecondCubeRoute(), currentChooser);
		addOption("Scale + Scale", new SameScaleSameScaleRoute(), currentChooser);
		addOptionDefault("Drive Straight", new DriveStraightRoute(), currentChooser);
		
		/* opposite switch opposite scale */
		currentChooser = oppSwitch_oppScale;
		addOption("Opp. Switch :: Opp. Scale", null, currentChooser);
		addOption("Switch", new OppositeSideSwitchRoute(), currentChooser);
		addOption("Scale", new OppositeSideScaleRoute(), currentChooser);
		addOption("Switch + Grab Cube", new OppositeSwitchSecondCubeRoute(), currentChooser);
		addOption("Switch + Switch", new OppositeSwitchOppositeSwitch(), currentChooser);
		addOption("Scale + Grab Cube", new OppositeScaleSecondCubeRoute(), currentChooser);
		addOption("Scale + Switch", new OppositeScaleOppositeSwitchRoute(), currentChooser);
		addOption("Scale + Scale", new OppositeScaleOppositeScaleRoute(), currentChooser);
		addOptionDefault("Drive Straight", new DriveStraightRoute(), currentChooser);
		
		/** ------------------- **/
		
		
		SmartDashboard.putData("Same Switch :: Same Scale", sameSwitch_sameScale);
		SmartDashboard.putData("Same Switch :: Opp. Scale", sameSwitch_oppScale);
		SmartDashboard.putData("Opp. Switch :: Same Scale", oppSwitch_sameScale);
		SmartDashboard.putData("Opp. Switch :: Opp. Scale", oppSwitch_oppScale);
		
		
	}

	public Command getRoute(String fmsData) {
		StartingSide side = startingSide.getSelected();
		char sideChar = side == StartingSide.LEFT ? 'L' : 'R';
		boolean sameSwitch = fmsData.charAt(0) == sideChar;
		boolean sameScale = fmsData.charAt(1) == sideChar;
		SendableChooser<AutoRoute> scenario;

		if (sameSwitch) {
			if (sameScale) {
				scenario = sameSwitch_sameScale;
			} else {
				scenario = sameSwitch_oppScale;
			}
		} else {
			if (sameScale) {
				scenario = oppSwitch_sameScale;
			} else {
				scenario = oppSwitch_oppScale;
			}
		}
		
		AutoRoute chosenRoute = scenario.getSelected().setStartingSide(side);
		System.out.println("AUTOCHOOSER PRINT");
		System.out.println("  Start side: "+sideChar);
		System.out.println("    FMS data: "+fmsData);
		System.out.println("    Scenario: "+(sameSwitch?"Same":"Opp.")+" Switch, "+(sameScale?"Same":"Opp.")+" Scale");
		System.out.println("Chosen route: "+chosenRoute.getClass().getSimpleName());
		
		return chosenRoute;
	}

	@SuppressWarnings("unchecked")
	private void addOption(String name, AutoRoute route, SendableChooser<AutoRoute>... scenarios) {
		for (SendableChooser<AutoRoute> scenario : scenarios) {
			scenario.addObject(name, route);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void addOptionDefault(String name, AutoRoute route, SendableChooser<AutoRoute>... scenarios) {
		for (SendableChooser<AutoRoute> scenario : scenarios) {
			scenario.addDefault(name, route);
		}
	}

}

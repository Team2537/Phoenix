package org.usfirst.frc.team2537.robot.auto;

import org.usfirst.frc.team2537.robot.auto.routes.AutoRoute;
import org.usfirst.frc.team2537.robot.auto.routes.DriveStraightRoute;
import org.usfirst.frc.team2537.robot.auto.routes.StartingSide;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.OppositeSideScaleRoute;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.OppositeSideSwitchRoute;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.SameSideScaleRoute;
import org.usfirst.frc.team2537.robot.auto.routes.onecube.SameSideSwitchRoute;

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
		startingSide.addDefault("Left", StartingSide.LEFT);
		startingSide.addObject("Right", StartingSide.RIGHT);
		SmartDashboard.putData("Robot Starting Side", startingSide);

		sameSwitch_sameScale = new SendableChooser<>();
		sameSwitch_oppScale = new SendableChooser<>();
		oppSwitch_sameScale = new SendableChooser<>();
		oppSwitch_oppScale = new SendableChooser<>();
		
		
		/** AutoChooser options **/
		
		addOption("Switch", new SameSideSwitchRoute(), sameSwitch_sameScale, sameSwitch_oppScale);
		addOption("Switch", new OppositeSideSwitchRoute(), oppSwitch_sameScale, oppSwitch_oppScale);
		//addOption("Switch (close)", new OppositeSideCloseSwitchRoute(), oppSwitch_sameScale, oppSwitch_oppScale);

		addOption("Scale", new SameSideScaleRoute(), sameSwitch_sameScale, oppSwitch_sameScale);
		addOption("Scale", new OppositeSideScaleRoute(), sameSwitch_oppScale, oppSwitch_oppScale);
		
		addOption("DriveStraight", new DriveStraightRoute(), sameSwitch_sameScale, sameSwitch_oppScale, oppSwitch_sameScale, oppSwitch_oppScale);
		
		/** ------------------- **/
		
		
		SmartDashboard.putData(sameSwitch_sameScale);
		SmartDashboard.putData(sameSwitch_oppScale);
		SmartDashboard.putData(oppSwitch_sameScale);
		SmartDashboard.putData(oppSwitch_oppScale);
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

		return scenario.getSelected().setStartingSide(side);
	}

	@SuppressWarnings("unchecked")
	private void addOption(String name, AutoRoute route, SendableChooser<AutoRoute>... scenarios) {
		for (SendableChooser<AutoRoute> scenario : scenarios) {
			scenario.addObject(name, route);
		}
	}

}

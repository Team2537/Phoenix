package org.usfirst.frc.team2537.robot.auto.vision;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionTestCommand extends Command {

	@Override
	protected void execute(){
		Target[] targets = Robot.visionSerial.getVisionPacket();
		
		String targetsString = "";
		for(Target target : targets){
			Point[] bb = target.getBoundingBox();
			targetsString += bb[0].x+","+bb[0].y+"|"+bb[1].x+","+bb[1].y+" ";
		}
		SmartDashboard.putString("targets", targetsString);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}

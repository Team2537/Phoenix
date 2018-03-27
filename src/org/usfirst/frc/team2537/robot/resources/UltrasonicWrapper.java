package org.usfirst.frc.team2537.robot.resources;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;

public class UltrasonicWrapper extends Ultrasonic {

	private DigitalOutput trigger;
	private boolean triggerState;
	
	public UltrasonicWrapper(int triggerChannel, int echoChannel, int dummyChannel) {
		super(dummyChannel, echoChannel);
		trigger = new DigitalOutput(triggerChannel);
		triggerState = false;
		
		new Command(){
			@Override
			protected void execute() {
				update();
			}
			@Override
			protected boolean isFinished() {
				return false;
			}
		}.start();
	}
	
	public void update(){
		triggerState = !triggerState;
		trigger.set(triggerState);
	}

}

package org.usfirst.frc.team2537.robot.auto;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI.Port;

public class Navx extends AHRS {
	
	private static Navx singleton;
	
	public static Navx getInstance(){
		if(singleton == null){
			singleton = new Navx(Port.kMXP);
		}
		return singleton;
	}
	
	private Navx(Port port){
		super(port);
	}
	
	/**
	 * @return direction of robot from [-180,180], increasing clockwise, with 0 as positive y
	 */
	@Override
	public double getAngle(){
		return ((super.getAngle() + 180) % 360 + 360) % 360 - 180;
	}
	
	/**
	 * @return direction of robot from [0,2PI], increasing counter-clockwise, with 0 as positive x
	 */
	public double getRadians(){
		return (360 - ((super.getAngle() + 270) % 360)) * Math.PI / 180;
	}
}
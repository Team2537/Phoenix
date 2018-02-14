package org.usfirst.frc.team2537.robot.cameras;

import org.opencv.core.Mat;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class Cameras extends Thread {
	protected CvSink cvSink;
	private UsbCamera cam0;
	private UsbCamera cam1;
	private int camNum;
	private CvSource outputStream;
	private Mat source;
	private Mat output;
	
	public Cameras() {
		camNum = 0;
		cam0 = new UsbCamera("cam0", 0);
		cam0.setResolution(320, 240);
		CameraServer.getInstance().addCamera(cam0);
		source = new Mat();
		output = new Mat();
		cvSink = CameraServer.getInstance().getVideo(cam0);
		outputStream = CameraServer.getInstance().putVideo("cams", 320, 240);
		
	}
	
	public void run() {
		while (true) {	
		cvSink.grabFrame(source);
		output = source;
		
		}
	}
	
	

}

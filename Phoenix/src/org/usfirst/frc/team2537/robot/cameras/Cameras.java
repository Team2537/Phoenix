package org.usfirst.frc.team2537.robot.cameras;

import org.opencv.core.Mat;
import org.usfirst.frc.team2537.robot.Ports;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class Cameras extends Thread {
	
	private CvSink cvSink;
	private UsbCamera cam0;
	private CvSource outputStream;
	private Mat source;
	
	public Cameras() {
		source = new Mat();
		
		cam0 = new UsbCamera("cam0", Ports.CAMERA_PORT);
		cam0.setResolution(320, 240);
		cam0.setFPS(12);
		CameraServer.getInstance().addCamera(cam0);
		cvSink = CameraServer.getInstance().getVideo(cam0);
		outputStream = CameraServer.getInstance().putVideo("cams", 640, 480);
	}
	
	
	@Override
	public void run() {
		while (true) {
			
			cvSink.grabFrame(source);
			outputStream.putFrame(source);
		}
	}
	
}

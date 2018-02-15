package org.usfirst.frc.team2537.robot.cameras;

import org.opencv.core.Mat;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class Cameras extends Thread {
	
	private CvSink cvSink;
	private UsbCamera cam0;
	private UsbCamera cam1;
	private int camNum;
	private CvSource outputStream;
	private Mat source;
	private Mat output;
	
	public Cameras() {
		camNum = 0;
		source = new Mat();
		output = new Mat();
		
		cam0 = new UsbCamera("cam0", 0);
		cam0.setResolution(320, 240);
		CameraServer.getInstance().addCamera(cam0);
		cvSink = CameraServer.getInstance().getVideo(cam0);
		outputStream = CameraServer.getInstance().putVideo("cams", 320, 240);
	}
	
	public void switchCameras() {
		if (camNum == 0) {
			CameraServer.getInstance().removeCamera("cam0");
			cam0.free();
			
			cam1 = new UsbCamera("cam1", 1);
			cam1.setResolution(320, 240);
			
			CameraServer.getInstance().addCamera(cam1);
			cvSink.setSource(cam1);
			camNum = 1;
		} else {
			CameraServer.getInstance().removeCamera("cam1");
			cam1.free();
			
			cam0 = new UsbCamera("cam0", 0);
			cam0.setResolution(320, 240);
			
			CameraServer.getInstance().addCamera(cam0);
			cvSink.setSource(cam0);
			camNum = 0;
		}
	}
	
	@Override
	public void run() {
		while (true) {
			if (HumanInput.cameraSwitchButton.get())
				switchCameras();
			
			cvSink.grabFrame(source);
			
			if (source.rows() != 240 || source.cols() != 320)
				continue;
			output = source;
			
			outputStream.putFrame(output);
		}
	}
	
}

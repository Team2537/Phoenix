package org.usfirst.frc.team2537.robot.input;

import org.opencv.core.Mat;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class Cameras extends Thread {

	private CvSink cvSink;
	private UsbCamera cam0;
	private CvSource outputStream;
	private Mat source;
	private Mat output;
	
	/**
	 * Creates the default camera (cam0) and the cvSink
	 */
	public Cameras() {
		// Define Variables
		source = new Mat();
		output = new Mat();
	}

	@Override
	public void run() {
		cam0 = new UsbCamera("cam0", 0);
		cam0.setFPS(30);
		cam0.setResolution(320, 240);
		CameraServer.getInstance().addCamera(cam0);
		cvSink = CameraServer.getInstance().getVideo(cam0);
		outputStream = CameraServer.getInstance().putVideo("cams", 320, 240);
		
		
		while(true) {
			
			
			
			// Get frame from cvSink
			cvSink.grabFrame(source);
			if (source.rows() != 240 || source.cols() != 320) {
				continue;
			}
			output = source;
			outputStream.putFrame(output);
		}
	}

}

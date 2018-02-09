package org.usfirst.frc.team2537.robot.cameras;

import org.opencv.core.Mat;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class Cameras extends Thread {
	private CvSink cam0Vid, cam1Vid;
	private UsbCamera cam0, cam1;
	private Mat cam0Mat, cam1Mat;
	private long Mat0, Mat1;
	private CvSource outputStream0, outputStream1;
	private static final String RESW = "320", RESH = "240";
	private static final int FPS = 0;


	


	public Cameras() {
		
		
		cam0Mat = new Mat();
		cam1Mat = new Mat();
		

		Mat0 = cam0Mat.getNativeObjAddr();
		Mat1 = cam1Mat.getNativeObjAddr();
		
		
		cam0Mat = new Mat(Mat0);
		cam1Mat = new Mat(Mat1);



		cam0 = new UsbCamera("Camera0", 0);
		cam0.setResolution(Integer.parseInt(RESW), Integer.parseInt(RESH));
		cam0.setFPS(FPS);
		
		cam1 = new UsbCamera("Camera1", 1);
		cam1.setResolution(Integer.parseInt(RESW), Integer.parseInt(RESH));
		cam1.setFPS(FPS);
		


		CameraServer.getInstance().addCamera(cam0);
		CameraServer.getInstance().addCamera(cam1);

		cam0Vid = CameraServer.getInstance().getVideo(cam0);
		cam1Vid = CameraServer.getInstance().getVideo(cam1);

		outputStream0 = CameraServer.getInstance().putVideo("Camera0", Integer.parseInt(RESW), Integer.parseInt(RESH));
		outputStream1 = CameraServer.getInstance().putVideo("Camera1", Integer.parseInt(RESW), Integer.parseInt(RESH));
		


	}
	
	
		
	

	public void run() {
		while(true) {
	
				cam0Vid.grabFrame(cam0Mat);	
				outputStream0.putFrame(cam0Mat);
				
				cam1Vid.grabFrame(cam1Mat);
				outputStream1.putFrame(cam1Mat);
				
			
				
		
		 
		}
		
		
	}

}


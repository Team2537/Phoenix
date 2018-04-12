package org.usfirst.frc.team2537.robot.cameras; //PHOENIX

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.RotatedRect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team2537.robot.input.HumanInput;

import com.sun.glass.ui.Size;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class Cameras extends Thread {
	protected CvSink cvSink;
	private UsbCamera cam0;
	private UsbCamera cam1;
	private int camNum;
	private int width = 320;
	private int length = 240;
	private CvSource outputStream;
	private Mat source;
	private Mat output;
	private boolean switched;
	private long lastSwitched;

	public Cameras() {
		// define variables
		camNum = 0;
		lastSwitched = 0;
		source = new Mat();
		
		output = new Mat();

		// setup default camera
		cam0 = new UsbCamera("cam0", 0);
		cam0.setResolution(320, 240);
		CameraServer.getInstance().addCamera(cam0);
		cvSink = CameraServer.getInstance().getVideo(cam0);
		outputStream = CameraServer.getInstance().putVideo("cams", 320, 240);

	}

	public void run() {
		while (true) {
			// Get frame from cvSink
			cvSink.grabFrame(source);

			if (source.rows() != 240 || source.cols() != 320) {
				continue;
			}
			output = source;

			cvSink.grabFrame(source);
			output = source;
			// objective: get frames moving, attempt a cross at middle,
			// maybe also some text on both axis; also switch cameras

			// draws "CUBE" in the top right corner
			Imgproc.putText(source, "CUBE", new Point(output.cols() - 75, 25), 4, 0.8, new Scalar(0, 0, 0), 3);
			Imgproc.putText(source, "CUBE", new Point(output.cols() - 75, 25), 4, 0.8, new Scalar(55, 250, 37), 1);

			// draws a vertical and horizontal line through the center of the image
			Imgproc.line(source, new Point(output.cols() / 4, 0), new Point(output.cols() / 4, output.rows()),
					new Scalar(55, 250, 37), 1);
			
			Imgproc.line(source, new Point(output.cols() / 4, 0), new Point(output.cols() / 4, output.rows()),
					new Scalar(55, 250, 37), 1);

			Imgproc.line(source, new Point(0, output.rows() / 2), new Point(output.cols(), output.rows() / 2),
					new Scalar(55, 250, 37), 1);
			 Imgproc.CV_SHAPE_ELLIPSE(source, new Point(width/2, length/ 2),
						new Scalar(55, 250, 37), 1);
			      
			// send frame to output stream
			outputStream.putFrame(output);

		}
	}

}

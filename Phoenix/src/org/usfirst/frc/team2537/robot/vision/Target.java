package org.usfirst.frc.team2537.robot.vision;

public class Target {
	private Point[] points;
	private Point[] boundingBox;

	public Target(Point[] points) {
		this.points = points;
	}

	public Point[] getPoints() {
		return points;
	}

	public Point[] getBoundingBox() {
		// must be run with at least 4 points in the target for no duplicates to occur
		// bottom left and top right
		if(boundingBox == null){
			boundingBox = new Point[2];
			int leftX = Integer.MAX_VALUE;
			int rightX = Integer.MIN_VALUE;
			int upY = Integer.MIN_VALUE;
			int downY = Integer.MAX_VALUE;
			for (int i = 0; i < points.length; i++) {
				if (points[i].getX() < leftX) {
					leftX = points[i].getX();
				}
				if (points[i].getX() > rightX) {
					rightX = points[i].getX();
				}
				if (points[i].getY() > upY) {
					upY = points[i].getY();
				}
				if (points[i].getY() < downY) {
					downY = points[i].getY();
				}
			}
			boundingBox[0] = new Point(leftX, upY); 
			boundingBox[1] = new Point(rightX, downY);
		}
		return boundingBox;
	}
}

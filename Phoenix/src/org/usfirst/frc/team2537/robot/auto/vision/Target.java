package org.usfirst.frc.team2537.robot.auto.vision;

public class Target {
	private Point[] points;
	private Point[] boundingBox;
	private Point boundingBoxCenter;
	private double boundingBoxArea;

	public Target(Point[] points) {
		this.points = points;
		this.boundingBoxArea = 0;
	}
	
	public Target(){
		this(new Point[0]);
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
	
	public double getBoundingBoxLength(){
		if(boundingBox == null){
			getBoundingBox();
		}
		return boundingBox[1].getX() - boundingBox[0].getX();
	}
	
	public double getBoundingBoxHeight(){
		if(boundingBox == null){
			getBoundingBox();
		}
		return boundingBox[1].getY() - boundingBox[0].getY();
	}
	
	public double getBoundingBoxArea(){
		if(boundingBoxArea == 0){
			boundingBoxArea = Math.abs(getBoundingBoxLength()*getBoundingBoxHeight());
		}
		return boundingBoxArea;
	}
	
	public Point getBoundingBoxCenter(){
		if(boundingBoxCenter == null){
			boundingBoxCenter = new Point((int)(getBoundingBoxLength()/2), (int)(getBoundingBoxHeight()/2));
		}
		return boundingBoxCenter;
	}
}

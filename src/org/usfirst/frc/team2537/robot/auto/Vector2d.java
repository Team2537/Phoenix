package org.usfirst.frc.team2537.robot.auto;

public class Vector2d {
	public final double x, y;
	public Vector2d(double x, double y){
		this.x = x;
		this.y = y;
	}
	public double length(){
		return Math.hypot(x, y);
	}
	public double slope(){
		return y/x;
	}
	public static Vector2d add(Vector2d vector0, Vector2d vector1){
		return new Vector2d(vector0.x+vector1.x, vector0.y+vector1.y);
	}
	public static Vector2d scale(Vector2d vector, double scalar){
		return new Vector2d(vector.x*scalar, vector.y*scalar);
	}
	public static Vector2d flip(Vector2d vector){
		return scale(vector,-1);
	}
	public static Vector2d normalize(Vector2d vector){
		return scale(vector,1/vector.length());
	}
	
}

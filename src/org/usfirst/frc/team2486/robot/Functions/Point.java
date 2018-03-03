package org.usfirst.frc.team2486.robot.Functions;

public class Point
{
	private double _x = 0.0;
	private double _y = 0.0;
	
	public Point(double _x, double _y)
	{
		setX(_x);
		setY(_y);
	}

	public double getX()
	{
		return _x;
	}

	public void setX(double _x) {
		this._x = _x;
	}

	public double getY() {
		return _y;
	}

	public void setY(double _y) {
		this._y = _y;
	}
	
	
}

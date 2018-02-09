package org.usfirst.frc.team2486.robot.Enums;

import org.usfirst.frc.team2486.robot.Functions.Point;

public enum Nodes
{
	RED_WALL_LEFT_SCALE(0, 0, 0, new Point(4.1629, 2.455)),
	RED_WALL_LEFT_SWITCH(0, 0, 0, new Point(4.1629, 3.2983)),
	RED_WALL_RIGHT_SWITCH(0, 0, 0, new Point(4.1629, 4.8417)),
	RED_WALL_RIGHT_SCALE(0, 0, 0, new Point(4.1629, 5.6861)),
	
	RED_SWITCH_LEFT_SWITCH(0, 0, 0, new Point(5.2337, 3.2983)),
	
    ;
	
	private int _xMap;
	private int _yMap;
	private int _zMap;
	private Point _point;

    private Nodes(int _xMap, int _yMap, int _zMap, Point _point)
    {
    	this._xMap  = _xMap;
    	this._yMap  = _yMap;
    	this._zMap  = _zMap;
    	this._point = _point;
    }
    
    public int getXMap()
    {
    	return _xMap;
    }
    
    public int getYMap()
    {
    	return _yMap;
    }
    
    public int getZMap()
    {
    	return _zMap;
    }
    
    public Point getPoint()
    {
    	return _point;
    }
}

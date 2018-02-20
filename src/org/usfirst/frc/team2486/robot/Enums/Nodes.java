package org.usfirst.frc.team2486.robot.Enums;

import org.usfirst.frc.team2486.robot.Functions.Point;

public enum Nodes
{
	// Red Nodes
	RED_WALL_LEFT_SCALE     (0, 0, 0, new Point(4.1629, 2.455)),
	RED_SWITCH_LEFT_SCALE   (0, 0, 0, new Point(6.1533, 2.455)),
	RED_AISLE_LEFT_SCALE    (0, 0, 0, new Point(7.1489, 2.455)),
	RED_SCALE_LEFT_SCALE    (0, 0, 0, new Point(7.8388, 2.6471)),

	RED_WALL_LEFT_SWITCH    (0, 0, 0, new Point(4.1629, 3.2983)),
	RED_SWITCH_LEFT_SWITCH  (0, 0, 0, new Point(5.5656, 3.2983)),
	
	RED_WALL_RIGHT_SWITCH   (0, 0, 0, new Point(4.1629, 4.8417)),
	RED_SWITCH_RIGHT_SWITCH (0, 0, 0, new Point(5.2337, 4.8467)),
	
	RED_WALL_RIGHT_SCALE    (0, 0, 0, new Point(4.1629, 5.6861)),
	RED_SWITCH_RIGHT_SCALE  (0, 0, 0, new Point(6.1533, 5.6861)),
	RED_AISLE_RIGHT_SCALE   (0, 0, 0, new Point(7.1489, 5.6861)),
	RED_SCALE_RIGHT_SCALE   (0, 0, 0, new Point(7.8388, 5.4929)),
	
	// Blue Nodes
	BLUE_WALL_LEFT_SCALE     (0, 0, 0, new Point(12.6005, 5.685)),
	BLUE_SWITCH_LEFT_SCALE   (0, 0, 0, new Point(10.6101, 5.685)),
	BLUE_AISLE_LEFT_SCALE    (0, 0, 0, new Point(9.6145, 5.685)),
	BLUE_SCALE_LEFT_SCALE    (0, 0, 0, new Point(7.8388, 2.6471)),

	BLUE_WALL_LEFT_SWITCH    (0, 0, 0, new Point(4.1629, 3.2983)),
	BLUE_SWITCH_LEFT_SWITCH  (0, 0, 0, new Point(5.5656, 3.2983)),
	
	BLUE_WALL_RIGHT_SWITCH   (0, 0, 0, new Point(4.1629, 4.8417)),
	BLUE_SWITCH_RIGHT_SWITCH (0, 0, 0, new Point(5.2337, 4.8467)),
	
	BLUE_WALL_RIGHT_SCALE    (0, 0, 0, new Point(4.1629, 5.6861)),
	BLUE_SWITCH_RIGHT_SCALE  (0, 0, 0, new Point(6.1533, 5.6861)),
	BLUE_AISLE_RIGHT_SCALE   (0, 0, 0, new Point(7.1489, 5.6861)),
	BLUE_SCALE_RIGHT_SCALE   (0, 0, 0, new Point(7.8388, 5.4929)),
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
    
    public static double getScaleFactor()
    {
    	return 70;
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
    
    public static double getDifferenceX(Nodes node1, Nodes node2)
    {
		return (double)((node1.getPoint().getX() - node2.getPoint().getX()) * Nodes.getScaleFactor());
    }
}

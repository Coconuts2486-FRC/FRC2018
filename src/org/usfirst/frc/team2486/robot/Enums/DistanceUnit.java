package org.usfirst.frc.team2486.robot.Enums;

import java.util.HashMap;
import java.util.Map;

public enum DistanceUnit
{
	/**
	 *  Centimeters.
	 *  Conversion rate to rotations: 
	 */
	CENTIMETERS(0),
	METERS(0),
	
	INCHES(0),
	FEET(0),
	
	ROTATIONS(1)
	;
	
	private final int value;
	private static Map<Object, Object> map = new HashMap<>();
	
	private DistanceUnit(int value)
	{
		this.value = value;
	}
	
	static
	{
		for(DistanceUnit id : DistanceUnit.values())
		{
			map.put(id.value, id);
		}
	}
	
	public static DistanceUnit valueOf(int id)
	{
		return (DistanceUnit) map.get(id);
	}
	
	public int getValue()
	{
		return value;
	}
}

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
	
	INCHES(226.14840989399293286219081272085),
	FEET(0),
	
	TICKS(1),
	//COMPETITION BOT ROTATIONS(30600),
	ROTATIONS(30600),
	;
	
	private final double value;
	private static Map<Object, Object> map = new HashMap<>();
	
	private DistanceUnit(double value)
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
	
	public double getValue()
	{
		return value;
	}
}

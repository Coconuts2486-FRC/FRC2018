package org.usfirst.frc.team2486.robot.Enums;

import java.util.HashMap;
import java.util.Map;

public enum AngleUnit
{
	/**
	 *  Radians.
	 *  Conversion factor to degrees: 180/Math.PI
	 */
	RADIANS(180 / Math.PI),
	/**
	 *  Degrees.
	 *  The base unit for all other angle enums.
	 *  Conversion factor to degrees: 1
	 */
	DEGREES(1),
	/**
	 *  Gradians.
	 *  Currently unimplemented.
	 *  Conversion factor to degrees: 0
	 */
	GRADIANS(0)
	;
	
	private final double value;
	private static Map<Object, Object> map = new HashMap<>();
	
	private AngleUnit(double value)
	{
		this.value = value;
	}
	
	static
	{
		for(AngleUnit id : AngleUnit.values())
		{
			map.put(id.value, id);
		}
	}
	
	public static AngleUnit valueOf(int id)
	{
		return (AngleUnit) map.get(id);
	}
	
	public double getValue()
	{
		return value;
	}
}

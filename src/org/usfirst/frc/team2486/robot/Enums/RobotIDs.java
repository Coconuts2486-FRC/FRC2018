package org.usfirst.frc.team2486.robot.Enums;

import java.util.HashMap;
import java.util.Map;

public enum RobotIDs {
	PRIMARYLEFT(0),
	PRIMARYRIGHT(1),
	SECONDARYOPERATOR(2),
	
	LEFT(1),
	RIGHT(3),
	LEFTSLAVE(2),
	RIGHTSLAVE(4),
	
	HEADACTUATOR(11),
	HEADINTAKE(12),
	HEADINTAKESLAVE(13),
	
	PCM(21),
	SHIFTERS(0),
	ARMPRIMARY(2),
	ARMSECONDARY(3)
	;
	
	private final int value;
	private static Map<Object, Object> map = new HashMap<>();
	
	private RobotIDs(int value)
	{
		this.value = value;
	}
	
	static
	{
		for(RobotIDs id : RobotIDs.values())
		{
			map.put(id.value, id);
		}
	}
	
	public static RobotIDs valueOf(int id)
	{
		return (RobotIDs) map.get(id);
	}
	
	public int getValue()
	{
		return value;
	}
}

package org.usfirst.frc.team2486.robot.Enums;

import java.util.HashMap;
import java.util.Map;

public enum RobotIDs {
	PRIMARYLEFT(0),
	PRIMARYRIGHT(1),
	SECONDARYOPERATOR(2),
	
	LEFT(2), //
	RIGHT(1), //
	LEFTSLAVE(8), //
	RIGHTSLAVE(7), 
	
	CLIMBER(9), //
	CLIMBERSLAVE(3),
	
	HEADACTUATOR(6),
	HEADACTUATORSLAVE(10),
	HEADINTAKE(5), //
	HEADINTAKESLAVE(4),
	
	PCM(21),
	
	SHIFTERS(7),
	HEADPISTON(6),
	ARMPRIMARY(5),
	ARMSECONDARY(4),
	ARMTERTIARY(0),
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

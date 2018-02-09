package org.usfirst.frc.team2486.robot.Enums;

import java.util.HashMap;
import java.util.Map;

public enum ArmStates
{
	LOW_FAST (0),
	LOW (1),
	MEDIUM (2),
	HIGH (3)
	;
	
	private final int value;
	private static Map<Object, Object> map = new HashMap<>();
	
	private ArmStates(int value)
	{
		this.value = value;
	}
	
	static
	{
		for(ArmStates armState : ArmStates.values())
		{
			map.put(armState.value, armState);
		}
	}
	
	public static ArmStates valueOf(int armState)
	{
		return (ArmStates) map.get(armState);
	}
	
	public int getValue()
	{
		return value;
	}
}

package org.usfirst.frc.team2486.robot.Enums;

import java.util.HashMap;
import java.util.Map;

public enum AutoModes
{
	DISABLED(0),
	
	LEFT_SCALE(101),
	LEFT_SWITCH(111),
	RIGHT_SCALE(100),
	RIGHT_SWITCH(110)
	;
	
	private final byte value;
	private static Map<Object, Object> map = new HashMap<>();
	
	private AutoModes(int value)
	{
		this.value = (byte) value;
	}
	
	static
	{
		for(AutoModes autoMode : AutoModes.values())
		{
			map.put(autoMode.value, autoMode);
		}
	}
	
	public static AutoModes valueOf(int autoMode)
	{
		return (AutoModes) map.get(autoMode);
	}
	
	public int getValue()
	{
		return value;
	}
}

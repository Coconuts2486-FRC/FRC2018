package org.usfirst.frc.team2486.robot.Enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Place the integer equivalent of the controller buttons here.
 */
public enum ControlButton {
	SHIFTERS(1),
	HEADIN(2),
	HEADOUT(3),
	ARMFORWARD(6),
	ARMOFF(5),
	ARMREVERSE(4),
	CLIMB(7),
	CLIMBOPPOSITE(3)
	;
	
	private final int value;
	private static Map<Object, Object> map = new HashMap<>();
	
	private ControlButton(int value)
	{
		this.value = value;
	}
	
	static
	{
		for(ControlButton controlButton : ControlButton.values())
		{
			map.put(controlButton.value, controlButton);
		}
	}
	
	public static ControlButton valueOf(int controlButton)
	{
		return (ControlButton) map.get(controlButton);
	}
	
	public int getValue()
	{
		return value;
	}
}

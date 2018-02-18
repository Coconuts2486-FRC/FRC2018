package org.usfirst.frc.team2486.robot.Auto.Red;

import org.usfirst.frc.team2486.robot.Functions.TurnToAngle;
import org.usfirst.frc.team2486.robot.Interfaces.AutoMode;

public class RedLeftScale extends AutoMode
{
	public RedLeftScale()
	{
		super();
		CommandList.add(new TurnToAngle(90));
	}
}
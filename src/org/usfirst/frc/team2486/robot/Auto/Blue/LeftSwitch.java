package org.usfirst.frc.team2486.robot.Auto.Blue;

import org.usfirst.frc.team2486.robot.Functions.DriveToDistance;
import org.usfirst.frc.team2486.robot.Functions.TurnToAngle;
import org.usfirst.frc.team2486.robot.Interfaces.AutoMode;

public class LeftSwitch extends AutoMode
{
	public LeftSwitch()
	{
		super();
		CommandList.add(new DriveToDistance(10));
		CommandList.add(new TurnToAngle(90));
	}
}

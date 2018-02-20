package org.usfirst.frc.team2486.robot.Auto.Red;

import org.usfirst.frc.team2486.robot.Enums.DistanceUnit;
import org.usfirst.frc.team2486.robot.Enums.Nodes;
import org.usfirst.frc.team2486.robot.Functions.CubeIntake;
import org.usfirst.frc.team2486.robot.Functions.DriveToDistance;
import org.usfirst.frc.team2486.robot.Interfaces.AutoMode;

public class RedRightSwitch extends AutoMode
{
	public RedRightSwitch()
	{
		super();
		
		// Drive forward to the switch.
		CommandList.add(new DriveToDistance(Nodes.getDifferenceX(Nodes.RED_SWITCH_RIGHT_SWITCH, Nodes.RED_WALL_RIGHT_SWITCH), DistanceUnit.INCHES));
		
		// Determine the color of the switch.
		if(Plates.getRaw().charAt(0) == 'R')
		{
			//Place block since we own the switch
			CommandList.add(new CubeIntake(true));
		}
	}
}

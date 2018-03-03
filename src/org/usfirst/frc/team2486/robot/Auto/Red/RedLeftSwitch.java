package org.usfirst.frc.team2486.robot.Auto.Red;

import org.usfirst.frc.team2486.robot.RobotMap;
import org.usfirst.frc.team2486.robot.Enums.DistanceUnit;
import org.usfirst.frc.team2486.robot.Enums.Nodes;
import org.usfirst.frc.team2486.robot.Functions.DriveToDistance;
import org.usfirst.frc.team2486.robot.Interfaces.AutoMode;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class RedLeftSwitch extends AutoMode
{
	public RedLeftSwitch()
	{
		super();
		
		// Drive forward to the switch.
		CommandList.add(new DriveToDistance(Nodes.getDifferenceX(Nodes.RED_SWITCH_LEFT_SWITCH, Nodes.RED_WALL_LEFT_SWITCH), DistanceUnit.INCHES));
		
		// Determine the color of the switch.
		if(Plates.getRaw().charAt(0) == 'L')
		{
			//Place block since we own the switch
			//CommandList.add(new CubeIntake(true));
		}
	}
}

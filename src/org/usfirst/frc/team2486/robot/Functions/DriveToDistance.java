package org.usfirst.frc.team2486.robot.Functions;

import org.usfirst.frc.team2486.robot.Interfaces.IAutoCommand;

public class DriveToDistance implements IAutoCommand
{
	private double _distance;
	public DriveToDistance(double distance)
	{
		_distance = distance;
	}
	
	@Override
	public void Run()
	{
		// TODO: Implement encoder system to run to a specific distance.
	}
}
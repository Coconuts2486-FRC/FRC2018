package org.usfirst.frc.team2486.robot.Functions;

import org.usfirst.frc.team2486.robot.Interfaces.IAutoCommand;

public class TurnToAngle implements IAutoCommand
{
	private double _desiredAngle;
	public TurnToAngle(double desiredAngle)
	{
		_desiredAngle = desiredAngle;
	}
	
	@Override
	public void Run()
	{
		
	}
}
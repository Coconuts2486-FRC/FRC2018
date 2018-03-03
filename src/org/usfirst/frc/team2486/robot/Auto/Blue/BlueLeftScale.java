package org.usfirst.frc.team2486.robot.Auto.Blue;

import org.usfirst.frc.team2486.robot.Interfaces.AutoMode;

import edu.wpi.first.wpilibj.DriverStation;

public class BlueLeftScale extends AutoMode
{
	public BlueLeftScale()
	{
		super();
		DriverStation.reportError("BlueLeftScale", false);
	}
}

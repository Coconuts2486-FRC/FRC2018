package org.usfirst.frc.team2486.robot.Auto.Blue;

import org.usfirst.frc.team2486.robot.Functions.PlateAssignment;
import org.usfirst.frc.team2486.robot.Interfaces.AutoMode;

public class LeftScale implements AutoMode
{
	PlateAssignment plates;
	@Override
	public void Run()
	{
		plates = new PlateAssignment();
	}
}

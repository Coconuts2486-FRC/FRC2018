package org.usfirst.frc.team2486.robot.OpModes;

import org.usfirst.frc.team2486.robot.Interfaces.IAuto;
import org.usfirst.frc.team2486.robot.Interfaces.IOpMode;

public class Autonomous implements IOpMode {

	@Override
	public void Initialize()
	{
		IAuto mode = null;
		// TODO: put switching logic here.
		mode.Run();
	}

	@Override
	public void Loop()
	{
		
	}
}
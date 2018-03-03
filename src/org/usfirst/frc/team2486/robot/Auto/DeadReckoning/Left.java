package org.usfirst.frc.team2486.robot.Auto.DeadReckoning;

import org.usfirst.frc.team2486.robot.RobotMap;
import org.usfirst.frc.team2486.robot.Functions.CubeIntake;
import org.usfirst.frc.team2486.robot.Functions.RawSpeed;
import org.usfirst.frc.team2486.robot.Interfaces.AutoMode;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Left extends AutoMode
{
	public Left()
	{
		super();
		
		CommandList.add(new RawSpeed(0.5, 0.35, 2750));
		CommandList.add(new RawSpeed(0, 0, 250));
		if(Plates.getRaw().charAt(0) == 'L')
		{
			//Place block since we own the switch
			CommandList.add(new CubeIntake(true));
		}
	}
}

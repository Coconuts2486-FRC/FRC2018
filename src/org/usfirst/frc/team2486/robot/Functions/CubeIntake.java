package org.usfirst.frc.team2486.robot.Functions;

import org.usfirst.frc.team2486.robot.RobotMap;
import org.usfirst.frc.team2486.robot.Enums.DistanceUnit;
import org.usfirst.frc.team2486.robot.Interfaces.IAutoCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class CubeIntake implements IAutoCommand
{

	private boolean _fire;
	public CubeIntake(boolean fire)
	{
		_fire = fire;
	}
	
	@Override
	public void Run() {
		if(_fire)
		{
			RobotMap.HeadIntake.set(ControlMode.PercentOutput, 0.75);
		}
		else
		{
			RobotMap.HeadIntake.set(ControlMode.PercentOutput, -1);
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RobotMap.HeadIntake.set(ControlMode.PercentOutput, 0);
	}
}

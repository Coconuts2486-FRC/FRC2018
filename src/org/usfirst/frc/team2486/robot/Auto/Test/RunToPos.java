package org.usfirst.frc.team2486.robot.Auto.Test;

import org.usfirst.frc.team2486.robot.RobotMap;
import org.usfirst.frc.team2486.robot.Interfaces.AutoMode;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class RunToPos extends AutoMode
{
	public RunToPos()
	{
		super();
		RobotMap.Left.set(ControlMode.Position, 16000);
		RobotMap.Right.set(ControlMode.Position, 16000);
	}
}

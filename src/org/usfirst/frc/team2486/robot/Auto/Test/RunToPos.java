package org.usfirst.frc.team2486.robot.Auto.Test;

import org.usfirst.frc.team2486.robot.RobotMap;
import org.usfirst.frc.team2486.robot.Enums.DistanceUnit;
import org.usfirst.frc.team2486.robot.Functions.DriveToDistance;
import org.usfirst.frc.team2486.robot.Interfaces.AutoMode;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class RunToPos extends AutoMode
{
	public RunToPos()
	{
		super();
//		RobotMap.Left.set(ControlMode.Position, 30600);
//		RobotMap.Right.set(ControlMode.Position, 30600);
		CommandList.add(new DriveToDistance(5, DistanceUnit.ROTATIONS));
	}
}

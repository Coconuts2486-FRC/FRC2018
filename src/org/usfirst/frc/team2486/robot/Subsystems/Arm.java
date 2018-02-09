package org.usfirst.frc.team2486.robot.Subsystems;

import org.usfirst.frc.team2486.robot.RobotMap;
import org.usfirst.frc.team2486.robot.Enums.ArmStates;

public class Arm
{
	public static void armPos(ArmStates state)
	{
		switch(state)
		{
			case LOW_FAST:
				armLowFast();
				break;
			case LOW:
				armLow();
				break;
			case MEDIUM:
				armMid();
				break;
			case HIGH:
				armHigh();
				break;
			default:
				armLow();
				break;
		}
	}
	
	public static void armHigh()
	{
		RobotMap.ArmPistonPrimary.set(false);
		RobotMap.ArmPistonSecondary.set(false);
		RobotMap.ArmPistonTertiary.set(true);
	}
	public static void armMid()
	{
		RobotMap.ArmPistonPrimary.set(true);
		RobotMap.ArmPistonSecondary.set(false);
		RobotMap.ArmPistonTertiary.set(false);
	}
	public static void armLow()
	{
		RobotMap.ArmPistonPrimary.set(false);
		RobotMap.ArmPistonSecondary.set(false);
		RobotMap.ArmPistonTertiary.set(false);
	}
	public static void armLowFast()
	{
		RobotMap.ArmPistonPrimary.set(false);
		RobotMap.ArmPistonSecondary.set(false);
		RobotMap.ArmPistonTertiary.set(true);
	}
}

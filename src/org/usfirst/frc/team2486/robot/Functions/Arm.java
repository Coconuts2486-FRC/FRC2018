package org.usfirst.frc.team2486.robot.Functions;

import org.usfirst.frc.team2486.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Arm {
	public static void armHigh()
	{
		RobotMap.ArmPistonPrimary.set(false);
		RobotMap.ArmPistonSecondary.set(true);
		RobotMap.ArmPistonTertiary.set(false);
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
	public static void armlowfast()
	{
		RobotMap.ArmPistonPrimary.set(false);
		RobotMap.ArmPistonSecondary.set(false);
		RobotMap.ArmPistonTertiary.set(true);
	}
}

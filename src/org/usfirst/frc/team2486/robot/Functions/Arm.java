package org.usfirst.frc.team2486.robot.Functions;

import org.usfirst.frc.team2486.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Arm {
	public static void armHigh()
	{
		RobotMap.ArmPiston.set(Value.kForward);
	}
	public static void armMid()
	{
		RobotMap.ArmPiston.set(Value.kOff);
	}
	public static void armLow()
	{
		RobotMap.ArmPiston.set(Value.kReverse);
	}
}

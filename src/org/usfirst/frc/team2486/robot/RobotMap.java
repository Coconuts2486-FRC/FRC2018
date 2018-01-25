package org.usfirst.frc.team2486.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;

public class RobotMap
{
	public static Joystick DriverLeft;
	public static Joystick DriverRight;
	
	public static TalonSRX Left;
	public static TalonSRX LeftSlave;
	public static TalonSRX Right;
	public static TalonSRX RightSlave;
	
	public static void Initialize()
	{
		Left  = new TalonSRX(1);
		Right = new TalonSRX(3);
		LeftSlave  = new TalonSRX(2);
		RightSlave = new TalonSRX(4);

		Left.setInverted(true);
		LeftSlave.setInverted(true);
		
		LeftSlave.set(ControlMode.Follower, Left.getDeviceID());
		RightSlave.set(ControlMode.Follower, Right.getDeviceID());
		
		DriverLeft = new Joystick(0);
		DriverRight = new Joystick(1);
	}
	
	private static boolean m_Initialized = false;
	
	public static boolean IsInitialized()
	{
		return m_Initialized;
	}
}

package org.usfirst.frc.team2486.robot.Subsystems;

import java.util.Timer;
import java.util.TimerTask;

import org.usfirst.frc.team2486.robot.RobotMap;
import org.usfirst.frc.team2486.robot.Enums.ArmStates;

public class Arm
{
	public static ArmStates currentState = ArmStates.LOW;
	
	public static Runnable thread = new Runnable()
	{
		@Override
		public void run()
		{
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			armLow();
		}
	};
	
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
		currentState = ArmStates.HIGH;
	}
	public static void armMid()
	{
		RobotMap.ArmPistonPrimary.set(true);
		RobotMap.ArmPistonSecondary.set(false);
		RobotMap.ArmPistonTertiary.set(false);
		currentState = ArmStates.MEDIUM;
	}

	public static void armLow()
	{
		if(currentState == ArmStates.HIGH)
		{
			armMid();
			new Timer().schedule(new TimerTask() {
				
				@Override
				public void run() {
					armLow();
				}
			}, 500);
			//new Thread(thread).start();
		}
		else
		{
			RobotMap.ArmPistonPrimary.set(false);
			RobotMap.ArmPistonSecondary.set(false);
			RobotMap.ArmPistonTertiary.set(false);
		}
		currentState = ArmStates.LOW;
	}
	public static void armLowFast()
	{
		RobotMap.ArmPistonPrimary.set(false);
		RobotMap.ArmPistonSecondary.set(false);
		RobotMap.ArmPistonTertiary.set(true);
		currentState = ArmStates.LOW;
	}
}

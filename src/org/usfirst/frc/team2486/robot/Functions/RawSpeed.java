package org.usfirst.frc.team2486.robot.Functions;

import org.usfirst.frc.team2486.robot.RobotMap;
import org.usfirst.frc.team2486.robot.Interfaces.IAutoCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class RawSpeed implements IAutoCommand
{
	private double _left;
	private double _right;
	private long _timeDelay;
	
	public RawSpeed(double left, double right, long timeDelay)
	{
		_left = left;
		_right = right;
		_timeDelay = timeDelay;
	}
	
	@Override
	public void Run() {
		RobotMap.Left.set(ControlMode.PercentOutput, _left);
		RobotMap.Right.set(ControlMode.PercentOutput, _right);
		
		try {
			Thread.sleep(_timeDelay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RobotMap.Left.set(ControlMode.PercentOutput, 0);
		RobotMap.Right.set(ControlMode.PercentOutput, 0);
	}

}

package org.usfirst.frc.team2486.robot.Auto.Blue;

import org.usfirst.frc.team2486.robot.RobotMap;
import org.usfirst.frc.team2486.robot.Functions.PlotThread;
import org.usfirst.frc.team2486.robot.Interfaces.AutoMode;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class VelocityTest extends AutoMode
{
	public VelocityTest() {
		super();
		
	}
	
	@Override
	public void Run() {
		while (true) {
			RobotMap.Left.set(ControlMode.PercentOutput, 0.25);
			RobotMap.Right.set(ControlMode.PercentOutput, 0.25);
		}
	}
}

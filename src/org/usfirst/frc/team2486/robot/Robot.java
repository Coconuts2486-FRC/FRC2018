/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2486.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	@Override
	public void robotInit()
	{
		RobotMap.Initialize();
	}

	@Override
	public void autonomousInit()
	{
		
	}
	
	@Override
	public void autonomousPeriodic()
	{
		RobotMap.Left.set(ControlMode.PercentOutput, 0.5);
		RobotMap.Right.set(ControlMode.PercentOutput, 0.5);
	}

	@Override
	public void teleopPeriodic()
	{
		RobotMap.Left.set(ControlMode.PercentOutput, -RobotMap.DriverLeft.getY());
		RobotMap.Right.set(ControlMode.PercentOutput, -RobotMap.DriverRight.getY());
	}

	@Override
	public void testPeriodic()
	{
		
	}
	
	@Override
	public void disabledPeriodic()
	{
		RobotMap.Left.set(ControlMode.PercentOutput, 0);
		RobotMap.Right.set(ControlMode.PercentOutput, 0);
	}
}
package org.usfirst.frc.team2486.robot;

import org.usfirst.frc.team2486.robot.Enums.ControlButton;

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

	boolean shifterHeld = false;
	
	@Override
	public void teleopPeriodic()
	{
		// Drive train
		RobotMap.Left.set(ControlMode.PercentOutput, -RobotMap.PrimaryLeft.getY());
		RobotMap.Right.set(ControlMode.PercentOutput, -RobotMap.PrimaryRight.getY());
		
		// Shifters
		boolean leftTrigger = RobotMap.PrimaryLeft.getRawButton(ControlButton.SHIFTERS.getValue());
		boolean rightTrigger = RobotMap.PrimaryRight.getRawButton(ControlButton.SHIFTERS.getValue());
		
		if(shifterHeld == false)
		{
			if(leftTrigger || rightTrigger)
			{
				RobotMap.Shifters.set(!RobotMap.Shifters.get());
			}
		}
		
		if(leftTrigger || rightTrigger)
		{
			shifterHeld = true;
		}
		else
		{
			shifterHeld = false;
		}
		
		// Power cube intake
		
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
		SmartDashboard.putBoolean("Compressor", RobotMap.AirCompressor.getPressureSwitchValue());
	}
}
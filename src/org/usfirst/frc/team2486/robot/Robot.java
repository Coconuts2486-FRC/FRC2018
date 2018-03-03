package org.usfirst.frc.team2486.robot;

import org.usfirst.frc.team2486.robot.Interfaces.IOpMode;
import org.usfirst.frc.team2486.robot.OpModes.Autonomous;
import org.usfirst.frc.team2486.robot.OpModes.Disabled;
import org.usfirst.frc.team2486.robot.OpModes.TeleOp;
import org.usfirst.frc.team2486.robot.OpModes.Test;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot
{
	IOpMode currentMode = null;
	
	@Override
	public void robotInit()
	{
		RobotMap.Initialize();
		currentMode = new Disabled();
		Initialize();
	}

	@Override
	public void autonomousInit()
	{
		currentMode = new Autonomous();
		Initialize();
	}

	@Override
	public void teleopInit()
	{
		currentMode = new TeleOp();
		Initialize();
	}
	
	@Override
	public void teleopPeriodic()
	{
		Loop();
	}

	@Override
	public void testInit()
	{
		currentMode = new Test();
		Initialize();
	}
	
	@Override
	public void testPeriodic()
	{
		Loop();
	}
	
	@Override
	public void disabledInit()
	{
		currentMode = new Disabled();
		Initialize();
	}
	
	@Override
	public void disabledPeriodic()
	{
		Loop();
	}
	
	public void Initialize()
	{
		currentMode.Initialize();
	}
	
	public void Loop()
	{
		currentMode.Loop();
	}
}
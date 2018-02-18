package org.usfirst.frc.team2486.robot.Functions;

import org.usfirst.frc.team2486.robot.RobotMap;
import org.usfirst.frc.team2486.robot.Enums.DistanceUnit;
import org.usfirst.frc.team2486.robot.Interfaces.IAutoCommand;
import org.usfirst.frc.team2486.robot.Subsystems.*;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *  Drive the robot to a specific distance using the drive train encoders.
 *  Calling the run() method will cause the robot to become stuck in a while() loop
 *  until it has reached its target!
 */
public class DriveToDistance implements IAutoCommand
{	
	private double _distance = 0;
	private DistanceUnit _unit;
	public DriveToDistance(double distance, DistanceUnit unit)
	{
		_distance = distance;
		_unit = unit;
	}
	
	@Override
	public void Run()
	{
		// TODO: Implement encoder system to run to a specific distance.
		DriveTo.Drive(_distance, _unit);
	}
}
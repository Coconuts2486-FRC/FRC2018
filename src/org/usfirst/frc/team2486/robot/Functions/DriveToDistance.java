package org.usfirst.frc.team2486.robot.Functions;

import org.usfirst.frc.team2486.robot.RobotMap;
import org.usfirst.frc.team2486.robot.Interfaces.IAutoCommand;

import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

/**
 *  Drive the robot to a specific distance using the drive train encoders.
 *  Calling the run() method will cause the robot to become stuck in a while() loop
 *  until it has reached its target!
 */
public class DriveToDistance implements IAutoCommand
{
	private final double _wheelDiameter = 5.975; // Inches. Manufacturer: 5.875
	private final double _leftTread     = 0.145; // Inches.
	private final double _rightTread    = 0.285; // Inches.
	
	private double _sumLeftDiameter  = 0;
	private double _sumRightDiameter = 0;
	
	private double _distance = 0;
	public DriveToDistance(double distance)
	{
		_distance = distance;
		_sumLeftDiameter  = _wheelDiameter + (2 * _leftTread);
		_sumRightDiameter = _wheelDiameter + (2 * _rightTread);
	}
	
	@Override
	public void Run()
	{
		// TODO: Implement encoder system to run to a specific distance.
		RobotMap.Left.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, 1, 10);
		RobotMap.Left.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
	}
}
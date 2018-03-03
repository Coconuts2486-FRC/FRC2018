package org.usfirst.frc.team2486.robot.Subsystems;

import org.usfirst.frc.team2486.robot.RobotMap;
import org.usfirst.frc.team2486.robot.Enums.DistanceUnit;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTo
{
	private static final double _wheelDiameter = 5.975; // Inches. Manufacturer: 5.875
	private static final double _leftTread     = 0.145; // Inches.
	private static final double _rightTread    = 0.285; // Inches.
	
	private static double _sumLeftDiameter  = _wheelDiameter + (2 * _leftTread);
	private static double _sumRightDiameter = _wheelDiameter + (2 * _rightTread);
	
	public static void Drive(double distance, DistanceUnit unit)
	{
		// Convert to rotations.
		double desiredRotations = distance * unit.getValue();
		
		SmartDashboard.putNumber("Desired Position", desiredRotations);
		
		RobotMap.Left.set(ControlMode.Position,  desiredRotations + RobotMap.Left.getSelectedSensorPosition(0));
		RobotMap.Right.set(ControlMode.Position, desiredRotations + RobotMap.Right.getSelectedSensorPosition(0));
		
		while(!OnTarget()) { }
	}
	
	public static boolean OnTarget()
	{
		double leftError  = RobotMap.Left.getClosedLoopTarget(0)  - RobotMap.Left.getSelectedSensorPosition(0);
		double rightError = RobotMap.Right.getClosedLoopTarget(0) - RobotMap.Right.getSelectedSensorPosition(0);
		
		return !((rightError > 50) && (leftError > 50));
	}
}

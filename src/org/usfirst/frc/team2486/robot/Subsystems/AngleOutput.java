package org.usfirst.frc.team2486.robot.Subsystems;

import org.usfirst.frc.team2486.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.PIDOutput;

class AngleOutput implements PIDOutput
{
	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		RobotMap.Left.set(ControlMode.PercentOutput, output);
        RobotMap.Right.set(ControlMode.PercentOutput, -output);
	}
}

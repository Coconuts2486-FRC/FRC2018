package org.usfirst.frc.team2486.robot.Auto.Test;

import org.usfirst.frc.team2486.robot.RobotMap;
import org.usfirst.frc.team2486.robot.Interfaces.AutoMode;

import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 *  Used to calculate the forward gain of the encoders.
 *  F-gain = ([Percent Output] x 1023) / [Velocity]
 *  
 *  @see <a href="https://github.com/CrossTheRoadElec/Phoenix-Documentation#closed-loop-gains">
 */
public class ForwardGain extends AutoMode
{
	public ForwardGain()
	{
		super();
		RobotMap.Left.set(ControlMode.PercentOutput, 0.75);
		RobotMap.Right.set(ControlMode.PercentOutput, 0.75);
	}
}
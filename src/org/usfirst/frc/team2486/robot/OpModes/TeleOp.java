package org.usfirst.frc.team2486.robot.OpModes;

import org.usfirst.frc.team2486.robot.RobotMap;
import org.usfirst.frc.team2486.robot.Enums.ControlButton;
import org.usfirst.frc.team2486.robot.Interfaces.OpMode;

import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * Routines for the driver-controlled period.
 */
public class TeleOp implements OpMode
{
	/**
	 *  Place code inside here that is intended to run once before TeleOp starts.
	 */
	@Override
	public void Initialize()
	{

	}

	private boolean shifterHeld = false;
	/**
	 *  Place code inside here that is intended to loop continuously.
	 */
	
	@Override
	public void Loop()
	{
		// Drive train
		RobotMap.Left.set(ControlMode.PercentOutput, -RobotMap.PrimaryLeft.getY());
		RobotMap.Right.set(ControlMode.PercentOutput, -RobotMap.PrimaryRight.getY());

		// Shifters
		boolean leftTrigger = RobotMap.PrimaryLeft.getRawButton(ControlButton.SHIFTERS.getValue());
		boolean rightTrigger = RobotMap.PrimaryRight.getRawButton(ControlButton.SHIFTERS.getValue());

		if (shifterHeld == false) {
			if (leftTrigger || rightTrigger) {
				RobotMap.Shifters.set(!RobotMap.Shifters.get());
			}
		}

		if (leftTrigger || rightTrigger) {
			shifterHeld = true;
		} else {
			shifterHeld = false;
		}

		//TODO: Power cube intake
		boolean intake1 = RobotMap.PrimaryRight.getRawButton(ControlButton.HEADIN.getValue()) ||
				RobotMap.PrimaryLeft.getRawButton(ControlButton.HEADIN.getValue());
		
		boolean output1 = RobotMap.PrimaryRight.getRawButton(ControlButton.HEADOUT.getValue()) || 
				RobotMap.PrimaryLeft.getRawButton(ControlButton.HEADOUT.getValue());
		
		if (intake1 == true) {
			RobotMap.HeadIntake.set(ControlMode.PercentOutput, 1);
		} else {
			//RobotMap.RightClaw.set(ControlMode.PercentOutput, 0);
			if (output1 == true) {
				RobotMap.HeadIntake.set(ControlMode.PercentOutput, -1);
			} else {
				RobotMap.HeadIntake.set(ControlMode.PercentOutput, 0.0);
			}
		}
	}
}
package org.usfirst.frc.team2486.robot.OpModes;

import org.usfirst.frc.team2486.robot.RobotMap;
import org.usfirst.frc.team2486.robot.Enums.ControlButton;
import org.usfirst.frc.team2486.robot.Interfaces.IOpMode;
import org.usfirst.frc.team2486.robot.Subsystems.Arm;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Routines for the driver-controlled period.
 */
public class TeleOp implements IOpMode
{
	/**
	 *  Place code inside here that is intended to run once before TeleOp starts.
	 */
	@Override
	public void Initialize()
	{
		Arm.armLow();
		RobotMap.HeadPiston.set(true);
	}

	private boolean shifterHeld = false;
	private boolean armHeld = false;

	boolean ClawUpDown = false;
	boolean ClawPinchYesNo = false;
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

		if (shifterHeld == false)
			if (leftTrigger || rightTrigger)
				RobotMap.Shifters.set(!RobotMap.Shifters.get());

		if (leftTrigger || rightTrigger)
			shifterHeld = true;
		else
			shifterHeld = false;

		//TODO: Power cube intake
		boolean intake1 = RobotMap.PrimaryRight.getRawButton(ControlButton.HEADIN.getValue()) ||
				RobotMap.PrimaryLeft.getRawButton(ControlButton.HEADIN.getValue());
		
		boolean output1 = RobotMap.PrimaryRight.getRawButton(ControlButton.HEADOUT.getValue()) || 
				RobotMap.PrimaryLeft.getRawButton(ControlButton.HEADOUT.getValue());
		
		if (intake1)
			// TAKES IN
			RobotMap.HeadIntake.set(ControlMode.PercentOutput, 1);
		else
			if (output1)
				// SHOOTS OUT
				RobotMap.HeadIntake.set(ControlMode.PercentOutput, -1);
			else
				RobotMap.HeadIntake.set(ControlMode.PercentOutput, 0.0);
		
		boolean armForward = RobotMap.SecondaryOperator.getRawButtonPressed(ControlButton.ARMFORWARD.getValue());
		boolean armOff     = RobotMap.SecondaryOperator.getRawButtonPressed(ControlButton.ARMOFF.getValue());
		boolean armReverse = RobotMap.SecondaryOperator.getRawButtonPressed(ControlButton.ARMREVERSE.getValue());
		
		if (armHeld == false)
		{
			if (armForward)
				Arm.armHigh();
			else if(armOff)
				Arm.armMid();
			else if(armReverse)
				Arm.armLow();
		}

		if (armForward || armOff || armReverse)
			armHeld = true;
		else
			armHeld = false;
		
		if (RobotMap.SecondaryOperator.getRawButton(ControlButton.CLAWUPDOWN.getValue()) == true)
			ClawUpDown = !ClawUpDown;
		if (ClawUpDown == true)
			RobotMap.ClawLift.set(true);
		else if (ClawUpDown == false)
			RobotMap.ClawLift.set(false);
		
		if (RobotMap.SecondaryOperator.getRawButton(ControlButton.CLAWPINCH.getValue()) == true)
			ClawPinchYesNo = !ClawPinchYesNo;
		if (ClawPinchYesNo == true)
			RobotMap.ClawPincher.set(true);
		else if (ClawPinchYesNo == false)
			RobotMap.ClawPincher.set(false);
	}
}
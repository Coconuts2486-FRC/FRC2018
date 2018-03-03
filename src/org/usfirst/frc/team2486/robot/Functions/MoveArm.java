package org.usfirst.frc.team2486.robot.Functions;

import org.usfirst.frc.team2486.robot.Enums.ArmStates;
import org.usfirst.frc.team2486.robot.Interfaces.IAutoCommand;
import org.usfirst.frc.team2486.robot.Subsystems.Arm;

public class MoveArm implements IAutoCommand
{
	private ArmStates _state;
	
	public MoveArm(ArmStates state)
	{
		_state = state;
	}
	
	@Override
	public void Run()
	{
		Arm.armPos(_state);
	}
}

package org.usfirst.frc.team2486.robot.Subsystems;

import org.usfirst.frc.team2486.robot.RobotMap;
import org.usfirst.frc.team2486.robot.Enums.PIDValues;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;

public class TurnTo
{
	public static PIDController controller;
	public static AngleOutput   pidOutput;
	
	public static void Initialize()
	{
		pidOutput = new AngleOutput();
		controller = new PIDController(PIDValues.GYRO_STADIUM.getP(), PIDValues.GYRO_STADIUM.getI(), PIDValues.GYRO_STADIUM.getD(), PIDValues.GYRO_STADIUM.getF(), RobotMap.NavX, pidOutput);
		RobotMap.NavX.setPIDSourceType(PIDSourceType.kDisplacement);

        // Sets the input range of the controller to be -180 degrees to 180 degrees.
        controller.setInputRange(-180f, 180f);

        // Sets the peak output to be 45% power on the drive train.
        controller.setOutputRange(-.33, .33);

        // Allow for a tolerance of 10 when turning.
        controller.setAbsoluteTolerance(5);
	}
}
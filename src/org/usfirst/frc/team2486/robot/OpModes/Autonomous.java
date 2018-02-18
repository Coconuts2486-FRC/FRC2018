package org.usfirst.frc.team2486.robot.OpModes;
  
import org.usfirst.frc.team2486.robot.RobotMap;
import org.usfirst.frc.team2486.robot.Auto.Blue.BlueLeftScale;
import org.usfirst.frc.team2486.robot.Auto.Blue.BlueLeftSwitch;
import org.usfirst.frc.team2486.robot.Auto.Blue.BlueRightScale;
import org.usfirst.frc.team2486.robot.Auto.Blue.BlueRightSwitch;
import org.usfirst.frc.team2486.robot.Auto.DeadReckoning.Left;
import org.usfirst.frc.team2486.robot.Auto.DeadReckoning.Right;
import org.usfirst.frc.team2486.robot.Auto.Red.RedLeftScale;
import org.usfirst.frc.team2486.robot.Auto.Red.RedLeftSwitch;
import org.usfirst.frc.team2486.robot.Auto.Red.RedRightScale;
import org.usfirst.frc.team2486.robot.Auto.Red.RedRightSwitch;
import org.usfirst.frc.team2486.robot.Auto.Test.AutoDisabled;
import org.usfirst.frc.team2486.robot.Enums.AutoModes;
import org.usfirst.frc.team2486.robot.Interfaces.AutoMode;
import org.usfirst.frc.team2486.robot.Interfaces.IAuto;
import org.usfirst.frc.team2486.robot.Interfaces.IOpMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous implements IOpMode {

	@Override
	public void Initialize()
	{
		/*
		 * lets grab the 360 degree position of the MagEncoder's absolute
		 * position, and intitally set the relative sensor to match.
		 */
		int absolutePositionLeft = RobotMap.Left.getSensorCollection().getPulseWidthPosition();
		/* mask out overflows, keep bottom 12 bits */
		absolutePositionLeft &= 0xFFF;
		/* set the quadrature (relative) sensor to match absolute */
		RobotMap.Left.setSelectedSensorPosition(absolutePositionLeft, 0, 10);
		
		int absolutePositionRight = RobotMap.Right.getSensorCollection().getPulseWidthPosition();
		/* mask out overflows, keep bottom 12 bits */
		absolutePositionRight &= 0xFFF;
		/* set the quadrature (relative) sensor to match absolute */
		RobotMap.Right.setSelectedSensorPosition(absolutePositionRight, 0, 10);
		
		//RobotMap.Left.config_kP(0, SmartDashboard.getNumber("Drivetrain kP", 1.6), 10);
		//RobotMap.Right.config_kP(0, SmartDashboard.getNumber("Drivetrain kP", 1.6), 10);
		
		RobotMap.NavX.resetDisplacement();
		
		RobotMap.HeadPiston.set(true);
		
		IAuto mode = new Right();
		
		if(RobotMap.CurrentAutoMode - 6 >= 0)
			return;
		
//		switch(DriverStation.getInstance().getAlliance())
//		{
//			case Blue:
//				switch(RobotMap.CurrentAutoMode)
//				{
//					case 1:
//						mode = new BlueRightScale();
//						break;
//					case 3:
//						mode = new BlueRightSwitch();
//						break;
//					case 5:
//						mode = new BlueLeftScale();
//						break;
//					case 7:
//						mode = new BlueLeftSwitch();
//						break;
//				}
//				break;
//			case Red:
//				switch(RobotMap.CurrentAutoMode)
//				{
//					case 1:
//						mode = new RedRightScale();
//						break;
//					case 3:
//						mode = new RedRightSwitch();
//						break;
//					case 5:
//						mode = new RedLeftScale();
//						break;
//					case 7:
//						mode = new RedLeftSwitch();
//						break;
//				}
//				break;
//			default:
//				break;
//		}
		
		mode.Run();
	}

	@Override
	public void Loop()
	{
		
	}
}
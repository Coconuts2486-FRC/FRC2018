package org.usfirst.frc.team2486.robot.OpModes;
  
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DropMode;

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
import org.usfirst.frc.team2486.robot.Auto.Test.RunToPos;
import org.usfirst.frc.team2486.robot.Enums.AutoModes;
import org.usfirst.frc.team2486.robot.Functions.PlotThread;
import org.usfirst.frc.team2486.robot.Interfaces.AutoMode;
import org.usfirst.frc.team2486.robot.Interfaces.IAuto;
import org.usfirst.frc.team2486.robot.Interfaces.IOpMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
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
		RobotMap.Left.setSelectedSensorPosition(0, 0, 10);
		
		int absolutePositionRight = RobotMap.Right.getSensorCollection().getPulseWidthPosition();
		/* mask out overflows, keep bottom 12 bits */
		absolutePositionRight &= 0xFFF;
		/* set the quadrature (relative) sensor to match absolute */
		RobotMap.Right.setSelectedSensorPosition(0, 0, 10);
		
		//RobotMap.Left.config_kP(0, SmartDashboard.getNumber("Drivetrain kP", 1.6), 10);
		//RobotMap.Right.config_kP(0, SmartDashboard.getNumber("Drivetrain kP", 1.6), 10);
		
		RobotMap.NavX.resetDisplacement();
		
		RobotMap.HeadClamp.set(true);
		
		Alliance alliance = DriverStation.getInstance().getAlliance();
		
		IAuto mode = new AutoDisabled();
		if(alliance == DriverStation.Alliance.Blue){
		HashMap<Integer, IAuto> Bmodes = new HashMap<Integer, IAuto>();
		Bmodes.put(4, new BlueLeftScale());
		Bmodes.put(6,new BlueLeftSwitch());
		Bmodes.put(5,new BlueRightScale());
		Bmodes.put(7,new BlueRightSwitch());
		
		Bmodes.put(0,new AutoDisabled());
		Bmodes.put(2,new AutoDisabled());
		Bmodes.put(1,new AutoDisabled());
		Bmodes.put(3,new AutoDisabled());
		
		mode = Bmodes.get(PlotThread.controller);
		}
		if(alliance == DriverStation.Alliance.Red){
			HashMap<Integer, IAuto> Rmodes = new HashMap<Integer, IAuto>();
			Rmodes.put(4, new RedLeftScale());
			Rmodes.put(6,new RedLeftSwitch());
			Rmodes.put(5,new RedRightScale());
			Rmodes.put(7,new RedRightSwitch());
			
			Rmodes.put(0,new AutoDisabled());
			Rmodes.put(2,new AutoDisabled());
			Rmodes.put(1,new AutoDisabled());
			Rmodes.put(3,new AutoDisabled());
			
			mode = Rmodes.get(PlotThread.controller);
			}
		mode.Run();
	}

	@Override
	public void Loop()
	{
		
	}
}
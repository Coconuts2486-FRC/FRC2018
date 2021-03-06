package org.usfirst.frc.team2486.robot.Interfaces;

import java.util.ArrayList;

import org.usfirst.frc.team2486.robot.RobotMap;
import org.usfirst.frc.team2486.robot.Functions.PlateAssignment;
import org.usfirst.frc.team2486.robot.Functions.PlotThread;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class AutoMode implements IAuto
{
	public ArrayList<IAutoCommand> CommandList;
	public PlateAssignment Plates;
	public Alliance AllianceColor;
	
	public AutoMode()
	{
		CommandList = new ArrayList<IAutoCommand>();
		Plates = new PlateAssignment();
		AllianceColor = DriverStation.getInstance().getAlliance();
	}
	
	@Override
	public void Run()
	{
		SmartDashboard.putNumber("Command List Count", CommandList.size());
		if(CommandList.size() != 0)
			for(IAutoCommand command : CommandList)
				command.Run();
	}
}

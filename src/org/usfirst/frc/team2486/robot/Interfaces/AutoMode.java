package org.usfirst.frc.team2486.robot.Interfaces;

import java.util.ArrayList;

import org.usfirst.frc.team2486.robot.Functions.PlateAssignment;

public abstract class AutoMode implements IAuto
{
	public ArrayList<IAutoCommand> CommandList;
	public PlateAssignment Plates;
	
	public AutoMode()
	{
		CommandList = new ArrayList<IAutoCommand>();
		Plates = new PlateAssignment();
	}
	
	@Override
	public void Run()
	{
		if(CommandList.size() != 0)
			for(IAutoCommand command : CommandList)
				command.Run();
	}
}

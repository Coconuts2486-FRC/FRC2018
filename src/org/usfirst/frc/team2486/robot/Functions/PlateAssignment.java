package org.usfirst.frc.team2486.robot.Functions;

import edu.wpi.first.wpilibj.DriverStation;

/**
 *  Handles plate assignment details from the FMS.
 */
public class PlateAssignment
{
	private String _dsData;
	private boolean isData;
	
	/**
	 * Creates a new instance of PlateAssignment.
	 * Must be called in auto or teleop.
	 * @throws OpModeException 
	 */
	public PlateAssignment()
	{
		if((DriverStation.getInstance().isAutonomous() || DriverStation.getInstance().isOperatorControl()) == false)
		{
			DriverStation.reportError("OpMode is not autonomous or teleop. Data is futile.", false);
		}
		_dsData = DriverStation.getInstance().getGameSpecificMessage();
		if(_dsData == "")
		{
			isData = false;
		}
	}
	
	/**
	 * Returns true if data was received either from the FMS or DS.
	 * @return Whether data was published.
	 */
	public boolean isData()
	{
		return isData;
	}
	
	public String getRaw()
	{
		return _dsData;
	}
	
	/**
	 *  Exception specific for autonomous issues.
	 */
	public class OpModeException extends Exception
	{
		public OpModeException(String string) { super(string); }
		private static final long serialVersionUID = 1L;
	}
}
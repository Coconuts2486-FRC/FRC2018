package org.usfirst.frc.team2486.robot.Functions;

import org.usfirst.frc.team2486.robot.RobotMap;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

@SuppressWarnings("deprecation")
public class PlotThread implements Runnable
{
	private boolean verbose;
	
	
	public PlotThread(boolean verbose) {
		this.verbose = verbose;
	}
	
	public void run() {
		
		SmartDashboard.putBoolean("Compressor", true);
		
		if(!DriverStation.getInstance().isFMSAttached())
			 NetworkTable.setUpdateRate(0.010);
		else NetworkTable.setUpdateRate(0.1);
		
		if (verbose) {
			while (true) {
				/* yield for a ms or so - this is not meant to be accurate */
				try {
					Thread.sleep(1);
				} 
				catch (Exception e) {
				}
				/* grab the last signal update from our 1ms frame update */
				SmartDashboard.putNumber("Left Velocity", RobotMap.Left.getSelectedSensorVelocity(0));
				SmartDashboard.putNumber("Right Velocity", RobotMap.Right.getSelectedSensorVelocity(0));
				SmartDashboard.putNumber("Left Rotations", RobotMap.Left.getSelectedSensorPosition(0));
				SmartDashboard.putNumber("Right Rotations", RobotMap.Right.getSelectedSensorPosition(0));
				SmartDashboard.putNumber("NavX Heading", RobotMap.NavX.getYaw());
				
				byte controller = 0;
				
				controller += !RobotMap.SecondaryOperator.getRawButton(8)   ? 4 : 0;
				controller += !RobotMap.SecondaryOperator.getRawButton(9)   ? 2 : 0;
				controller += !RobotMap.SecondaryOperator.getRawButton(10)  ? 1 : 0;
							
				SmartDashboard.putString("Alliance Color", DriverStation.getInstance().getAlliance().toString());
				SmartDashboard.putNumber("Mode", controller);
				
				boolean comp = SmartDashboard.getBoolean("Compressor", true);
				if (comp) {
					RobotMap.AirCompressor.stop();
				}
				else {
					RobotMap.AirCompressor.start();
				}
			}
		}
	}
}
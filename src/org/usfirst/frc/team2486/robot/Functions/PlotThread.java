package org.usfirst.frc.team2486.robot.Functions;

import org.usfirst.frc.team2486.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

@SuppressWarnings("deprecation")
public class PlotThread implements Runnable
{
	private boolean verbose;
	
	
	public PlotThread(boolean verbose) {
		this.verbose = verbose;
	}
	
	public void run() {
		
		if(!DriverStation.getInstance().isFMSAttached())
			 NetworkTable.setUpdateRate(0.010);
		else NetworkTable.setUpdateRate(0.1);
		
		if (verbose) {
			while (true) {
				/* yield for a ms or so - this is not meant to be accurate */
				try {
					Thread.sleep(1);
				} catch (Exception e) {
				}
				/* grab the last signal update from our 1ms frame update */
				SmartDashboard.putNumber("Left Velocity", RobotMap.Left.getSelectedSensorVelocity(0));
				SmartDashboard.putNumber("Right Velocity", RobotMap.Right.getSelectedSensorVelocity(0));
				SmartDashboard.putNumber("NavX Heading", RobotMap.NavX.getYaw());
				SmartDashboard.putNumber("Battery Level", RobotMap.PDP.getVoltage());
			}
		}
		
		/*
		 * speed up network tables, this is a test project so eat up all of
		 * the network possible for the purpose of this test.
		 */
		// NetworkTable.setUpdateRate(0.010); /* this suggests each time
		// unit is 10ms in the plot */
		
	}
}

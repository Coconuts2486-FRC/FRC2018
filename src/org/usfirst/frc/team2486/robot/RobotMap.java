package org.usfirst.frc.team2486.robot;

import org.usfirst.frc.team2486.robot.Enums.RobotIDs;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;

public class RobotMap
{
	/**
	 * Left joystick of the primary driver.
	 * Handles the drive train subsystem.
	 */
	public static Joystick PrimaryLeft;
	/**
	 * Right joystick of the primary driver.
	 * Handles the drive train subsystem.
	 */
	public static Joystick PrimaryRight;
	/**
	 * Secondary operator's custom gamepad
	 */
	public static Joystick SecondaryOperator;
	
	public static TalonSRX Left;
	public static TalonSRX LeftSlave;
	public static TalonSRX Right;
	public static TalonSRX RightSlave;
	
	/**
	 *  Motor for rotating the power cube intake.
	 */
	public static TalonSRX HeadActuator;
	/**
	 *  Primary intake motor for the power cubes.
	 */
	public static TalonSRX HeadIntake;
	/**
	 *  Slave intake motor for the power cubes.
	 *  Direction is reversed from its master Talon.
	 */
	public static TalonSRX HeadIntakeSlave;
	
	/**
	 *  Onboard compressor to build air pressure.
	 */
	public static Compressor AirCompressor;
	/**
	 *  Pneumatic shifters on the drivetrain.
	 */
	public static Solenoid Shifters;
	/**
	 *  Three-state piston to raise the arm.
	 */
	public static DoubleSolenoid Arm;
	
	/**
	 * The most beautiful device in the world.
	 */
	public static AHRS NavX;
	
	public static void Initialize()
	{
		Left  = new TalonSRX(RobotIDs.LEFT.getValue());
		Right = new TalonSRX(RobotIDs.RIGHT.getValue());
		LeftSlave  = new TalonSRX(RobotIDs.LEFTSLAVE.getValue());
		RightSlave = new TalonSRX(RobotIDs.RIGHTSLAVE.getValue());

		Left.setInverted(true);
		LeftSlave.setInverted(true);
		
		LeftSlave.set(ControlMode.Follower, Left.getDeviceID());
		RightSlave.set(ControlMode.Follower, Right.getDeviceID());
		
		HeadActuator    = new TalonSRX(RobotIDs.HEADACTUATOR.getValue());
		HeadIntake      = new TalonSRX(RobotIDs.HEADINTAKE.getValue());
		HeadIntakeSlave = new TalonSRX(RobotIDs.HEADINTAKESLAVE.getValue());
		HeadIntakeSlave.set(ControlMode.Follower, HeadIntake.getDeviceID());
		HeadIntakeSlave.setInverted(true);
		
		PrimaryLeft  = new Joystick(RobotIDs.PRIMARYLEFT.getValue());
		PrimaryRight = new Joystick(RobotIDs.PRIMARYRIGHT.getValue());
		SecondaryOperator = new Joystick(RobotIDs.SECONDARYOPERATOR.getValue());
		
		AirCompressor = new Compressor(RobotIDs.PCM.getValue());
		Shifters      = new Solenoid(RobotIDs.PCM.getValue(), RobotIDs.SHIFTERS.getValue());
		Arm           = new DoubleSolenoid(RobotIDs.PCM.getValue(), RobotIDs.ARMPRIMARY.getValue(), RobotIDs.ARMSECONDARY.getValue());
		
		AirCompressor.setClosedLoopControl(true);
		
		NavX = new AHRS(Port.kMXP);
		
		m_Initialized = true;
	}
	
	private static boolean m_Initialized = false;
	
	public static boolean IsInitialized()
	{
		return m_Initialized;
	}
}

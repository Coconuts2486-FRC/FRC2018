package org.usfirst.frc.team2486.robot;

import org.usfirst.frc.team2486.robot.Enums.PIDValues;

import org.usfirst.frc.team2486.robot.Enums.RobotIDs;
import org.usfirst.frc.team2486.robot.Functions.PlotThread;
import org.usfirst.frc.team2486.robot.Subsystems.TurnTo;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
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
	
	public static TalonSRX HeadActuatorSlave;
	
	/**
	 *  Primary intake motor for the power cubes.
	 */
	public static TalonSRX HeadIntake;
	/**
	 *  Slave intake motor for the power cubes.
	 *  Direction is reversed from its master Talon.
	 */
	public static TalonSRX HeadIntakeSlave;
	
	public static TalonSRX Climber;
	
	public static TalonSRX ClimberSlave;
	
	/**
	 *  Onboard compressor to build air pressure.
	 */
	public static Compressor AirCompressor;
	/**
	 *  Pneumatic shifters on the drivetrain.
	 */
	public static Solenoid Shifters;
	/**
	 *  Pneumatic shifters on the head.
	 */
	public static Solenoid HeadPiston;
	/**
	 *  Three-state piston to raise the arm.
	 */
	public static Solenoid ArmPistonPrimary;
	/**
	 *  Second manifold for piston head.
	 */
	public static Solenoid ArmPistonSecondary;
	/**
	 *  Third manifold for piston head.
	 */
	public static Solenoid ArmPistonTertiary;
	
	//public static TalonSRX Climber;
	
	/**
	 *  piston for claw
	 */
	
	public static Solenoid ClawLift;
	
	/**
	 *  piston to pinch
	 */
	
	public static Solenoid ClawPincher;
	
	//public static Encoder RightEncoder;
	//public static Encoder LeftEncoder;
	/**
	 * The most beautiful device in the world.
	 */
	public static AHRS NavX;
	
	/**
	 *  Distributes power to the robot.
	 *  Used to measure robot voltage.
	 */
	public static PowerDistributionPanel PDP;
	
	public static byte CurrentAutoMode = 0;
	
	public static final PIDValues currentPID = PIDValues.CACTUS_HIGH;
	
	public static PlotThread DataThread;
	
	public static void Initialize()
	{
		SmartDashboard.putNumber("Drivetrain kP", 1.6);
		
		Left  = new TalonSRX(RobotIDs.LEFT.getValue());
		Right = new TalonSRX(RobotIDs.RIGHT.getValue());
		LeftSlave  = new TalonSRX(RobotIDs.LEFTSLAVE.getValue());
		RightSlave = new TalonSRX(RobotIDs.RIGHTSLAVE.getValue());
		
		Climber           = new TalonSRX(RobotIDs.CLIMBER.getValue());
		ClimberSlave      = new TalonSRX(RobotIDs.CLIMBERSLAVE.getValue());
		
		
		HeadActuator      = new TalonSRX(RobotIDs.HEADACTUATOR.getValue());
		HeadActuatorSlave = new TalonSRX(RobotIDs.HEADACTUATORSLAVE.getValue());
		HeadActuatorSlave.setInverted(true);
		HeadActuatorSlave.set(ControlMode.Follower, RobotIDs.HEADACTUATOR.getValue());
		
		HeadIntake        = new TalonSRX(RobotIDs.HEADINTAKE.getValue());
		HeadIntakeSlave   = new TalonSRX(RobotIDs.HEADINTAKESLAVE.getValue());
		HeadIntakeSlave.set(ControlMode.Follower, HeadIntake.getDeviceID());

		Left.setInverted(true);
		LeftSlave.setInverted(true);
		
		LeftSlave.set(ControlMode.Follower, Left.getDeviceID());
		RightSlave.set(ControlMode.Follower, Right.getDeviceID());
		
		Left.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, 1, 10);
		Left.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		Left.setSensorPhase(true);
		
		Left.configNominalOutputForward(0.0f, 10);
		Left.configNominalOutputReverse(0.0f, 10);
		Left.configPeakOutputForward(0.75f, 10);
		Left.configPeakOutputReverse(-0.75f, 10);
		
		Left.configAllowableClosedloopError(5, 0, 10);
		Left.config_kP(0, currentPID.getP(), 10);
		Left.config_kI(0, currentPID.getI(), 10);
		Left.config_kD(0, currentPID.getD(), 10);
		Left.config_kF(0, currentPID.getF(), 10);
		
		/*
		 * lets grab the 360 degree position of the MagEncoder's absolute
		 * position, and intitally set the relative sensor to match.
		 */
		int absolutePositionLeft = Left.getSensorCollection().getPulseWidthPosition();
		/* mask out overflows, keep bottom 12 bits */
		absolutePositionLeft &= 0xFFF;
		/* set the quadrature (relative) sensor to match absolute */
		Left.setSelectedSensorPosition(absolutePositionLeft, 0, 10);
		
		Right.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, 1, 10);
		Right.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		Right.setSensorPhase(true);
		
		Right.configNominalOutputForward(0.0f, 10);
		Right.configNominalOutputReverse(0.0f, 10);
		Right.configPeakOutputForward(0.75f, 10);
		Right.configPeakOutputReverse(-0.75f, 10);
		
		Right.configAllowableClosedloopError(5, 0, 10);
		Right.config_kP(0, currentPID.getP(), 10);
		Right.config_kI(0, currentPID.getI(), 10);
		Right.config_kD(0, currentPID.getD(), 10);
		Right.config_kF(0, currentPID.getF(), 10);
		
		int absolutePositionRight = Right.getSensorCollection().getPulseWidthPosition();
		/* mask out overflows, keep bottom 12 bits */
		absolutePositionRight &= 0xFFF;
		/* set the quadrature (relative) sensor to match absolute */
		Right.setSelectedSensorPosition(absolutePositionRight, 0, 10);
		
		PrimaryLeft  = new Joystick(RobotIDs.PRIMARYLEFT.getValue());
		PrimaryRight = new Joystick(RobotIDs.PRIMARYRIGHT.getValue());
		SecondaryOperator = new Joystick(RobotIDs.SECONDARYOPERATOR.getValue());
		
		AirCompressor = new Compressor(RobotIDs.PCM.getValue());
		Shifters      = new Solenoid(RobotIDs.PCM.getValue(), RobotIDs.SHIFTERS.getValue());
		HeadPiston    = new Solenoid(RobotIDs.PCM.getValue(), RobotIDs.HEADPISTON.getValue());
		
		ArmPistonPrimary   = new Solenoid(RobotIDs.PCM.getValue(), RobotIDs.ARMPRIMARY.getValue());
		ArmPistonSecondary = new Solenoid(RobotIDs.PCM.getValue(), RobotIDs.ARMSECONDARY.getValue());
		ArmPistonTertiary  = new Solenoid(RobotIDs.PCM.getValue(), RobotIDs.ARMTERTIARY.getValue());
		
		AirCompressor.setClosedLoopControl(true);
		
		//Climber = new TalonSRX(RobotIDs.CLIMBER.getValue());
		
		ClawLift = new Solenoid(RobotIDs.CLAWLIFT.getValue());
		
		ClawPincher = new Solenoid(RobotIDs.CLAWLIFT.getValue());
		
		NavX = new AHRS(Port.kMXP);
		NavX.resetDisplacement();
		
		//PDP = new PowerDistributionPanel(0);
		
		CameraServer.getInstance().startAutomaticCapture();
		
		m_Initialized = true;
		
		DataThread = new PlotThread(true);
		new Thread(DataThread).start();
		
		CameraServer.getInstance().startAutomaticCapture();
		TurnTo.Initialize();
	}
	
	private static boolean m_Initialized = false;
	
	public static boolean IsInitialized()
	{
		return m_Initialized;
	}
}

package org.usfirst.frc.team2486.robot.Enums;

public enum PIDValues
{
	DRIVETRAIN_STADIUM(1.6, 0, 0, 0),
	COMPBOT_DRIVETRAIN_STADIUM(0.037, 0, 0, 0),
	GYRO_STADIUM(0.01, 0, 0, 0),
	CACTUS_HIGH(0.8, 0, 0, 0),
    ;
	
	private double kP;
	private double kI;
	private double kD;
	private double kF;
	
    private PIDValues(double kP, double kI, double kD, double kF)
    {
    	this.kP = kP;
    	this.kI = kI;
    	this.kD = kD;
    	this.kF = kF;
    }
    
    public double getP()
    {
    	return kP;
    }
    
    public double getI()
    {
    	return kI;
    }
    
    public double getD()
    {
    	return kD;
    }
    
    public double getF()
    {
    	return kF;
    }
}
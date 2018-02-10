package org.usfirst.frc.team2486.robot.Subsystems;

import org.usfirst.frc.team2486.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class TurnToAngle extends PIDController implements PIDSource, PIDOutput
{

	public TurnToAngle(double Kp, double Ki, double Kd, double Kf, PIDSource source, PIDOutput output) {
		super(Kp, Ki, Kd, Kf, source, output);
		
		// Means it will return the distance from the start of the PID control.
    	setPIDSourceType(PIDSourceType.kDisplacement);

        // Sets the input range of the controller to be -180 degrees to 180 degrees.
        setInputRange(-180f, 180f);

        // Sets the peak output to be 45% power on the drive train.
        setOutputRange(-.65, 65);

        // Allow for a tolerance of 10 when turning.
        setAbsoluteTolerance(5);
	}

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		RobotMap.Left.set(ControlMode.PercentOutput, output);
        RobotMap.Right.set(ControlMode.PercentOutput, output);
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return RobotMap.NavX.getPIDSourceType();
	}

	@Override
	public double pidGet() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setPIDSourceType(PIDSourceType pidSource) {
		RobotMap.NavX.setPIDSourceType(pidSource);
	}

}

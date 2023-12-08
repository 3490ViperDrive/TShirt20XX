package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj.drive.RobotDriveBase;
//import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.MecanumDrive;


public class DriveSubsystem extends SubsystemBase {
    private CANSparkMax frontRightMotor = new CANSparkMax(4, MotorType.kBrushless);
    private CANSparkMax frontLeftMotor = new CANSparkMax(3, MotorType.kBrushless);
    private CANSparkMax rearRightMotor = new CANSparkMax(2, MotorType.kBrushless);
    private CANSparkMax rearLeftMotor = new CANSparkMax(9, MotorType.kBrushless); 

    MecanumDrive myDrive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

public void Drive(double xSpeed, double ySpeed, double zRotation){
    
    }



}






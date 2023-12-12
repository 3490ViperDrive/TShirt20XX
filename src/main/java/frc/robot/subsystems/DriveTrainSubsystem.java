package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase{

    public static Object set;
    
    //4 cansparkmaxes
    private CANSparkMax frontRightMotor();
    private CANSparkMax frontLeftMotor();
    private CANSparkMax backRightMotor();
    private CANSparkMax backLeftMotor();


    //mecanumDrive object out of ^ those cansparkmaxes

    //TODO: add "move/drive" method
        //inputs: 3 doubles 
        //return: void
}   


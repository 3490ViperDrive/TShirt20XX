package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase{

    //public static Object set;
    
    //4 cansparkmaxes
    private CANSparkMax frontRightMotor = new CANSparkMax(4, null);
    private CANSparkMax frontLeftMotor = new CANSparkMax(3, null);
    private CANSparkMax rearRightMotor = new CANSparkMax(2, null);
    private CANSparkMax rearLeftMotor = new CANSparkMax(9, null);

    // <type> <name> = new <type>()
    MecanumDrive xDrive = new MecanumDrive(frontRightMotor,  frontLeftMotor,  rearRightMotor,  rearLeftMotor);	


public void moveBot(double xSpeed, double ySpeed, double zRotation){
    xDrive.driveCartesian(xSpeed, ySpeed, zRotation);
}
    //mecanumDrive object out of ^ those cansparkmaxes

    //TODO: add "move/drive" method
        //inputs: 3 doubles 
        //return: void
}  
 


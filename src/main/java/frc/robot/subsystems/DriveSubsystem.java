package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.MecanumDriveKinematics;
import edu.wpi.first.math.kinematics.MecanumDriveWheelSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ControllerConstants;

import static frc.robot.Constants.DrivetrainConstants.*;

public class DriveSubsystem extends SubsystemBase {
    final CANSparkMax frontLeftSparkMax;
    final CANSparkMax frontRightSparkMax;
    final CANSparkMax backLeftSparkMax;
    final CANSparkMax backRightSparkMax;

    final MecanumDriveKinematics mecanumKinematics;


    public DriveSubsystem() {
        frontLeftSparkMax = new CANSparkMax(kFrontLeftMotorControllerID, MotorType.kBrushless);
        frontRightSparkMax = new CANSparkMax(kFrontRightMotorControllerID, MotorType.kBrushless);
        backLeftSparkMax = new CANSparkMax(kBackLeftMotorControllerID, MotorType.kBrushless);
        backRightSparkMax = new CANSparkMax(kBackRightMotorControllerID, MotorType.kBrushless);

        frontLeftSparkMax.setInverted(false);
        backLeftSparkMax.setInverted(false);
        frontRightSparkMax.setInverted(true);
        backRightSparkMax.setInverted(true);
        
        configureMotorController(frontLeftSparkMax);
        configureMotorController(backLeftSparkMax);
        configureMotorController(frontRightSparkMax);
        configureMotorController(backRightSparkMax);

        //+x is forwards
        mecanumKinematics = new MecanumDriveKinematics(
            new Translation2d(kWheelbase/2, kTrackWidth/2),
            new Translation2d(kWheelbase/2, -kTrackWidth/2),
            new Translation2d(-kWheelbase/2, kTrackWidth/2),
            new Translation2d(-kWheelbase/2, -kTrackWidth/2));
    }

    void configureMotorController(CANSparkMax motorController) {
        motorController.setIdleMode(IdleMode.kCoast);
        //Config current limits?
        //Config velocity PID?
    }

    @Override
    public void periodic() {

    }

    public Command driveTeleopCommand (DoubleSupplier xSpeed, DoubleSupplier ySpeed, DoubleSupplier zRot) {
        return runEnd(() -> driveCartesian(filterLeftStick(xSpeed.getAsDouble(), ySpeed.getAsDouble()), filterAxis(zRot.getAsDouble())), () -> stopMotors())
        .withName("Drive Teleop");
    }

    Translation2d filterLeftStick(double xSpeed, double ySpeed) {
        //Convert to polar coordinates and saturate
        Translation2d xy = new Translation2d(xSpeed, ySpeed);
        //Convert to polar coordinates, apply filters, return
        return new Translation2d(filterAxis(Math.min(1, xy.getNorm())), 0).rotateBy(xy.getAngle());
    }

    double filterAxis(double value) {
        //Square and deadband input
        return MathUtil.applyDeadband(Math.abs(value) * Math.abs(value) * Math.signum(value), ControllerConstants.kInputDeadband);
    }

    void driveCartesian(Translation2d translation, double zRot) {
        driveCartesian(translation.getX(), translation.getY(), zRot);
    }

    void driveCartesian(double xSpeed, double ySpeed, double zRot) {
        //Make ChassisSpeeds obj
        //Convert to WheelSpeeds
        MecanumDriveWheelSpeeds wheelSpeeds = mecanumKinematics.toWheelSpeeds(new ChassisSpeeds(xSpeed, ySpeed, zRot));
        //Command motor controllers
        frontLeftSparkMax.set(wheelSpeeds.frontLeftMetersPerSecond);
        frontRightSparkMax.set(wheelSpeeds.frontRightMetersPerSecond);
        backLeftSparkMax.set(wheelSpeeds.rearLeftMetersPerSecond);
        backRightSparkMax.set(wheelSpeeds.rearRightMetersPerSecond);
    }

    void stopMotors() {
        frontLeftSparkMax.set(0);
        frontRightSparkMax.set(0);
        backLeftSparkMax.set(0);
        backRightSparkMax.set(0);
    }
}

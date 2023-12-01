package frc.robot;

import edu.wpi.first.math.util.Units;

public final class Constants {
    public static final class ControllerConstants {
        public static final int kDriverControllerID = 0;
        public static final double kInputDeadband = 0.02;
    }

    public static final class DrivetrainConstants {
        public static final int kFrontLeftMotorControllerID = 3;
        public static final int kFrontRightMotorControllerID = 4;
        public static final int kBackLeftMotorControllerID = 9;
        public static final int kBackRightMotorControllerID = 2;
        
        //Wheel distance front to back 19.490 (19.971+19.009/2) in
        //Wheel distance left to right 24.458 in
        public static final double kWheelbase = Units.inchesToMeters(19.490);
        public static final double kTrackWidth = Units.inchesToMeters(24.458);

    }

    public static final class CannonConstants {
        //CAN IDs of Talon SRXs that control solenoids that fire the cannons
        public static final int kLeftShooterSolenoidID = 6;
        public static final int kRightShooterSolenoidID = 5;

        //CAN IDs of Talon SRXs that control solenoids that load the intermediate air tanks
        public static final int kLeftPrimerSolenoidID = 8;
        public static final int kRightPrimerSolenoidID = 7;

        public static final int kPrimerPeakCurrentLimit = 3; //amps
        public static final int kShooterPeakCurrentLimit = 3;
        public static final int kPrimerContinuousCurrentLimit = 2;
        public static final int kShooterContinuousCurrentLimit = 2;
    }

    public static final class PivotConstants {
        public static final int kMotorControllerID = 10;
        public static final int kPeakCurrentLimit = 40; //these are safe numbers, modify if necessary
        public static final int kContinuousCurrentLimit = 35;
    }
}

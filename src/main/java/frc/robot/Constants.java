package frc.robot;

public final class Constants {
    public static final class ControllerConstants {
        public static final int kDriverControllerID = 0;
    }

    public static final class DrivetrainConstants {

    }

    public static final class CannonConstants {
        //CAN IDs of Talon SRXs that control solenoids that fire the cannons
        public static final int kLeftShooterSolenoidID = 5;
        public static final int kRightShooterSolenoidID = 6;

        //CAN IDs of Talon SRXs that control solenoids that load the intermediate air tanks
        public static final int kLeftPrimerSolenoidID = 7;
        public static final int kRightPrimerSolenoidID = 8;

        public static final int kPrimerPeakCurrentLimit = 3; //amps
        public static final int kShooterPeakCurrentLimit = 3;
        public static final int kPrimerContinuousCurrentLimit = 2;
        public static final int kShooterContinuousCurrentLimit = 2;
    }
}

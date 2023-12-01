package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.PivotConstants.*;

public class PivotSubsystem extends SubsystemBase {
    final TalonSRX motorController;
    
    public PivotSubsystem() {
        motorController = new TalonSRX(kMotorControllerID);
        motorController.configPeakCurrentLimit(kPeakCurrentLimit);
        motorController.configContinuousCurrentLimit(kContinuousCurrentLimit);
        motorController.setInverted(true);
    }

    @Override
    public void periodic() {

    }

    //[0, 1]
    public Command pivotCommand(double speed) {
        return new StartEndCommand(() -> motorController.set(ControlMode.PercentOutput, mapToPercentOutput(speed)), () -> motorController.set(ControlMode.PercentOutput, 0), this)
        .withName("Pivot Move");
    }

    private double mapToPercentOutput(double value) {
        return Math.max(0, Math.min(1, Math.abs(value))) * Math.signum(value);
    }
}

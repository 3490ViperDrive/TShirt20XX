// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;

import static frc.robot.Constants.ControllerConstants.*;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.CannonSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.PivotSubsystem;

public class RobotContainer {
  private final CommandXboxController m_driverController = new CommandXboxController(kDriverControllerID);
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final CannonSubsystem m_CannonSubsystem = new CannonSubsystem();
  private final PivotSubsystem m_PivotSubsystem = new PivotSubsystem();

  public RobotContainer() {
    m_driveSubsystem.setDefaultCommand(m_driveSubsystem.driveTeleopCommand(() -> m_driverController.getLeftX(), () -> -m_driverController.getLeftY(), () -> m_driverController.getRightX()));

    configureBindings();
  }

  private void configureBindings() {
    m_driverController.a().and(m_driverController.leftBumper()).onTrue(new PrintCommand("Load left barrel low"));
    m_driverController.b().and(m_driverController.leftBumper()).onTrue(new PrintCommand("Load left barrel mid"));
    m_driverController.y().and(m_driverController.leftBumper()).onTrue(new PrintCommand("Load left barrel high"));

    m_driverController.a().and(m_driverController.rightBumper()).onTrue(new PrintCommand("Load right barrel low"));
    m_driverController.b().and(m_driverController.rightBumper()).onTrue(new PrintCommand("Load right barrel mid"));
    m_driverController.y().and(m_driverController.rightBumper()).onTrue(new PrintCommand("Load right barrel high"));

    m_driverController.leftTrigger().onTrue(new PrintCommand("Shoot left"));
    m_driverController.rightTrigger().onTrue(new PrintCommand("Shoot right"));

    m_driverController.povUp().whileTrue(new PrintCommand("Raise shooter pivot"));
    m_driverController.povDown().whileTrue(new PrintCommand("Lower shooter pivot"));

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}

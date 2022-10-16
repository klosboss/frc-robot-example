// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.controllers.TankDriveController;
import frc.robot.subsystems.DriveTrain;

public class TankDrive extends CommandBase {
  private final DriveTrain driveTrain;
  private final TankDriveController controller;
  private boolean turbo;
  /** Creates a new TankDrive. */
  public TankDrive(DriveTrain driveTrain, TankDriveController controller) {
    this.driveTrain = driveTrain;
    this.controller = controller;
    this.turbo = false;
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double left = controller.getLeftPosition();
    double right = controller.getRightPosition();

    if (!turbo) {
      left = left * Constants.TANK_DRIVE_LIMITER_VALUE;
      right = right * Constants.TANK_DRIVE_LIMITER_VALUE;
    }
    
    this.driveTrain.moveLeft(left * left);
    this.driveTrain.moveRight(right * right);
  }

  public void activateTurbo() {
    this.turbo = true;
  }

  public void deactivateTurbo() {
    this.turbo = false;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.driveTrain.moveLeft(0.0);
    this.driveTrain.moveRight(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

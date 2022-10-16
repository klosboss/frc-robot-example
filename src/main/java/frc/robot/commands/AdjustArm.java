// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.controllers.AdjustArmController;
import frc.robot.subsystems.Arm;

public class AdjustArm extends CommandBase {
  private final Arm arm;
  private final AdjustArmController controller;

  /** Creates a new AdjustArm. */
  public AdjustArm(Arm arm, AdjustArmController controller) {
    this.arm = arm;
    this.controller = controller;
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (controller.shouldRaise()) {
      arm.raise();
    } else if (controller.shouldLower()) {
      arm.lower();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.controllers.AdjustArmController;
import frc.robot.subsystems.ArmIntake;

public class AdjustArm extends CommandBase {
  private final ArmIntake armIntake;
  private final AdjustArmController controller;
  /** Creates a new AdjustArm. */
  public AdjustArm(ArmIntake armIntake, AdjustArmController controller) {
    this.armIntake = armIntake;
    this.controller = controller;
    addRequirements(armIntake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean isGoingUp = controller.isGoingUp();
    boolean isGoingDown = controller.isGoingDown();
    if (isGoingUp) {
      armIntake.raiseArm();
    } else if (isGoingDown) {
      armIntake.lowerArm();
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

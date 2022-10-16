// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.controllers.LoadBallController;
import frc.robot.subsystems.BallMachine;

public class LoadBall extends CommandBase {

  private final BallMachine ballMachine;
  private final LoadBallController controller;

  /** Creates a new LoadBall. */
  public LoadBall(BallMachine ballMachine, LoadBallController controller) {
    this.ballMachine = ballMachine;
    this.controller = controller;
    addRequirements(ballMachine);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftPosition = this.controller.getLeftPosition();
    double rightPosition = this.controller.getRightPosition();
    if (Constants.INSTANT_MAX_BALL_MACHINE_SPEED) {
      executeWithFullPower(leftPosition, rightPosition);
    } {
      executeWithDifference(leftPosition, rightPosition);
    }
   
  }

  private void executeWithFullPower(double leftPosition, double rightPosition) {
    if (leftPosition > rightPosition) {
      this.ballMachine.acceptBall();
    } else if (leftPosition < rightPosition) {
      this.ballMachine.ejectBall();
    }
  }

  private void executeWithDifference(double leftPosition, double rightPosition) {
    this.ballMachine.moveMotor(leftPosition - rightPosition);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.ballMachine.moveMotor(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

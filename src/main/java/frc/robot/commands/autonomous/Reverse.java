// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallMachine;
import frc.robot.subsystems.DriveTrain;

public class Reverse extends CommandBase {
  private static final double COMMAND_DURATION = 5.0;

  private final DriveTrain driveTrain;
  private final BallMachine ballMachine;
  private final Timer timer;
  
  /** Creates a new Reverse. */
  public Reverse(DriveTrain driveTrain, BallMachine ballMachine) {
    this(driveTrain, ballMachine, new Timer());
  }

  public Reverse(DriveTrain driveTrain, BallMachine ballMachine, Timer timer) {
    this.driveTrain = driveTrain;
    this.ballMachine = ballMachine;
    this.timer = timer;
    addRequirements(driveTrain, ballMachine);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    ballMachine.stop();
    driveTrain.moveLeft(-0.5);
    driveTrain.moveRight(-0.505);
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    timer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.hasElapsed(COMMAND_DURATION);
  }
}

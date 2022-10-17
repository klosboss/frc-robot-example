// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallMachine;

public class EjectBalls extends CommandBase {
  private final BallMachine ballMachine;
  private final double duration = 5.0;

  private final Timer timer = new Timer();
  
  /** Creates a new EjectBalls. */
  public EjectBalls(BallMachine ballMachine) {
    this.ballMachine = ballMachine;
    addRequirements(ballMachine);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.ballMachine.ejectBall();
    withTimeout(duration);
    
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
    return timer.hasElapsed(duration);
  }
}

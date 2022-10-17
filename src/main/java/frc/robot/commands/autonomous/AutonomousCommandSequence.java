// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.BallMachine;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomousCommandSequence extends SequentialCommandGroup {
  private final DriveTrain driveTrain;
  private final BallMachine ballMachine;
  /** Creates a new AutonomousCommandSequence. */
  public AutonomousCommandSequence(DriveTrain driveTrain, BallMachine ballMachine) {
    this.driveTrain = driveTrain;
    this.ballMachine = ballMachine;
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new EjectBalls(ballMachine), 
      new Reverse(driveTrain, ballMachine),
      new InstantCommand(driveTrain::stop, driveTrain));
  }
}

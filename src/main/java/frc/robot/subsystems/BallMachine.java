// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BallMachine extends SubsystemBase {
  private final WPI_VictorSPX intakeMotor;
  /** Creates a new BallMachine. */
  public BallMachine() {
    this(new WPI_VictorSPX(Constants.ARM_INTAKE_MOTOR_ID));
  }

  public BallMachine(WPI_VictorSPX intakeMotor) {
    this.intakeMotor = intakeMotor;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void acceptBall() {
    this.moveMotor(1.0);
  }

  public void ejectBall() {
    this.moveMotor(-1.0);
  }

  public void stop() {
    this.moveMotor(0.0);
  }

  public void moveMotor(double speed) {
    intakeMotor.set(ControlMode.PercentOutput, speed);
  }
}

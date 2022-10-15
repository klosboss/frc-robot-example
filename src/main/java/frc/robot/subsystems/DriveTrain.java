// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  private final TalonSRX motorLeft1 = new TalonSRX(Constants.MOTOR_LEFT_1_ID);
  private final TalonSRX motorLeft2 = new TalonSRX(Constants.MOTOR_LEFT_2_ID);
  private final TalonSRX motorRight1 = new TalonSRX(Constants.MOTOR_RIGHT_1_ID);
  private final TalonSRX motorRight2 = new TalonSRX(Constants.MOTOR_RIGHT_2_ID);

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    motorRight1.setInverted(true);
    motorRight2.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void moveLeft(double speedPercentage) {
    motorLeft1.set(ControlMode.PercentOutput, speedPercentage);
    motorLeft2.set(ControlMode.PercentOutput, speedPercentage);
  }

  public void moveRight(double speedPercentage) {
    motorRight1.set(ControlMode.PercentOutput, speedPercentage);
    motorRight2.set(ControlMode.PercentOutput, speedPercentage);
  }

}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {

  private final WPI_VictorSPX armMotor = new WPI_VictorSPX(Constants.ARM_MOTOR_ID);
  private final DigitalInput arumUpSensor = new DigitalInput(Constants.ARM_UP_SENSOR_ID);
  private final DigitalInput armDownSensor = new DigitalInput(Constants.ARM_DOWN_SENSOR_ID);
  
  /** Creates a new Arm. */
  public Arm() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void raise() {
    if (!arumUpSensor.get()){
      armMotor.set(ControlMode.PercentOutput, Constants.ARM_UP_MOTOR_SPEED_PERCENTAGE);
    }
  }

  public void lower() {
    if (!armDownSensor.get()) {
      armMotor.set(ControlMode.PercentOutput, Math.abs(Constants.ARM_DOWN_MOTOR_SPEED_PERCENTAGE) * -1.0);
    }
  }

  /**
   * Called when nothing to do. Ensures Arm stops moving.
   */
  public void stop() {
    armMotor.set(ControlMode.PercentOutput, 0.0);
  }
}

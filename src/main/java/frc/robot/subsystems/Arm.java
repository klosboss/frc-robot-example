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

  private final WPI_VictorSPX armMotor;
  private final DigitalInput armUpSensor;
  private final DigitalInput armDownSensor;
  
  /** Creates a new Arm. */
  public Arm() {
    this(new WPI_VictorSPX(Constants.ARM_MOTOR_ID),
            new DigitalInput(Constants.ARM_UP_SENSOR_ID),
            new DigitalInput(Constants.ARM_DOWN_SENSOR_ID));
  }

  public Arm(WPI_VictorSPX armMotor, DigitalInput armUpSensor, DigitalInput armDownSensor) {
    this.armMotor = armMotor;
    this.armUpSensor = armUpSensor;
    this.armDownSensor = armDownSensor;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void raise() {
    if (!armUpSensor.get()){
      this.moveArm(Constants.getArmUpMotorSpeedPercentage());
    }
  }

  public void lower() {
    if (!armDownSensor.get()) {
      this.moveArm(Math.abs(Constants.getArmDownMotorSpeedPercentage()) * -1.0);
    }
  }

  /**
   * Called when nothing to do. Ensures Arm stops moving.
   */
  public void stop() {
    this.moveArm(0.0);
  }

  private void moveArm(double speed) {
    armMotor.set(ControlMode.PercentOutput, speed);
  }
}

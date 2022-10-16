// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick.ButtonType;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    /* Robot Identifiers */
    public static final int MOTOR_LEFT_1_ID = 3;
    public static final int MOTOR_LEFT_2_ID = 4;
    public static final int MOTOR_RIGHT_1_ID = 1;
    public static final int MOTOR_RIGHT_2_ID = 2;
    public static final int ARM_MOTOR_ID = 6;

    /* HCI Identifiers */
    public static final int LEFT_TANK_JOYSTICK_USB_PORT = 0;
    public static final int RIGHT_TANK_JOYSTICK_USB_PORT = 1;
    public static final int XBOX_CONTROLLER_USB_PORT = 2;
    public static final int TANK_JOYSTICK_AXIS = 0;
    public static final int TANK_JOYSTICK_TURBO_BUTTON_ID = ButtonType.kTrigger.value;


    public static final double TANK_DRIVE_LIMITER_VALUE = 0.9;
    public static final double ARM_UP_MOTOR_SPEED_PERCENTAGE = 0.5;
    public static final double ARM_DOWN_MOTOR_SPEED_PERCENTAGE = 0.3;
    
}

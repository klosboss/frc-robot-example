// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    /* Robot Identifiers - CAN IDs */
    public static final int MOTOR_LEFT_1_ID = 3;
    public static final int MOTOR_LEFT_2_ID = 4;
    public static final int MOTOR_RIGHT_1_ID = 1;
    public static final int MOTOR_RIGHT_2_ID = 2;
    public static final int ARM_MOTOR_ID = 6;
    public static final int ARM_INTAKE_MOTOR_ID = 5;

    /* Robot Identifiers - DIO IDs */
    public static final int ARM_UP_SENSOR_ID = 0;
    public static final int ARM_DOWN_SENSOR_ID = 1;

    /* HCI Identifiers */
    public static final int LEFT_TANK_JOYSTICK_USB_PORT = 1;
    public static final int RIGHT_TANK_JOYSTICK_USB_PORT = 0;
    public static final int XBOX_CONTROLLER_USB_PORT = 2;
    public static final int TANK_JOYSTICK_AXIS = 1;
    public static final int TANK_JOYSTICK_TURBO_BUTTON_ID = ButtonType.kTrigger.value;


    private static final String TANK_DRIVE_LIMIT_KEY = "Tank Drive Limit";
    private static final double TANK_DRIVE_LIMITER_VALUE = 0.9;

    private static final String ARM_UP_SPEED_KEY = "Arm Up Speed";
    private static final double ARM_UP_MOTOR_SPEED_PERCENTAGE = 0.5;

    private static final String ARM_DOWN_SPEED_KEY = "Arm Down Speed";
    private static final double ARM_DOWN_MOTOR_SPEED_PERCENTAGE = 0.3;

    private static final String INSTANT_MAX_BALL_MACHINE_SPEED_KEY = "Full Ball Speed";
    private static final boolean INSTANT_MAX_BALL_MACHINE_SPEED = true;

    public static void initializeSmartDashboardConstants() {
        SmartDashboard.putNumber(TANK_DRIVE_LIMIT_KEY, TANK_DRIVE_LIMITER_VALUE);
        SmartDashboard.putNumber(ARM_UP_SPEED_KEY, ARM_UP_MOTOR_SPEED_PERCENTAGE);
        SmartDashboard.putNumber(ARM_DOWN_SPEED_KEY, ARM_DOWN_MOTOR_SPEED_PERCENTAGE);
        SmartDashboard.putBoolean(INSTANT_MAX_BALL_MACHINE_SPEED_KEY, INSTANT_MAX_BALL_MACHINE_SPEED);

    }

    public static double getTankDriveLimiterValue() {
        return SmartDashboard.getNumber(TANK_DRIVE_LIMIT_KEY, TANK_DRIVE_LIMITER_VALUE);
    }

    public static double getArmUpMotorSpeedPercentage() {
        return SmartDashboard.getNumber(ARM_UP_SPEED_KEY, ARM_UP_MOTOR_SPEED_PERCENTAGE);
    }

    public static double getArmDownMotorSpeedPercentage() {
        return SmartDashboard.getNumber(ARM_DOWN_SPEED_KEY, ARM_DOWN_MOTOR_SPEED_PERCENTAGE);
    }

    public static boolean getInstantMaxBallMachineSpeed() {
        return SmartDashboard.getBoolean(INSTANT_MAX_BALL_MACHINE_SPEED_KEY, INSTANT_MAX_BALL_MACHINE_SPEED);
    }
}

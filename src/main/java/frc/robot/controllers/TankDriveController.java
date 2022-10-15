package frc.robot.controllers;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants;

public class TankDriveController {

    private final Joystick leftJoystick;
    private final Joystick rightJoystick;

    public TankDriveController(Joystick leftJoystick, Joystick rightJoystick) {
        this.leftJoystick = leftJoystick;
        this.rightJoystick = rightJoystick;
    }

    public double getLeftPosition() {
        return leftJoystick.getRawAxis(Constants.TANK_JOYSTICK_AXIS);
    }

    public double getRightPosition() {
        return rightJoystick.getRawAxis(Constants.TANK_JOYSTICK_AXIS);
    }
    
}

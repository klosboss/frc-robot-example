package frc.robot.controllers;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TankDriveControllerTest {
    @Mock
    private Joystick leftJoystick;
    @Mock
    private Joystick rightJoystick;

    private TankDriveController controller;

    @Before
    public void init() {
        controller = new TankDriveController(leftJoystick, rightJoystick);
    }

    @Test
    public void givenLeftJoystickRawAxisIsZero_whenGetLeftPosition_thenReturnZero() {
        when(leftJoystick.getRawAxis(Constants.TANK_JOYSTICK_AXIS)).thenReturn(0.0);
        assertEquals(0.0, controller.getLeftPosition(), 0.0);
    }

    @Test
    public void givenLeftJoystickRawAxisIsNonZero_whenGetLeftPosition_thenReturnTheNonZeroValueAndNegate() {
        when(leftJoystick.getRawAxis(Constants.TANK_JOYSTICK_AXIS)).thenReturn(1.0);
        assertEquals(-1.0, controller.getLeftPosition(), 0.0);
    }

    @Test
    public void givenRightJoystickRawAxisIsZero_whenGetRightPosition_thenReturnZero() {
        when(rightJoystick.getRawAxis(Constants.TANK_JOYSTICK_AXIS)).thenReturn(0.0);
        assertEquals(0.0, controller.getRightPosition(), 0.0);
    }

    @Test
    public void givenRightJoystickRawAxisIsNonZero_whenGetRightPosition_thenReturnTheNonZeroValueAndNegate() {
        when(rightJoystick.getRawAxis(Constants.TANK_JOYSTICK_AXIS)).thenReturn(1.0);
        assertEquals(-1.0, controller.getRightPosition(), 0.0);
    }
}
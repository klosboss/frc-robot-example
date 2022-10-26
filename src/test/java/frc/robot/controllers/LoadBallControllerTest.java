package frc.robot.controllers;

import edu.wpi.first.wpilibj.XboxController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoadBallControllerTest {

    @Mock
    private XboxController xBoxController;
    @InjectMocks
    private LoadBallController controller;

    @Test
    public void givenXboxLeftTriggerAxisIsZero_whenGetLeftPosition_thenReturnZero() {
        when(xBoxController.getLeftTriggerAxis()).thenReturn(0.0);
        assertEquals(0.0, controller.getLeftPosition(), 0.0);
    }

    @Test
    public void givenXboxLeftTriggerAxisIsNonZero_whenGetLeftPosition_thenReturnTheNonZeroValue() {
        when(xBoxController.getLeftTriggerAxis()).thenReturn(1.0);
        assertEquals(1.0, controller.getLeftPosition(), 0.0);
    }

    @Test
    public void givenXboxRightTriggerAxisIsZero_whenGetRightPosition_thenReturnZero() {
        when(xBoxController.getRightTriggerAxis()).thenReturn(0.0);
        assertEquals(0.0, controller.getRightPosition(), 0.0);
    }

    @Test
    public void givenXboxRightTriggerAxisIsNonZero_whenGetRightPosition_thenReturnTheNonZeroValue() {
        when(xBoxController.getRightTriggerAxis()).thenReturn(1.0);
        assertEquals(1.0, controller.getRightPosition(), 0.0);
    }
}
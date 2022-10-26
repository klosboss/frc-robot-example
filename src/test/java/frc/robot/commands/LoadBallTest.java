package frc.robot.commands;

import frc.robot.controllers.LoadBallController;
import frc.robot.subsystems.BallMachine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoadBallTest {

    @Mock
    private BallMachine ballMachine;
    @Mock
    private LoadBallController controller;


    @Test
    public void givenBothLeftAndRightHaveZeroPosition_whenExecute_thenMoveMotorWithZeroSpeed() {
        LoadBall command = new LoadBall(ballMachine, controller, false);
        when(controller.getLeftPosition()).thenReturn(0.0);
        when(controller.getRightPosition()).thenReturn(0.0);
        command.execute();
        verify(ballMachine).moveMotor(0.0);
    }

    @Test
    public void givenLeftIsPositiveAndRightIsZero_whenExecute_thenMoveMotorInPositiveDirection() {
        LoadBall command = new LoadBall(ballMachine, controller, false);
        when(controller.getLeftPosition()).thenReturn(0.75);
        when(controller.getRightPosition()).thenReturn(0.0);
        command.execute();
        verify(ballMachine).moveMotor(0.75);
    }

    @Test
    public void givenRightPositionIsGreaterThanLeftPosition_whenExecute_thenMoveMotorInNegativeDirection() {
        LoadBall command = new LoadBall(ballMachine, controller, false);
        when(controller.getLeftPosition()).thenReturn(0.75);
        when(controller.getRightPosition()).thenReturn(1.0);
        command.execute();
        verify(ballMachine).moveMotor(-0.25);
    }

    @Test
    public void givenLeftAndRightPositionAreEqual_whenExecute_thenMoveMotorWithZeroSpeed() {
        LoadBall command = new LoadBall(ballMachine, controller, false);
        when(controller.getLeftPosition()).thenReturn(0.75);
        when(controller.getRightPosition()).thenReturn(0.75);
        command.execute();
        verify(ballMachine).moveMotor(0.0);
    }

    @Test
    public void givenSetMaxAndBothLeftAndRightHaveZeroPosition_whenExecute_thenStopBallMachine() {
        LoadBall command = new LoadBall(ballMachine, controller, true);
        when(controller.getLeftPosition()).thenReturn(0.0);
        when(controller.getRightPosition()).thenReturn(0.0);
        command.execute();
        verify(ballMachine).stop();
    }

    @Test
    public void givenSetMaxAndLeftIsPositiveAndRightIsZero_whenExecute_thenMoveMotorInPositiveDirection() {
        LoadBall command = new LoadBall(ballMachine, controller, true);
        when(controller.getLeftPosition()).thenReturn(0.75);
        when(controller.getRightPosition()).thenReturn(0.0);
        command.execute();
        verify(ballMachine).acceptBall();
    }

    @Test
    public void givenSetMaxAndRightPositionIsGreaterThanLeftPosition_whenExecute_thenMoveMotorInNegativeDirection() {
        LoadBall command = new LoadBall(ballMachine, controller, true);
        when(controller.getLeftPosition()).thenReturn(0.75);
        when(controller.getRightPosition()).thenReturn(1.0);
        command.execute();
        verify(ballMachine).ejectBall();
    }

    @Test
    public void givenSetMaxAndLeftAndRightPositionAreEqual_whenExecute_thenStopBallMachine() {
        LoadBall command = new LoadBall(ballMachine, controller, true);
        when(controller.getLeftPosition()).thenReturn(0.75);
        when(controller.getRightPosition()).thenReturn(0.75);
        command.execute();
        verify(ballMachine).stop();
    }
}
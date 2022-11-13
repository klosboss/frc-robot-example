package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.controllers.TankDriveController;
import frc.robot.subsystems.DriveTrain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TankDriveTest {
    @Mock
    private DriveTrain driveTrain;
    @Mock
    private TankDriveController controller;
    @InjectMocks
    private TankDrive tankDrive;

    @Test
    public void givenNoTurboAndLeft50Percent_whenExecute_thenDriveTrainMoveLeftIs25Percent() {
        when(controller.getLeftPosition()).thenReturn(0.5);
        tankDrive.execute();
        double expected = 0.5 * Constants.getTankDriveLimiterValue();
        expected = expected * expected;
        verify(driveTrain).moveLeft(expected);
    }

    @Test
    public void givenTurboAndLeft50Percent_whenExecute_thenDriveTrainMoveLeftIs25Percent() {
        when(controller.getLeftPosition()).thenReturn(0.5);
        tankDrive.activateTurbo();
        tankDrive.execute();
        verify(driveTrain).moveLeft(0.25);
    }

    @Test
    public void givenNoTurboAndLeft100Percent_whenExecute_thenDriveTrainMoveLeftIsSquareOfLimiterValue() {
        when(controller.getLeftPosition()).thenReturn(1.0);
        tankDrive.execute();
        verify(driveTrain).moveLeft(Constants.getTankDriveLimiterValue() * Constants.getTankDriveLimiterValue());
    }

    @Test
    public void givenTurboAndLeft100Percent_whenExecute_thenDriveTrainMoveLeftIs100Percent() {
        when(controller.getLeftPosition()).thenReturn(1.0);
        tankDrive.activateTurbo();
        tankDrive.execute();
        verify(driveTrain).moveLeft(1.0);
    }

    @Test
    public void givenNoTurboAndRight50Percent_whenExecute_thenDriveTrainMoveLeftIs25Percent() {
        when(controller.getRightPosition()).thenReturn(0.5);
        tankDrive.execute();
        double expected = 0.5 * Constants.getTankDriveLimiterValue();
        expected = expected * expected;
        verify(driveTrain).moveRight(expected);
    }

    @Test
    public void givenTurboAndRight50Percent_whenExecute_thenDriveTrainMoveLeftIs25Percent() {
        when(controller.getRightPosition()).thenReturn(0.5);
        tankDrive.activateTurbo();
        tankDrive.execute();
        verify(driveTrain).moveRight(0.25);
    }

    @Test
    public void givenNoTurboAndRight100Percent_whenExecute_thenDriveTrainMoveLeftIsSquareOfLimiterValue() {
        when(controller.getRightPosition()).thenReturn(1.0);
        tankDrive.execute();
        verify(driveTrain).moveRight(Constants.getTankDriveLimiterValue() * Constants.getTankDriveLimiterValue());
    }

    @Test
    public void givenTurboAndRight100Percent_whenExecute_thenDriveTrainMoveLeftIs100Percent() {
        when(controller.getRightPosition()).thenReturn(1.0);
        tankDrive.activateTurbo();
        tankDrive.execute();
        verify(driveTrain).moveRight(1.0);
    }

    @Test
    public void whenEnd_thenMoveLeftAndRightAreZero() {
        tankDrive.end(true);
        verify(driveTrain).moveLeft(0.0);
        verify(driveTrain).moveRight(0.0);
    }

    @Test
    public void givenNoTurboAndLeftAndRightAre50Percent_whenExecute_thenMoveBackwards() {
        when(controller.getLeftPosition()).thenReturn(-0.5);
        when(controller.getRightPosition()).thenReturn(-0.5);
        tankDrive.activateTurbo();
        tankDrive.execute();
        verify(driveTrain).moveLeft(-0.25);
        verify(driveTrain).moveRight(-0.25);
    }
}
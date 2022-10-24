package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DriveTrainTest {

    @Mock
    private WPI_VictorSPX motorLeft1;
    @Mock
    private WPI_VictorSPX motorLeft2;
    @Mock
    private WPI_VictorSPX motorRight1;
    @Mock
    private WPI_VictorSPX motorRight2;

    private DriveTrain driveTrain;

    @Before
    public void init() {
        driveTrain = new DriveTrain(motorLeft1, motorLeft2, motorRight1, motorRight2);
    }

    @Test
    public void givenPositiveSpeedPercent_whenMoveLeft_thenExpectLeftMotorsWithPositiveSpeedPercent() {
        driveTrain.moveLeft(0.75);
        verifyLeftMotors(0.75);
        verifyRightMotorsNeverCalled();
    }

    @Test
    public void givenNegativeSpeedPercent_whenMoveLeft_thenExpectLeftMotorsWithNegativeSpeedPercent() {
        driveTrain.moveLeft(-0.75);
        verifyLeftMotors(-0.75);
        verifyRightMotorsNeverCalled();
    }

    @Test
    public void givenPositiveSpeedPercent_whenMoveRight_thenExpectRightMotorsWithPositiveSpeedPercent() {
        driveTrain.moveRight(0.75);
        verifyRightMotors(0.75);
        verifyLeftMotorsNeverCalled();
    }

    @Test
    public void givenNegativeSpeedPercent_whenMoveRight_thenExpectRightMotorsWithNegativeSpeedPercent() {
        driveTrain.moveRight(-0.75);
        verifyRightMotors(-0.75);
        verifyLeftMotorsNeverCalled();
    }

    private void verifyLeftMotors(double value) {
        verify(motorLeft1).set(ControlMode.PercentOutput, value);
        verify(motorLeft2).set(ControlMode.PercentOutput, value);
    }

    private void verifyLeftMotorsNeverCalled() {
        verify(motorLeft1, never()).set(any(ControlMode.class), anyDouble());
        verify(motorLeft2, never()).set(any(ControlMode.class), anyDouble());
    }

    private void verifyRightMotors(double value) {
        verify(motorRight1).set(ControlMode.PercentOutput, value);
        verify(motorRight2).set(ControlMode.PercentOutput, value);
    }

    private void verifyRightMotorsNeverCalled() {
        verify(motorRight1, never()).set(any(ControlMode.class), anyDouble());
        verify(motorRight2, never()).set(any(ControlMode.class), anyDouble());
    }

}
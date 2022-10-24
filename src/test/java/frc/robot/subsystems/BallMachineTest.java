package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BallMachineTest {

    @Mock
    private WPI_VictorSPX intakeMotor;

    @InjectMocks
    private BallMachine ballMachine;
    
    @Test
    public void whenEjectBall_thenExpectIntakeMotorNegative100Percent() {
        ballMachine.ejectBall();
        verify(intakeMotor).set(ControlMode.PercentOutput, -1.0);
    }

    @Test
    public void whenAcceptBall_thenExpectIntakeMotorPositive100Percent() {
        ballMachine.acceptBall();
        verify(intakeMotor).set(ControlMode.PercentOutput, 1.0);
    }

    @Test
    public void whenStop_thenExpectIntakeMotorZeroPercent() {
        ballMachine.stop();
        verify(intakeMotor).set(ControlMode.PercentOutput, 0.0);
    }

    @Test
    public void givenSpeedPositive50Percent_whenMoveMotor_thenExpectIntakeMotorPositive50Percent() {
        ballMachine.moveMotor(0.5);
        verify(intakeMotor).set(ControlMode.PercentOutput, 0.5);
    }

    @Test
    public void givenSpeedNegative50Percent_whenMoveMotor_thenExpectIntakeMotorNegative50Percent() {
        ballMachine.moveMotor(-0.5);
        verify(intakeMotor).set(ControlMode.PercentOutput, -0.5);
    }
}

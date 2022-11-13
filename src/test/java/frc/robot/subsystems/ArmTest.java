package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArmTest {

    @Mock
    private WPI_VictorSPX armMotor;
    @Mock
    private DigitalInput armUpSensor;
    @Mock
    private DigitalInput armDownSensor;

    private Arm arm;

    @Before
    public void init() {
        arm = new Arm(armMotor, armUpSensor, armDownSensor);
    }

    @Test
    public void givenArmUpSensorClosed_whenRaise_thenDoNothing() {
        when(armUpSensor.get()).thenReturn(false);
        arm.raise();
        verify(armMotor, never()).set(any(ControlMode.class), anyDouble());
    }

    @Test
    public void givenArmUpSensorOpen_whenRaise_thenRaiseArm() {
        when(armUpSensor.get()).thenReturn(true);
        arm.raise();
        verify(armMotor).set(ControlMode.PercentOutput, Constants.getArmUpMotorSpeedPercentage());
    }

    @Test
    public void givenArmDownSensorClosed_whenLower_thenDoNothing() {
        when(armDownSensor.get()).thenReturn(false);
        arm.lower();
        verify(armMotor, never()).set(any(ControlMode.class), anyDouble());
    }

    @Test
    public void givenArmDownSensorOpen_whenRaise_thenLowerArm() {
        when(armDownSensor.get()).thenReturn(true);
        arm.lower();
        verify(armMotor).set(ControlMode.PercentOutput, Math.abs(Constants.getArmDownMotorSpeedPercentage()) * -1.0);
    }

    @Test
    public void whenStop_thenSetArmMotorToZero() {
        arm.stop();
        verify(armMotor).set(ControlMode.PercentOutput, 0.0);
    }
}
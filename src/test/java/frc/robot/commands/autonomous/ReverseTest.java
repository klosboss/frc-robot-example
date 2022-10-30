package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.BallMachine;
import frc.robot.subsystems.DriveTrain;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReverseTest {

    @Mock
    private DriveTrain driveTrain;
    @Mock
    private BallMachine ballMachine;
    @Mock
    private Timer timer;
    private Reverse reverse;

    @Before
    public void init() {
        reverse = new Reverse(driveTrain, ballMachine, timer);
    }

    @Test
    public void givenInitialize_thenStopBallMachineAndMoveBackwardsAndRestartTimer() {
        reverse.initialize();
        verify(ballMachine).stop();
        verify(driveTrain).moveLeft(-0.5);
        verify(driveTrain).moveRight(-0.505);
        verify(timer).reset();
        verify(timer).start();
    }

    @Test
    public void givenInterruptedTrue_whenEnd_thenStopTimer() {
        reverse.end(true);
        verify(timer).stop();
    }

    @Test
    public void givenInterruptedFalse_whenEnd_thenStopTimer() {
        reverse.end(false);
        verify(timer).stop();
    }

    @Test
    public void givenDurationHasNotElapsed_whenIsFinished_thenReturnFalse() {
        when(timer.hasElapsed(5.0)).thenReturn(false);
        assertFalse(reverse.isFinished());
    }

    @Test
    public void givenDurationHasElapsed_whenIsFinished_thenReturnTrue() {
        when(timer.hasElapsed(5.0)).thenReturn(true);
        assertTrue(reverse.isFinished());
    }

}
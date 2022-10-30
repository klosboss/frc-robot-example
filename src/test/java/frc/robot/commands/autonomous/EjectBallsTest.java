package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.BallMachine;
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
public class EjectBallsTest {

    @Mock
    private BallMachine ballMachine;
    @Mock
    private Timer timer;
    private EjectBalls ejectBalls;

    @Before
    public void init() {
        ejectBalls = new EjectBalls(ballMachine, timer);
    }

    @Test
    public void whenInitialize_thenEjectBallsAndRestartTimer() {
        ejectBalls.initialize();
        verify(ballMachine).ejectBall();
        verify(timer).reset();
        verify(timer).start();
    }

    @Test
    public void givenInterruptedTrue_whenEnd_thenStopTimer() {
        ejectBalls.end(true);
        verify(timer).stop();
    }

    @Test
    public void givenInterruptedFalse_whenEnd_thenStopTimer() {
        ejectBalls.end(false);
        verify(timer).stop();
    }

    @Test
    public void givenDurationHasNotElapsed_whenIsFinished_thenReturnFalse() {
        when(timer.hasElapsed(5.0)).thenReturn(false);
        assertFalse(ejectBalls.isFinished());
    }

    @Test
    public void givenDurationHasElapsed_whenIsFinished_thenReturnTrue() {
        when(timer.hasElapsed(5.0)).thenReturn(true);
        assertTrue(ejectBalls.isFinished());
    }
}
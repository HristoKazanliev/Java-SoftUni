package P6TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import p06_TirePressureMonitoringSystem.Alarm;
import p06_TirePressureMonitoringSystem.Sensor;

public class TirePressureMonitoringSystemTest {
    private static final double lowerValue = 16;
    private static final double highValue = 22;
    private static final double normalValue = 20;
    private Alarm alarm;
    private Sensor sensor;

    @Before
    public void setUp() {
        sensor = Mockito.mock(Sensor.class);
        alarm = new Alarm(sensor);
    }
    @Test
    public void checkMethodShouldReturnTrueWithLowerValue() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(lowerValue);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }
    @Test
    public void checkMethodShouldReturnTrueWithHigherValue() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(highValue);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }
    @Test
    public void checkMethodShouldReturnFalseWithHigherValue() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(normalValue);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
}

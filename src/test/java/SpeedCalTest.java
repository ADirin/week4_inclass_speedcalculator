import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpeedCalTest {
    SpeedCal speedCal=new SpeedCal();

    @Test
    void TestKilometersToMiles() {
        double miles = speedCal.kilometersToMiles(10);
        assertEquals(6.21371, miles, 0.0001, "10 km should be about 6.21371 miles");
    }

    @Test
    void testMilesToKilometers() {
        double km = speedCal.milesToKilometers(10);
        assertEquals(16.0934, km, 0.0001, "10 miles should be about 16.0934 km");
    }

    @Test
    void testCalculateSpeed() {
        double speed = speedCal.calculateSpeed(100, 2);
        assertEquals(50.0, speed, 0.0001, "Speed should be distance/time");

    }

    @Test
    void testCalculateSpeedWithZeroTime() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            speedCal.calculateSpeed(100, 0);
        });
        assertEquals("Time must be greater than zero.", exception.getMessage());
    }
}
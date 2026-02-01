import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SpeedCalculatorTest {

    @Test
    void testConvertKilometersToMiles() {
        double kilometers = 10.0;
        double expectedMiles = 6.2;

        double actualMiles = SpeedCalculator.convertKilometersToMiles(kilometers);

        assertEquals(expectedMiles, actualMiles, 0.0001);
    }

    @Test
    void testConvertMilesToKilometers() {
        double miles = 6.2;
        double expectedKilometers = 10.0;

        double actualKilometers = SpeedCalculator.convertMilesToKilometers(miles);

        assertEquals(expectedKilometers, actualKilometers, 0.0001);
    }

    @Test
    void testCalculateSpeedValidInput() {
        double distance = 100.0; // km
        double time = 2.0;       // hours
        double expectedSpeed = 50.0;

        double actualSpeed = SpeedCalculator.calculateSpeed(distance, time);

        assertEquals(expectedSpeed, actualSpeed, 0.0001);
    }

    @Test
    void testCalculateSpeedThrowsExceptionWhenTimeIsZero() {
        double distance = 100.0;
        double time = 0.0;

        assertThrows(
                IllegalArgumentException.class,
                () -> SpeedCalculator.calculateSpeed(distance, time)
        );
    }

    @Test
    void testCalculateSpeedThrowsExceptionWhenTimeIsNegative() {
        double distance = 50.0;
        double time = -2.0;

        assertThrows(
                IllegalArgumentException.class,
                () -> SpeedCalculator.calculateSpeed(distance, time)
        );
    }
}

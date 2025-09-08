import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    // Runs ONCE before all tests (must be static)
    @BeforeAll
    static void setupAll() {
        System.out.println(">>> @BeforeAll - Runs once before all tests");
    }

    // Runs BEFORE each test
    @BeforeEach
    void setup() {
        calculator = new Calculator();
        System.out.println(">>> @BeforeEach - Runs before each test");
    }

    // A TEST method
    @Test
    void testAddition() {
        System.out.println(">>> @Test - Running testAddition");
        assertEquals(5, calculator.addMe(2, 3));
    }

    // Another TEST method
    @Test
    void testSubtraction() {
        System.out.println(">>> @Test - Running testSubtraction");
        assertEquals(1, calculator.subtractMe(3, 2));
    }
    @Test
    void testMultiply() {
        assertEquals(20, calculator.multiplyMe(4, 5), "4 * 5 should equal 20");
    }

    @Test
    void testDivide() {
        assertEquals(2, calculator.divideMe(10, 5), "10 / 5 should equal 2");
    }

    @Test
    void testDivideByZeroThrowsException() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divideMe(10, 0);
        });
        assertEquals("Divide by zero", exception.getMessage());
    }
    // Runs AFTER each test
    @AfterEach
    void tearDown() {
        System.out.println(">>> @AfterEach - Runs after each test");
    }

    // Runs ONCE after all tests (must be static)
    @AfterAll
    static void tearDownAll() {
        System.out.println(">>> @AfterAll - Runs once after all tests");
    }
}
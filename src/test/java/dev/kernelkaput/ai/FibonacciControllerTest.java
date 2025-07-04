package dev.kernelkaput.ai;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciControllerTest {

    private final FibonacciController controller = new FibonacciController();

    @Test
    void testThrowsExceptionForNegativePosition() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
            () -> controller.calculateFibonacci(-1));
        
        assertEquals("Position must be non-negative", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0",
        "1, 1",
        "2, 1",
        "3, 2", 
        "4, 3",
        "5, 5",
        "6, 8",
        "7, 13",
        "10, 55",
        "20, 6765"
    })
    void testCalculateFibonacci(int position, long expected) {
        assertEquals(expected, controller.calculateFibonacci(position));
    }
    
    @Test
    void testHandleLargePositionWithoutOverflow() {
        // Test with larger values to ensure we don't have overflow issues
        long result = controller.calculateFibonacci(50);
        assertEquals(12586269025L, result);
    }
}

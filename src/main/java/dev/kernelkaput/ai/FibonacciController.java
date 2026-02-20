package dev.kernelkaput.ai;

import jakarta.enterprise.context.ApplicationScoped;

/**
 * Controller class for calculating Fibonacci numbers.
 * Separated from the REST resource for clean separation of concerns.
 */
@ApplicationScoped
public class FibonacciController {
    
    /**
     * Calculate the Fibonacci number at the given position.
     * 
     * @param position the position in the Fibonacci sequence (0-based index)
     * @return the Fibonacci number at the specified position
     * @throws IllegalArgumentException if position is negative
     */
    public long calculateFibonacci(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Position must be non-negative");
        }
        
        if (position <= 1) {
            return position;
        }
        
        long prev = 0;
        long current = 1;
        
        for (int i = 2; i <= position; i++) {
            long next = prev + current;
            prev = current;
            current = next;
        }
        
        return current;
    }
}

package v2.button.panic;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class CosmicFinalExamTest {

    @Test
    void testWelcome() {
        // Test normal case
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        CosmicFinalExam.welcome(3);
        assertEquals("Fanta\nFanta\nFanta\n", outContent.toString());

        // Test zero case
        outContent.reset();
        CosmicFinalExam.welcome(0);
        assertEquals("", outContent.toString());

        // Test negative case - should we throw exception instead?
        outContent.reset();
        CosmicFinalExam.welcome(-1);
        assertEquals("", outContent.toString()); // or should we verify exception?
    }

    @Test
    void testTagIn() {
        // Normal case
        assertEquals(88.0, CosmicFinalExam.tagIn(100.0), 0.001);

        // Exact amount case
        assertEquals(0.0, CosmicFinalExam.tagIn(12.0), 0.001);

        // Insufficient funds case (should go negative)
        assertEquals(-12.0, CosmicFinalExam.tagIn(0.0), 0.001);

        // Large number case
        assertEquals(Double.MAX_VALUE - 12, CosmicFinalExam.tagIn(Double.MAX_VALUE), 0.001);
    }

    @Test
    void testTransferDeductsExactly2Orglings() {
        // Case 1: Sufficient balance (normal case)
        assertEquals(48.0, CosmicFinalExam.transfer(50.0), 0.001 );

        // Case 2: Exact deduction (balance = 2)
        assertEquals(0.0, CosmicFinalExam.transfer(2.0), 0.001 );

        // Case 3: Insufficient funds (balance < 2)
        assertEquals(-2.0, CosmicFinalExam.transfer(0.0), 0.001 );

        // Case 4: Floating-point precision (e.g., 5.5 - 2)
        assertEquals(3.5, CosmicFinalExam.transfer(5.5), 0.001 );
    }

    @Test
    public void testTransferRejectsNegativeBalances() {
        // Case 1: Sufficient balance (normal case)
        assertEquals(48.0, CosmicFinalExam.transfer(50.0), 0.001 );
        // Case 2: Exact deduction (balance = 2)
        assertEquals(0.0, CosmicFinalExam.transfer(2.0), 0.001 );

        // Case 3: Insufficient funds (balance < 2) → THROWS EXCEPTION
        assertThrows(IllegalArgumentException.class, () -> {
            CosmicFinalExam.transfer(0.0);
        }, "Should throw if balance < 2");

        // Case 4: Floating-point precision (e.g., 5.5 - 2)
        assertEquals(3.5, CosmicFinalExam.transfer(5.5),
                "Should handle decimals correctly");

        // Case 5: Attempt to transfer with balance = 1.999 → THROWS
        assertThrows(IllegalArgumentException.class, () -> {
            CosmicFinalExam.transfer(1.999);
        }, "Should throw if deduction would result in negative");
    }

}

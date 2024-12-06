import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Q1_CalculatorTest {

    private Q1_Calculator q1Calculator;

    @BeforeAll
    static void setUPBeforeAll() {
        // Runs once before all test cases. Setup tasks shared across tests can go here.
    }

    @AfterAll
    static void setUPAfterAll() {
        // Runs once after all test cases. Cleanup tasks can go here.
    }

    @BeforeEach
    void setUp() {
        q1Calculator = new Q1_Calculator(); // Runs before each test. Initializes the `q1Calculator` object.
    }

    @AfterEach
    void tearDown() {
        // Runs after each test. Cleanup specific to each test can go here.
    }

    @Test
    void add() {
        // Check if the result of addition is correct.
        assertEquals(3, q1Calculator.add(1, 2)); // Asserts that 1 + 2 equals 3.
        assertNotEquals(4, q1Calculator.add(1, 2)); // Asserts that 1 + 2 does not equal 4.

        assertTimeout(Duration.ofMillis(100), () -> {
            q1Calculator.add(1, 2);
        });
    }

    @Test
    void checkCondition() {
        // Verify boolean conditions.
        assertTrue(q1Calculator.checkCondition(6, 5)); // Asserts the condition is true.
        assertFalse(q1Calculator.checkCondition(5, 6)); // Asserts the condition is false.
    }

    @Test
    void divide() {
        assertThrows(Exception.class, () -> {
            Q1_Calculator.divide(2, 0);
        });

        assertEquals(2, Q1_Calculator.divide(5, 2));
    }

    @Test
    void getArray() {
        // Check array and list matching.
        List<String> str1 = Arrays.asList("a", "b", "c");
        List<String> str2 = Arrays.asList("a", "b", "c");

        assertLinesMatch(str1, str2); // Asserts two lists of strings match line by line.

        int[] arr = new int[]{1, 2, 3};
        assertArrayEquals(new int[]{1, 2, 3}, arr); // Asserts arrays are equal.
    }

    @Test
    void checkBool() {
        // Check object references and nullability.
        Q1_Calculator q1Calculator1 = q1Calculator;
        Q1_Calculator q1Calculator2 = new Q1_Calculator();

        assertSame(q1Calculator, q1Calculator1); // Asserts two objects are the same (reference equality).
        assertNotSame(q1Calculator1, q1Calculator2); // Asserts two objects are not the same.

        Q1_Calculator q1Calculator3 = null;
        assertNull(q1Calculator3); // Asserts the object is null.
        assertNotNull(q1Calculator); // Asserts the object is not null.
    }

    @ParameterizedTest
    @CsvSource({"5, 3, 2", "3, 1, 2"})
    void add(int exp, int a, int b) {
        // Runs the addition test with multiple inputs from the CSV source.
        assertEquals(exp, q1Calculator.add(a, b)); // Asserts the result matches the expected value.
    }

    // Example of repeated test (commented out for now).
//    @RepeatedTest(value = 5)
//    void checkRandom() {
//        // Check some random functionality. Asserts would compare the expected result.
//        assertEquals(1.5, Math.random()*10);
//    }

}

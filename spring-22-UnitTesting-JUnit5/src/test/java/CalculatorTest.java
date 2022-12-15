import org.junit.jupiter.api.Test;

import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void add() {
        System.out.println("Add Method");
        int actual = Calculator.add(2, 3);
        assertEquals(5, actual, "Test failed");
    }

    @Test
    void add2() {
        System.out.println("Add2 Method");
//        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(3, 2));
//        assertThrows(AccessDeniedException.class, () -> Calculator.add2(3, 2));
        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(2, 3));
    }

    @Test
    void testCase1() {
        System.out.println("Test Case 1");
//        fail("Not implemented yet");
    }

    @Test
    void testCase2() {
        System.out.println("Test Case 2");
        assertEquals("add", Calculator.operator);
        assertTrue(Calculator.operator.equals("add"));
    }

    @Test
    void testCase3() {
        System.out.println("Test Case 3");
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 3, 2}, "Arrays are not same ");
    }

    @Test
    void testCase4() {
        System.out.println("Test Case 4");

        String nullStr = null;
        String notNullStr = "Cydeo";

        assertNull(nullStr);
        assertNotNull(notNullStr);

//        assertNull(notNullStr);
        assertNotNull(nullStr);
    }

    @Test
    void testCase5() {
        System.out.println("Test Case 5");

        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertSame(c1, c2);
        assertSame(c1, c3);
        assertNotSame(c1, c2);
        assertNotSame(c1, c3);
    }
}
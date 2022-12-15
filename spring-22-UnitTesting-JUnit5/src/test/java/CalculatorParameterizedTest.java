import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTest {
    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
    void testCase1(String arg) {
        Assertions.assertFalse(arg.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9})
    void testCase2(int num) {
        Assertions.assertEquals(0, num % 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
//    @EmptySource
//    @NullSource
    @NullAndEmptySource
    void testCase3(String arg) {
        Assertions.assertFalse(arg.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase4(String arg) {
        Assertions.assertFalse(arg.isEmpty());
    }

    static String[] stringProvider() {
        return new String[]{"Java", "JS", "TS"};
    }


}

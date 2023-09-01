package src.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import src.main.Calculator;

public class CalculatorSuccessTest {

    private final long MIN = Long.MIN_VALUE;
    private final long MAX = Long.MAX_VALUE;

    @ParameterizedTest
    @CsvSource({
            "10 + 10, 20",
            "10 - 10, 0",
            "10 * 10, 100",
            "10 / 10, 1"
    })
    @DisplayName("사칙연산 수행")
    void testCalculate(String expression, long expected) {
        Calculator calculator = new Calculator();
        long result = calculator.calculate(expression);
        Assertions.assertEquals(expected, result);
    }
}

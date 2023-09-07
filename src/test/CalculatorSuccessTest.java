package src.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import src.main.Calculator;

public class CalculatorSuccessTest {

    private Calculator calculator = new Calculator();

    private final long MIN = Long.MIN_VALUE;
    private final long MAX = Long.MAX_VALUE;

    @ParameterizedTest
    @CsvSource(
            value = {
            "10 + 10, 20",
            "10 - 10, 0",
            "10 * 10, 100",
            "10 / 10, 1"
            },
            delimiter = ','
    )
    @DisplayName("사칙연산을 수행할 수 있다.")
    void testCalculate(String expression, long expected) {
        long result = calculator.calculate(expression);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
            "10 + 10 * 10, 110",
            "10 - 10 / 10, 9",
            "10 * 10 + 10 / 10, 101",
            "10 / 10 - 10 * 10, -99"
            },
            delimiter = ','
    )
    @DisplayName("사칙연산의 우선순위를 준수하며 사칙연산을 수행할 수 있다.")
    void testCalculatePriority(String expression, long expected) {
        long result = calculator.calculate(expression);
        Assertions.assertEquals(expected, result);
    }
}

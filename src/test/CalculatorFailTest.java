package src.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import src.main.Calculator;

public class CalculatorFailTest {

    private Calculator calculator = new Calculator();

    private final long MIN = Long.MIN_VALUE;
    private final long MAX = Long.MAX_VALUE;

    @ParameterizedTest
    @CsvSource({
            MIN + " / 0",
            "0 / 0",
            MAX + " / 0"
    })
    @DisplayName("0으로 나누는 계산식에 대해 ArithmeticException 예외가 발생한다.")
    void testDivideByZero(String expression) {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(expression);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "0 + +",
            "+ 0 +",
            "+ + 0",
            "0 0 0",
            "0 + 0 +",
            "+ 0 + 0",
            "0 ++ 0",
    })
    @DisplayName("올바르지 못한 계산식에 대해 IllegalArgumentException 예외가 발생한다.")
    void testWrongExpression(String expression) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(expression);
        });
    }

}

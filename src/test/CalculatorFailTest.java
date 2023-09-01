package src.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import src.main.Calculator;

public class CalculatorFailTest {

    private final long MIN = Long.MIN_VALUE;
    private final long MAX = Long.MAX_VALUE;

    @ParameterizedTest
    @CsvSource({
            MIN + " / 0",
            "0 / 0",
            MAX + " / 0"
    })
    @DisplayName("0으로 나누었을 때 예외 처리")
    void testDivideByZero(String expression) {
        Calculator calculator = new Calculator();
        try{
            calculator.calculate(expression);
            Assertions.fail();
        }
        catch(ArithmeticException e){
        }
    }

    @ParameterizedTest
    @CsvSource({
            "0 + +",
            "+ 0 +",
            "+ + 0",
            "0 0 0",
            "0 + 0 +",
            "+ 0 + 0",
    })
    @DisplayName("올바르지 못한 식 예외 처리")
    void testWrongExpression(String expression) {
        Calculator calculator = new Calculator();
        try{
            System.out.println(calculator.calculate(expression));
            Assertions.fail();
        }
        catch(IllegalArgumentException e){
        }
    }

}

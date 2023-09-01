package src.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.main.Calculator;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testCalculate(){
        long value1 = calculator.calculate("1 + 5 * 4 * 7 - 8 + 5 + 9 - 5 + 5 * 7 - 5 + 7 - 4 - 4 * 4");
        Assertions.assertEquals(value1, 1 + 5 * 4 * 7 - 8 + 5 + 9 - 5 + 5 * 7 - 5 + 7 - 4 - 4 * 4);

        long value2 = calculator.calculate("5 * 8 - 9 * 7 / 2 * 5 + 5 + 8 * 5 / 8 * 8 * 8 - 9 + 5 + 5");
        Assertions.assertEquals(value2, 5 * 8 - 9 * 7 / 2 * 5 + 5 + 8 * 5 / 8 * 8 * 8 - 9 + 5 + 5);

        long value3 = calculator.calculate("5 + 9 - 5 * 7 - 1 + 3 / 5 * 5 + 4 - 5 / 1 - 5 / 4 * 2 - 8");
        Assertions.assertEquals(value3, 5 + 9 - 5 * 7 - 1 + 3 / 5 * 5 + 4 - 5 / 1 - 5 / 4 * 2 - 8);
    }
}

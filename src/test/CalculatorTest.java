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

    @Test
    public void testCalculateByOperator(){
        for(long i=-17; i<=17; i+=2){
            for(long j=-17; j<=17; j+=2){
                long sum = calculator.calculateByOperator(i, j, "+");
                Assertions.assertEquals(sum, i + j);
                long sub = calculator.calculateByOperator(i, j, "-");
                Assertions.assertEquals(sub, i - j);
                long mul = calculator.calculateByOperator(i, j, "*");
                Assertions.assertEquals(mul, i * j);
                long div = calculator.calculateByOperator(i, j, "/");
                Assertions.assertEquals(div, i / j);
            }
        }
    }

    @Test
    public void testGetLongValue(){
        for(long i=-50; i<=50; i++){
            long value = calculator.getLongValue(String.valueOf(i));
            Assertions.assertEquals(value, i);
        }
    }
}

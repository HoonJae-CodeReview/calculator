package src.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.main.Calculator;
import src.main.exception.BadExpressionException;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testCalculateByOperator(){
        for(long i=-17; i<=17; i+=2){
            for(long j=-17; j<=17; j+=2){
                long sum = calculator.calculateByOperator(i, j, '+');
                Assertions.assertEquals(sum, i + j);
                long sub = calculator.calculateByOperator(i, j, '-');
                Assertions.assertEquals(sub, i - j);
                long mul = calculator.calculateByOperator(i, j, '*');
                Assertions.assertEquals(mul, i * j);
                long div = calculator.calculateByOperator(i, j, '/');
                Assertions.assertEquals(div, i / j);
            }
        }
    }

    @Test
    public void testDivideByZero(){
        Assertions.assertThrows(BadExpressionException.class, () -> {
            calculator.calculateByOperator(1, 0, '/');
        });
    }

    @Test
    public void testGetOperator(){
        char sum = calculator.getOperator("+");
        Assertions.assertEquals(sum, '+');
        char sub = calculator.getOperator("-");
        Assertions.assertEquals(sub, '-');
        char mul = calculator.getOperator("*");
        Assertions.assertEquals(mul, '*');
        char div = calculator.getOperator("/");
        Assertions.assertEquals(div, '/');

        Assertions.assertThrows(BadExpressionException.class, () -> {
            calculator.getOperator("++");
        });
        Assertions.assertThrows(BadExpressionException.class, () -> {
            calculator.getOperator("a");
        });
        Assertions.assertThrows(BadExpressionException.class, () -> {
            calculator.getOperator("1");
        });
    }

    @Test
    public void testGetLongValue(){
        for(long i=-50; i<=50; i++){
            long value = calculator.getLongValue(String.valueOf(i));
            Assertions.assertEquals(value, i);
        }

        Assertions.assertThrows(BadExpressionException.class, () -> {
            calculator.getLongValue("+");
        });
        Assertions.assertThrows(BadExpressionException.class, () -> {
            calculator.getLongValue("a");
        });
    }
}

import calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {


@Test
public void calculator() {
    Calculator calculator = new Calculator();
    int result = calculator.calculator("3 4 5 + *");
    Assertions.assertEquals(27,result);
    }
}

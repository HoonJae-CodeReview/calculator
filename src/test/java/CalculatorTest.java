import calculator.Calculator;
import calculator.InFixCalculator;
import calculator.PostFixCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {


@Test
public void PostFixCalculator() {
    PostFixCalculator calculator = new PostFixCalculator();
    int result = calculator.calculator("3 4 5 + *");
    Assertions.assertEquals(27,result);
    }
@Test
public void InFixCalculator(){
    Calculator calculator = new InFixCalculator();
    int expect = calculator.calculator("3 + 2 + 5 * 2 / 1 ");
    Assertions.assertEquals(15,expect);
}
}

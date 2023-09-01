import accumulator.Accumulator;
import accumulator.InFixAccumulator;
import accumulator.PostFixAccumulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {


    @Test
    public void PostFixCalculator() {
        PostFixAccumulator calculator = new PostFixAccumulator();
        int result = calculator.calculate("3 4 5 + *");
        Assertions.assertEquals(27,result);
    }

    @Test
    public void InFixCalculator(){
        Accumulator calculator = new InFixAccumulator();
        int expect = calculator.calculate("3 + 2 + 5 * 2 / 1 ");
        Assertions.assertEquals(15,expect);
    }
}

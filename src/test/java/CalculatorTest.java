import accumulator.Accumulator;
import accumulator.PostFixAccumulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {


    @ParameterizedTest
    @DisplayName("사칙연산")
    @ValueSource(ints = {10,20,27})
    public void PostFixCalculator(int expectResult) {
        PostFixAccumulator calculator = new PostFixAccumulator();
        int result = calculator.calculate("3 4 5 + *");
        Assertions.assertEquals(expectResult,result);
    }

    @Test
    public void InFixCalculator(){
        Accumulator calculator = new PostFixAccumulator();
        int expect = calculator.calculate("3 + 2 + 5 * 2 / 1 ");
        Assertions.assertEquals(15,expect);
    }
}

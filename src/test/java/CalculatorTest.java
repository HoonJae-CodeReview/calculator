import accumulator.Accumulator;
import accumulator.PostFixAccumulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {


  @ParameterizedTest
  @DisplayName("덧셈")
  @ValueSource(ints = {1, 10, 100, 1000})
  public void postFixAddCalculate(int expectResult) {
    Accumulator postFixAccumulator = new PostFixAccumulator();
    int result = postFixAccumulator.calculate("9 1 90 + +");
    Assertions.assertEquals(expectResult, result);
  }

  @ParameterizedTest
  @DisplayName("뺼셈")
  @ValueSource(ints = {1, 10, 100, 1000})
  public void postFixMinusCalculate(int expectResult) {
    Accumulator postFixAccumulator = new PostFixAccumulator();
    int result = postFixAccumulator.calculate("9 8 -");
    Assertions.assertEquals(expectResult, result);
  }

  @ParameterizedTest
  @DisplayName("곱셈")
  @ValueSource(ints = {1, 10, 100, 1000})
  public void postFixMultiplyCalculate(int expectResult) {
    Accumulator postFixAccumulator = new PostFixAccumulator();
    int result = postFixAccumulator.calculate("10 100 *");
    Assertions.assertEquals(expectResult, result);
  }

  @ParameterizedTest
  @DisplayName("나눗셈")
  @ValueSource(ints = {1, 10, 100, 1000})
  public void postFixDivideCalculate(int expectResult) {
    Accumulator postFixAccumulator = new PostFixAccumulator();
    int result = postFixAccumulator.calculate("100 10 /");
    Assertions.assertEquals(expectResult, result);
  }

  @ParameterizedTest
  @DisplayName("사칙연산")
  @ValueSource(ints = {10, 20, 27})
  public void PostFixCalculate(int expectResult) {
    PostFixAccumulator calculator = new PostFixAccumulator();
    int result = calculator.calculate("3 4 5 + *");
    Assertions.assertEquals(expectResult, result);
  }

}

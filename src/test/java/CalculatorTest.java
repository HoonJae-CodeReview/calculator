import accumulator.Accumulator;
import accumulator.PostFixAccumulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {


  @ParameterizedTest
  @DisplayName("덧셈")
  @CsvSource(value = {"1 2 + 3 + : 6", "10 20 + 30 + : 60",
      "100 200 + 300 + : 600"}, delimiter = ':')
  public void postFixAddCalculate(String expression, int expectResult) {
    Accumulator postFixAccumulator = new PostFixAccumulator();
    int result = postFixAccumulator.calculate(expression);
    Assertions.assertEquals(expectResult, result);
  }

  @ParameterizedTest
  @DisplayName("뺼셈")
  @CsvSource(value = {"1 2 - 3 -: -4", "10 30 - 20 -: -40", "300 200 - 1 - : 99"}, delimiter = ':')
  public void postFixMinusCalculate(String expression, int expectResult) {
    Accumulator postFixAccumulator = new PostFixAccumulator();
    int result = postFixAccumulator.calculate(expression);
    Assertions.assertEquals(expectResult, result);
  }

  @ParameterizedTest
  @DisplayName("곱셈")
  @CsvSource(value = {"1 2 * 3 *: 6", "10 20 * 30 *: 6000",
      "100 200 * 300 * : 6000000"}, delimiter = ':')
  public void postFixMultiplyCalculate(String expression, int expectResult) {
    Accumulator postFixAccumulator = new PostFixAccumulator();
    int result = postFixAccumulator.calculate(expression);
    Assertions.assertEquals(expectResult, result);
  }

  @ParameterizedTest
  @DisplayName("나눗셈")
  @CsvSource(value = {"100 10 / 1 / : 10", "10 2 / : 5", "10000 20 / 10 / : 50"}, delimiter = ':')
  public void postFixDivideCalculate(String expression, int expectResult) {
    Accumulator postFixAccumulator = new PostFixAccumulator();
    int result = postFixAccumulator.calculate(expression);
    Assertions.assertEquals(expectResult, result);
  }

  @ParameterizedTest
  @DisplayName("사칙연산")
  @CsvSource(value = {"5 3 2 * + 8 4 / - : 9", "7 4 * 2 / 3 + 1 - : 16",
      "9 5 - 2 * 6 3 / +: 10"}, delimiter = ':')
  public void PostFixCalculate(String expression, int expectResult) {
    PostFixAccumulator calculator = new PostFixAccumulator();
    int result = calculator.calculate(expression);
    Assertions.assertEquals(expectResult, result);
  }

}

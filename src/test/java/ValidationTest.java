import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.PatternValidator;

public class ValidationTest {

  @ParameterizedTest
  @DisplayName("옵션 선택 테스트")
  @ValueSource(strings = {"1", "2"})
  public void OptionSelectTest(String selectInput) {
    boolean result = PatternValidator.checkSelectValue(selectInput);
    Assertions.assertTrue(result);
  }

  @ParameterizedTest
  @DisplayName("옵션 선택 검증 테스트")
  @ValueSource(strings = {"10000", "abc", "!!@@##"})
  public void OptionSelectValidationTest(String selectInput) {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      PatternValidator.checkSelectValue(selectInput);
    });
  }

  @ParameterizedTest
  @DisplayName("식 입력 테스트")
  @ValueSource(strings = {"3 + 1 + 2", "1 * 2 / 100 + 2 - 10"})
  public void inputExpressionTest(String input) {
    boolean result = PatternValidator.checkExpressionValue(input);
    Assertions.assertTrue(result);
  }

  @ParameterizedTest
  @DisplayName("식 입력 검증 테스트")
  @ValueSource(strings = {"1*2/100+2-10", "!!@@##"})
  public void inputExpressionValidationTest(String input) {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      PatternValidator.checkExpressionValue(input);
    });
  }
}



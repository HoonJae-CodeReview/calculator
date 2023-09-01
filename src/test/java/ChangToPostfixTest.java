import convertor.InfixToPostfixConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ChangToPostfixTest {

  @ParameterizedTest
  @DisplayName("중위 표기식 후위 표기식 변환")
  @ValueSource(strings = {"1 2 3 * + ", "1 + 2 * 3"})
  public void InfixToPostfixTest(String expectResult) {
    String input = "1 + 2 * 3";
    InfixToPostfixConverter calculator = new InfixToPostfixConverter();
    String value = calculator.changeToPostFix(input);
    Assertions.assertEquals(expectResult, value);
  }

}

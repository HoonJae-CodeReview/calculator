import convertor.InfixToPostfixConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ChangToPostfixTest {

  @ParameterizedTest
  @DisplayName("중위 표기식 후위 표기식 변환")
  @CsvSource(value = {"7 * 4 / 2 + 3 - 1 :'7 4 * 2 / 3 + 1 - '",
      "9 - 5 * 2 + 6 / 3: '9 5 2 * - 6 3 / + '"}, delimiter = ':')
  public void InfixToPostfixTest(String infixExpression, String postFinExpression) {
    InfixToPostfixConverter calculator = new InfixToPostfixConverter();
    String result = calculator.changeToPostFix(infixExpression);
    Assertions.assertEquals(postFinExpression, result);
  }

}

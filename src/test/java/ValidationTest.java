import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import validation.ExpressionInputValidation;
import validation.SelectValidation;

public class ValidationTest {

  @ParameterizedTest
  @DisplayName("옵션 선택 테스트")
  @ValueSource(strings = {"1", "2"})
  public void OptionSelectTest(String selectInput) {
    SelectValidation selectValidation = new SelectValidation();
    boolean result = selectValidation.checkSelectValue(selectInput);
    Assertions.assertTrue(result);
  }

  @ParameterizedTest
  @DisplayName("옵션 선택 검증 테스트")
  @ValueSource(strings = {"10000","abc","!!@@##"})
  public void OptionSelectValidationTest(String selectInput) {
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStreamCaptor));
    SelectValidation selectValidation = new SelectValidation();
    selectValidation.checkSelectValue(selectInput);
    Assertions.assertTrue(outputStreamCaptor.toString().trim().equals("잘못된 입력값 입니다."));
  }

  @ParameterizedTest
  @DisplayName("식 입력 테스트")
  @ValueSource(strings = {"3 + 1 + 2", "1 * 2 / 100 + 2 - 10"})
  public void inputExpressionTest(String expressionInput) {
    ExpressionInputValidation expressionInputValidation = new ExpressionInputValidation();
    boolean result = expressionInputValidation.checkExpressionValue(expressionInput);
    Assertions.assertTrue(result);
  }

  @ParameterizedTest
  @DisplayName("식 입력 검증 테스트")
  @ValueSource(strings = {"1*2/100+2-10", "!!@@##"})
  public void inputExpressionValidationTest(String expressionInput) {
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStreamCaptor));
    ExpressionInputValidation expressionInputValidation = new ExpressionInputValidation();
    expressionInputValidation.checkExpressionValue(expressionInput);
    Assertions.assertTrue(outputStreamCaptor.toString().trim().equals("잘못된 형식의 식입니다."));
  }
}



import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import validation.SelectValidation;

public class ValidationTest {

  @ParameterizedTest
  @DisplayName("옵션 선택 테스트")
  @ValueSource(strings = {"1","2","10000"})
  public void OptionSelectTest(String selectInput){
    SelectValidation selectValidation = new SelectValidation();
    boolean result = selectValidation.checkSelectValue(selectInput);
    Assertions.assertTrue(result);
  }

  @ParameterizedTest
  @DisplayName("옵션 선택 검증 테스트")
  @ValueSource(strings = {"1","2","10000"})
  public void OptionSelectValidationTest(String selectInput){
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStreamCaptor));
    SelectValidation selectValidation = new SelectValidation();
    selectValidation.checkSelectValue(selectInput);
    Assertions.assertTrue(outputStreamCaptor.toString().trim().equals("잘못된 입력값 입니다."));
  }


}

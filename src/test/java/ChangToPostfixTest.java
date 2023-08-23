import calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChangToPostfixTest {

@Test
public void PostfixTest(){
    String input = "1 + 2 * 3 ";
    String expect = "1  2 + 3 *";
    Calculator calculator = new Calculator();
    String value = calculator.changeToPostFix(input);
    Assertions.assertEquals(value,expect);
}
}

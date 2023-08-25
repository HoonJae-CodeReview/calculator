import calculator.InFixCalculator;
import calculator.PostFixCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChangToPostfixTest {

@Test
public void PostfixTest(){
    String input = "1 + 2 * 3";
    String expect = "1 2 3 * + ";
    InFixCalculator calculator = new InFixCalculator();
    String value = calculator.changeToPostFix(input);
    Assertions.assertEquals(expect,value);
}
}

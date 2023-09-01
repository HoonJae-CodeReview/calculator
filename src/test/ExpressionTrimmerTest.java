package src.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import src.main.ExpressionTrimmer;

public class ExpressionTrimmerTest {

    @ParameterizedTest
    @CsvSource({
            "10 + 10,10 + 10",
            "10  + 10,10 + 10",
            "10 +  10,10 + 10",
            "10  +  10,10 + 10",
    })
    @DisplayName("띄어쓰기가 불일치한 계산식들을 동일하게 읽을 수 있다.")
    void testCalculate(String expression, String expected) {
        System.out.println(expression+","+expected);
        String trimmedExpression = ExpressionTrimmer.trimExpression(expression);
        Assertions.assertEquals(expected, trimmedExpression);
    }
}

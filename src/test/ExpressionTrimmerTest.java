package src.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import src.main.ExpressionTrimmer;

public class ExpressionTrimmerTest {

    @ParameterizedTest
    @CsvSource(
            value = {
            "10 + 10,10 + 10",
            "10  + 10,10 + 10",
            "10 +  10,10 + 10",
            "10  +  10,10 + 10",
            },
            delimiter = ','
    )
    @DisplayName("띄어쓰기가 불일치한 계산식들을 동일하게 읽을 수 있다.")
    void testExpressionTrimmer(String expression, String expected) {

        // when
        String trimmedExpression = ExpressionTrimmer.trimExpression(expression);

        // then
        Assertions.assertEquals(expected, trimmedExpression);
    }
}

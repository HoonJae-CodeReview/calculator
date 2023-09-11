package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternValidator {

  private static final Pattern EXPRESSIONREGEX = Pattern.compile("^\\d+(?: \\+ \\d+| - \\d+| \\* \\d+| \\/ \\d+)*$");

  private static final Pattern OPTIONREGEX = Pattern.compile("^[12]+$");

  private static final Pattern OPERATORREGEX = Pattern.compile("[\\+\\-\\*/]");

  public static boolean checkExpressionValue(String expression) {
    Matcher matcher = EXPRESSIONREGEX.matcher(expression);
    if (!matcher.matches()) {
      throw  new IllegalArgumentException("잘못된 식 입력입니다.");
    }
    return true;
  }


  public static boolean checkSelectValue(String select) {
    Matcher matcher = OPTIONREGEX.matcher(select);
    if (!matcher.matches()) {
      throw  new IllegalArgumentException("잘못된 옵션 선택입니다");
    }
    return true;
  }

  public static boolean checkOperatorValue(String operator){
    Matcher matcher = OPERATORREGEX.matcher(operator);
    if (!matcher.matches()) {
      return  false;
    }
    return true;
  }

}

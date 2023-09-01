package validation;

import output.ConsoleOutput;
import output.Output;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionInputValidation {

  private final Output output = new ConsoleOutput();
  private final Pattern REGEX = Pattern.compile("^\\d+(?: \\+ \\d+| - \\d+| \\* \\d+| \\/ \\d+)*$");

  public boolean checkExpressionValue(String expression) {
    Matcher matcher = REGEX.matcher(expression);
    if (!matcher.matches()) {
      output.print("잘못된 형식의 식입니다.");
      return false;
    }
    return true;
  }

}

package accumulator;

import java.util.Stack;

public class PostFixAccumulator implements Accumulator {

  private static final String PLUS = "+";
  private static final String MINIS = "-";
  private static final String MULTIPLY = "*";
  private static final String DIVIDE = "/";
  private int firstOperand;
  private int secondOperand;

  @Override
  public int calculate(String postfixExpression) {
    Stack<Integer> result = new Stack<>();
    String[] splitPostfixExpression = postfixExpression.split(" ");
    for (String str : splitPostfixExpression) {
      String value = str;
      switch (value) {
        case PLUS:
          firstOperand = result.pop();
          secondOperand = result.pop();
          result.push(secondOperand + firstOperand);
          break;
        case MINIS:
          firstOperand = result.pop();
          secondOperand = result.pop();
          result.push(secondOperand - firstOperand);
          break;
        case MULTIPLY:
          firstOperand = result.pop();
          secondOperand = result.pop();
          result.push(secondOperand * firstOperand);
          break;
        case DIVIDE:
          firstOperand = result.pop();
          secondOperand = result.pop();
          result.push(secondOperand / firstOperand);
          break;
        default:
          result.push(Integer.parseInt(value));
      }
    }
    return result.pop();
  }
}

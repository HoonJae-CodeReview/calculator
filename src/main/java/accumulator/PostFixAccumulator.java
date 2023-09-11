package accumulator;

import static operator.Operator.*;

import java.util.Stack;
import operator.Operator;
import util.PatternValidator;

public class PostFixAccumulator implements Accumulator {

  private int firstOperand;
  private int secondOperand;

  @Override
  public int calculate(String postfixExpression) {
    Stack<Integer> result = new Stack<>();
    String[] splitPostfixExpression = postfixExpression.split(" ");
    for (String str : splitPostfixExpression) {
      processToken(result, str);
    }
    return result.pop();
  }

  private void processToken(Stack<Integer> result, String str) {
    if (PatternValidator.checkOperatorValue(str)) {
      processOperator(result, str);
    } else if (!PatternValidator.checkOperatorValue(str)) {
      processOperand(result, str);
    }
  }

  private void processOperand(Stack<Integer> result, String str) {
    result.push(Integer.parseInt(str));
  }

  private void processOperator(Stack<Integer> result, String str) {
    Operator value = stringToOperator(str);
    calculate(result, value);
  }

  private void calculate(Stack<Integer> result, Operator value) {
    switch (value) {
      case PLUS:
        firstOperand = result.pop();
        secondOperand = result.pop();
        result.push(secondOperand + firstOperand);
        break;
      case MINUS:
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
    }
  }
}

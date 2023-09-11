package convertor;

import java.util.Arrays;
import java.util.Stack;
import operator.Operator;

public class InfixToPostfixConverter {

  private String postfix = "";

  public String changeToPostFix(String expression) {
    Stack<String> operatorStack = new Stack();
    String[] splitExpression = expression.split(" ");
    Arrays.stream(splitExpression).forEach(str -> {
      Operator operator = Operator.stringToOperator(str);
      int operatorPriority = operatorPriority(operator);
      int value = Integer.parseInt(str);
      if (operatorPriority == -1) {
        postfix += value + " ";
      } else if (operatorStack.isEmpty()) {
        operatorStack.add((value + " "));
      } else {
        while (!operatorStack.isEmpty()
            && operatorPriority(Operator.stringToOperator(operatorStack.peek().substring(0, 1)))
            >= operatorPriority) {
          postfix += operatorStack.pop();
        }
        operatorStack.add((value + " "));
      }
    });
    while (!operatorStack.isEmpty()) {
      postfix += operatorStack.pop();
    }
    return postfix;
  }


  public int operatorPriority(Operator operator) {
    switch (operator) {
      case PLUS:
      case MINUS:
        return 1;
      case MULTIPLY:
      case DIVIDE:
        return 2;
    }
    return -1;
  }
}

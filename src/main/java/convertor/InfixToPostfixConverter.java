package convertor;

import java.util.Arrays;
import java.util.Stack;
import operator.Operator;
import util.PatternValidator;

public class InfixToPostfixConverter {

  private StringBuilder postfix = new StringBuilder();


  public String changeToPostFix(String expression) {
    Stack<String> operatorStack = new Stack();
    String[] splitExpression = expression.split(" ");
    Arrays.stream(splitExpression).forEach(token -> {
      processToken(operatorStack, token);
    });
    while (!operatorStack.isEmpty()) {
      postfix.append(operatorStack.pop());
    }
    return postfix.toString();
  }

  private void processToken(Stack<String> operatorStack, String token) {
    if (PatternValidator.checkOperatorValue(token)) {
      handleOperator(operatorStack, token);
    } else if (!PatternValidator.checkOperatorValue(token)) {
      handelOperand(token);
    }
  }

  private void handelOperand(String token) {
    int value = Integer.parseInt(token);
    postfix.append(value).append(" ");
  }

  private void handleOperator(Stack<String> operatorStack, String token) {
    Operator currentOperator = Operator.stringToOperator(token);
    int currentOperatorPriority = operatorPriority(currentOperator);
    setOperatorToOperatorStack(operatorStack, token, currentOperatorPriority);
  }

  private void setOperatorToOperatorStack(Stack<String> operatorStack, String token,
      int currentOperatorPriority) {
    compareOperatorPriority(operatorStack, currentOperatorPriority);
    operatorStack.add((token + " "));
  }

  private void compareOperatorPriority(Stack<String> operatorStack, int currentOperatorPriority) {
    while (!operatorStack.isEmpty()) {
      Operator topStackOperator = Operator.stringToOperator(operatorStack.peek().substring(0, 1));
      int topStackOperatorPriority = operatorPriority(topStackOperator);
      if (topStackOperatorPriority < currentOperatorPriority) {
        break;
      }
      postfix.append(operatorStack.pop());
    }
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

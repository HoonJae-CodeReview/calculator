package calculator;

import accumulator.Accumulator;
import accumulator.PostFixAccumulator;
import convertor.InfixToPostfixConverter;
import input.Input;
import inputView.ConsoleInputView;
import inputView.InputView;
import output.ConsoleOutput;
import output.Output;
import repository.Repository;
import validation.ExpressionInputValidation;
import validation.SelectValidation;


public class Calculator {

  private final int CHECK = 1;
  private final int CALCULATE = 2;
  private SelectValidation selectValidation = new SelectValidation();

  private InputView inputView = new ConsoleInputView();

  private ExpressionInputValidation expressionInputValidation = new ExpressionInputValidation();

  private Output output = new ConsoleOutput();

  public void run() {
    Input input = new Input();
    while (true) {
      inputView.displayOptions();
      String selectInput = input.selectInput();
      if (!selectValidation.checkSelectValue(selectInput)) {
        continue;
      }
      int select = Integer.parseInt(selectInput);
      switch (select) {
        case CHECK:
          output.printOperationResult();
          break;

        case CALCULATE:
          String expression = input.expressionInput();
          compute(expression);
          break;
      }
    }
  }

  private void compute(String expression) {
    if (!expressionInputValidation.checkExpressionValue(expression)) {
      return;
    }
    InfixToPostfixConverter infixToPostfixConverter = new InfixToPostfixConverter();
    String postFixExpression = infixToPostfixConverter.changeToPostFix(expression);
    Accumulator calculator = new PostFixAccumulator();
    String result = Integer.toString(calculator.calculate(postFixExpression));
    Repository repository = new Repository();
    output.print(result);
    repository.store(expression, result);
  }
}

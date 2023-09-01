package execution;

import calculator.Calculator;
import calculator.InFixCalculator;
import input.Input;
import inputView.ConsoleInputView;
import inputView.InputView;
import output.ConsoleOutput;
import options.Options;
import output.Output;
import repository.Repository;
import validation.ExpressionInputValidation;
import validation.SelectValidation;


public class Execution {

    private static final int CHECK = 1;
    private static final int CALCULATE = 2;
    private static SelectValidation selectValidation = new SelectValidation();

    private static InputView inputView = new ConsoleInputView();

    private static ExpressionInputValidation expressionInputValidation = new ExpressionInputValidation();

    private static Output output = new ConsoleOutput();

    public static void run() {
        Input input  = new Input();
        while(true) {
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
                    if (!expressionInputValidation.checkExpressionValue(expression)) {
                        continue;
                    }
                    Calculator calculator = new InFixCalculator();
                    String result = Integer.toString(calculator.calculator(expression));
                    Repository repository = new Repository();
                    output.print(result);
                    repository.store(expression, result);
            }
        }
    }
}

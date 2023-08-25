import calculator.Calculator;
import input.Input;
import inquire.Inquire;
import options.Options;
import repository.Repository;
import validation.ExpressionInputValidation;
import validation.SelectValidation;

import java.io.IOException;

public class main {
    private static SelectValidation selectValidation = new SelectValidation();
    private static Repository repository = new Repository();
    private static Calculator calculator = new Calculator();
    private static Input input = new Input();
    private static Inquire inquire = new Inquire();

    private static ExpressionInputValidation expressionInputValidation = new ExpressionInputValidation();
    public static void main(String[] args) throws IOException {

        while(true){
            input.select();
            if(!selectValidation.checkSelectValue(Input.select)){
                continue;
            }
            if(Input.select == Options.CHECK.getValue()){
                inquire.printResult();
            }
            else if(Input.select == Options.CALCULATE.getValue()){
                String expression = input.expression();
                String postfixExpression = calculator.changeToPostFix(expression);
                int result = calculator.calculator(postfixExpression);
                repository.store(expression + " = " + result);

            }
        }
    }
}

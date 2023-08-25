import calculator.Calculator;
import input.Input;
import inquire.Inquire;
import options.Options;
import repository.Repository;
import validation.SelectValidation;

import java.io.IOException;

public class main {


    public static void main(String[] args) throws IOException {

        SelectValidation selectValidation = new SelectValidation();

        while(true){
            Input input = new Input();
            input.select();
            if(!selectValidation.checkSelectValue(Input.select)){
                continue;
            }
            if(Input.select == Options.CHECK.getValue()){
                Inquire inquire = new Inquire();
                inquire.printResult();
            }
            else if(Input.select == Options.CALCULATE.getValue()){
                Repository repository = new Repository();
                Calculator calculator = new Calculator();
                String expression = input.expression();
                String postfixExpression = calculator.changeToPostFix(expression);
                int result = calculator.calculator(postfixExpression);
                repository.store(expression + " = " + result);

            }
        }
    }
}

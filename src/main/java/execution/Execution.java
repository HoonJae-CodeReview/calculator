package execution;

import calculator.Calculator;
import calculator.InFixCalculator;
import input.Input;
import inquire.Inquire;
import options.Options;
import repository.Repository;
import validation.ExpressionInputValidation;
import validation.SelectValidation;

import java.io.IOException;

public class Execution {

    private static SelectValidation selectValidation = new SelectValidation();


    private static ExpressionInputValidation expressionInputValidation = new ExpressionInputValidation();

    public static void run() {
        Input input  = new Input();
        while(true){
            String selectInput = input.selectInput();
            if(!selectValidation.checkSelectValue(selectInput)){
                continue;
            }
            int select = Integer.parseInt(selectInput);
            if(select== Options.CHECK.getValue()){
                Inquire inquire = new Inquire();
                inquire.printResult();
            }
            else if(select== Options.CALCULATE.getValue()){
                String expression = input.expressionInput();
                if(!expressionInputValidation.checkExpressionValue(expression)){
                    continue;
                }
                Calculator calculator = new InFixCalculator();
                int result = calculator.calculator(expression);
                Repository repository = new Repository();
                System.out.println(result);
                StringBuilder stringBuilder = new StringBuilder();
                repository.store(expression + " = " + result);

            }
        }
    }
}

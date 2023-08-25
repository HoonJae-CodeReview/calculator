package execution;

import calculator.Calculator;
import calculator.InFixCalculator;
import input.ExpressionInput;
import input.SelectInput;
import inquire.Inquire;
import options.Options;
import repository.Repository;
import validation.ExpressionInputValidation;
import validation.SelectValidation;

import java.io.IOException;

public class Execution {

    private static SelectValidation selectValidation = new SelectValidation();


    private static ExpressionInputValidation expressionInputValidation = new ExpressionInputValidation();


    public static void run() throws IOException {

        while(true){
            SelectInput selectInput = new SelectInput();
            int select = selectInput.input();
            if(!selectValidation.checkSelectValue(select)){
                continue;
            }
            if(select== Options.CHECK.getValue()){
                Inquire inquire = new Inquire();
                inquire.printResult();
            }
            else if(select== Options.CALCULATE.getValue()){
                ExpressionInput expressionInput = new ExpressionInput();
                String Expression = expressionInput.input();
                if(!expressionInputValidation.checkExpressionValue(Expression)){
                    continue;
                }
                Calculator calculator = new InFixCalculator();
                int result = calculator.calculator(Expression);
                Repository repository = new Repository();
                System.out.println(result);
                repository.store(Expression + " = " + result);

            }
        }
    }
}

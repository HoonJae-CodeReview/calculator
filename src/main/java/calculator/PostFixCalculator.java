package calculator;

import java.util.Arrays;
import java.util.Stack;

public class PostFixCalculator implements Calculator{

    int firstOperand;
    int secondOperand;
    @Override
    public int calculator(String postfixExpression){
        Stack<Integer> result = new Stack<>();
        String[] splitPostfixExpression = postfixExpression.split(" ");
        Arrays.stream(splitPostfixExpression).forEach(str -> {
            String value = str;
            switch (value){
                case "+":
                    firstOperand = result.pop();
                    secondOperand = result.pop();
                    result.push(secondOperand + firstOperand);
                    break;
                case "-":
                    firstOperand = result.pop();
                    secondOperand = result.pop();
                    result.push(secondOperand - firstOperand);
                    break;
                case "*":
                    firstOperand = result.pop();
                    secondOperand = result.pop();
                    result.push(secondOperand * firstOperand);
                    break;
                case "/":
                    firstOperand = result.pop();
                    secondOperand = result.pop();
                    result.push(secondOperand / firstOperand);
                    break;
                default:
                    result.push(Integer.parseInt(value));
            }
        });
    return result.pop();
    }
}

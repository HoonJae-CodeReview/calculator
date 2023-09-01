package calculator;

import java.util.Arrays;
import java.util.Stack;

public class PostFixCalculator implements Calculator{
    private final String PLUS = "+";
    private final String MINIS = "-";
    private final String MULTIPLY = "*";
    private final String DIVIDE = "/";
    int firstOperand;
    int secondOperand;
    @Override
    public int calculate(String postfixExpression){
        Stack<Integer> result = new Stack<>();
        String[] splitPostfixExpression = postfixExpression.split(" ");
        for (String str : splitPostfixExpression) {
            String value = str;
            Operator.DIVIDE.getValue();
            switch (value) {
                case PLUS:
                    firstOperand = result.pop();
                    secondOperand = result.pop();
                    result.push(secondOperand + firstOperand);
                    break;
                case MINIS:
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
                default:
                    result.push(Integer.parseInt(value));
            }
        }
        return result.pop();
    }
}

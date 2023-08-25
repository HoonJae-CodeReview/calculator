package calculator;

import java.util.Arrays;
import java.util.Stack;

public class PostFixCalculator implements Calculator{


    @Override
    public int calculator(String postfixExpression){
        Stack<Integer> result = new Stack<>();
        String[] splitPostfixExpression = postfixExpression.split(" ");
        Arrays.stream(splitPostfixExpression).forEach(str -> {
            String value = str;
            switch (value){
                case "+":
                    result.push(result.pop() + result.pop());
                    break;
                case "-":
                    result.push(result.pop() - result.pop());
                    break;
                case "*":
                    result.push(result.pop() * result.pop());
                    break;
                case "/":
                    result.push(result.pop() / result.pop());
                    break;
                case " ":
                    break;
                default:
                    result.push(Integer.parseInt(value));
            }
        });
    return result.pop();
    }










}

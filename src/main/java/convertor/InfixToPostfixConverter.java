package convertor;

import accumulator.Accumulator;
import accumulator.PostFixAccumulator;

import java.util.Arrays;
import java.util.Stack;

public class InfixToPostfixConverter{

    private  String postfix = "";

    public String changeToPostFix(String expression){
        Stack<String> operator = new Stack();
        String[] splitExpression = expression.split(" ");
        Arrays.stream(splitExpression).forEach(str -> {
            String value = str;
            int operatorPriority = operatorPriority(value);
            if(operatorPriority == -1){
                postfix += value+" ";
            }
            else if(operator.isEmpty()){
                operator.add((value+" "));
            }
            else {
                while(!operator.isEmpty() && operatorPriority(operator.peek().substring(0,1)) >= operatorPriority){
                    postfix += operator.pop();
                }
                operator.add((value+" "));
            }
        });
        while(!operator.isEmpty()){
            postfix += operator.pop();
        }
        return postfix;
    }


    public int operatorPriority(String operator){
        switch (operator){
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }
        return -1;
    }
}
package calculator;

import java.util.Stack;
import java.util.logging.Logger;

public class Calculator {


    Stack<Character> operator = new Stack();
    String postfix = "";
    String pattern =  "[+\\-*/]";


    public String changeToPostFix(String expression){
        expression.chars().forEach(c -> {
            char value = (char)c;
            int operatorPriority = operatorPriority(value);
             if(operatorPriority == -1){
                 postfix += value;
             }
             else if(operator.isEmpty()){
                 operator.add(value);
             }
             else {
                 while(!operator.isEmpty() && operator.peek() >= operatorPriority){
                     postfix += operator.pop();
                 }
                 operator.add(value);
             }
        });
        while(!operator.isEmpty()){
            postfix += operator.pop();
        }
        return postfix;
        }



    public int operatorPriority(char operator){
        switch (operator){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }






}

package calculator;

import java.util.Stack;

public class Calculator {

    Stack operator = new Stack();
    String postfix = "";


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

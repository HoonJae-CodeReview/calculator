package src.main;

import src.main.exception.BadExpressionException;

import java.util.*;

public class Calculator {

    public long calculate(String expression) throws BadExpressionException {
        StringTokenizer stringTokenizer = new StringTokenizer(expression);

        if(stringTokenizer.countTokens()%2==0){
            throw new BadExpressionException();
        }

        long resultValue = 0;

        long currentValue = getLongValue(stringTokenizer.nextToken());
        char currentOperator = '+';

        while(stringTokenizer.hasMoreTokens()){
            char nextOperator = getOperator(stringTokenizer.nextToken());
            long nextValue = getLongValue(stringTokenizer.nextToken());

//            System.out.printf("%s%d  |  %d %s %d %s %d\n",nextOperator,nextValue,resultValue,currentOperator,currentValue,nextOperator,nextValue);

            switch(nextOperator){
                case '+' :
                case '-' :
                    resultValue = calculateByOperator(resultValue, currentValue, currentOperator);  // 덧셈이나 뺄셈만 수행
                    currentValue = nextValue;
                    currentOperator = nextOperator;
                    break;
                case '*' :
                case '/' :
                    currentValue = calculateByOperator(currentValue, nextValue, nextOperator);
                    break;
                default:
                    //err
            }
        }
        resultValue = calculateByOperator(resultValue, currentValue, currentOperator);  // 덧셈이나 뺄셈만 수행

        return resultValue;
    }

    public long calculateByOperator(long value1, long value2, char Operator) throws BadExpressionException {
        switch(Operator){
            case '+' : return value1 + value2;
            case '-' : return value1 - value2;
            case '*' : return value1 * value2;
            case '/' : return value1 / value2;
            default: throw new BadExpressionException();
        }
    }

    public char getOperator(String string) {
        char character = string.charAt(0);
        if(string.length()!=1 && character!='+' && character!='-' && character!='*' && character!='/') {
            throw new BadExpressionException();
        }
        return character;
    }

    public long getLongValue(String string) {
        try{
            return Long.parseLong(string);
        }
        catch(NumberFormatException e){
            throw new BadExpressionException();
        }
    }

}

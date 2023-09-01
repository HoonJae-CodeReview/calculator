package src.main;

import java.util.*;

public class Calculator {

    public long calculate(String expression) {
        StringTokenizer stringTokenizer = new StringTokenizer(expression);

        if (stringTokenizer.countTokens()%2==0){
            throw new IllegalArgumentException("올바른 식을 입력해주세요");
        }

        long resultValue = 0;

        long currentValue = getLongValue(stringTokenizer.nextToken());
        char currentOperator = '+';

        while(stringTokenizer.hasMoreTokens()){
            char nextOperator = getOperator(stringTokenizer.nextToken());
            long nextValue = getLongValue(stringTokenizer.nextToken());

//            System.out.printf("%s%d  |  %d %s %d %s %d\n",nextOperator,nextValue,resultValue,currentOperator,currentValue,nextOperator,nextValue);

            if (nextOperator == '+' || nextOperator == '-'){
                resultValue = calculateByOperator(resultValue, currentValue, currentOperator);  // 덧셈이나 뺄셈만 수행
                currentValue = nextValue;
                currentOperator = nextOperator;
            }
            else if (nextOperator == '*' || nextOperator == '/'){
                currentValue = calculateByOperator(currentValue, nextValue, nextOperator);
            }
        }
        resultValue = calculateByOperator(resultValue, currentValue, currentOperator);  // 덧셈이나 뺄셈만 수행

        return resultValue;
    }

    public long calculateByOperator(long value1, long value2, char operator) {
        switch(operator){
            case '+' : return value1 + value2;
            case '-' : return value1 - value2;
            case '*' : return value1 * value2;
            case '/' :
                if (value2 == 0){
                    throw new ArithmeticException("0으로 나눌 수 없습니다");
                }
                return value1 / value2;
        }
        return Long.MIN_VALUE;
    }

    public char getOperator(String token) {
        char character = token.charAt(0);
        if (token.length()!=1 || (character!='+' && character!='-' && character!='*' && character!='/')) {
            throw new IllegalArgumentException("올바른 식을 입력해주세요");
        }
        return character;
    }

    public long getLongValue(String token) {
        try{
            return Long.parseLong(token);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("올바른 식을 입력해주세요");
        }
    }

}

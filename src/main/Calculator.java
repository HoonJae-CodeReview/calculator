package src.main;

import java.util.*;

public class Calculator {

    public long calculate(String expression){
        StringTokenizer stringTokenizer = new StringTokenizer(expression);

        long resultValue = 0;

        long currentValue = Long.parseLong(stringTokenizer.nextToken());
        char currentOperator = '+';

        while(stringTokenizer.hasMoreTokens()){
            char nextOperator = stringTokenizer.nextToken().charAt(0);
            long nextValue = Long.parseLong(stringTokenizer.nextToken());

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

    public long calculateByOperator(long value1, long value2, char Operator){
        switch(Operator){
            case '+' : return value1 + value2;
            case '-' : return value1 - value2;
            case '*' : return value1 * value2;
            case '/' : return value1 / value2;
            default: return Long.MIN_VALUE;
        }
    }

}

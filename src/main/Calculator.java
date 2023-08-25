package src.main;

import java.util.*;

public class Calculator {

    public long calculate(String expression){
        StringTokenizer stringTokenizer = new StringTokenizer(expression);

        long resultValue = 0;

        long currentValue = Long.parseLong(stringTokenizer.nextToken());
        char currentSymbol = '+';

        while(stringTokenizer.hasMoreTokens()){
            char nextSymbol = stringTokenizer.nextToken().charAt(0);
            long nextValue = Long.parseLong(stringTokenizer.nextToken());

//            System.out.printf("%s%d  |  %d %s %d %s %d\n",nextSymbol,nextValue,resultValue,currentSymbol,currentValue,nextSymbol,nextValue);

            switch(nextSymbol){
                case '+' :
                case '-' :
                    resultValue = calculateBySymbol(resultValue, currentValue, currentSymbol);  // 덧셈이나 뺄셈만 수행
                    currentValue = nextValue;
                    currentSymbol = nextSymbol;
                    break;
                case '*' :
                case '/' :
                    currentValue = calculateBySymbol(currentValue, nextValue, nextSymbol);
                    break;
                default:
                    //err
            }
        }
        resultValue = calculateBySymbol(resultValue, currentValue, currentSymbol);  // 덧셈이나 뺄셈만 수행

        return resultValue;
    }

    public long calculateBySymbol(long value1, long value2, char Operator){
        switch(Operator){
            case '+' : return value1 + value2;
            case '-' : return value1 - value2;
            case '*' : return value1 * value2;
            case '/' : return value1 / value2;
            default: return Long.MIN_VALUE;
        }
    }

}

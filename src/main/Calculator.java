package src.main;

import java.util.*;
import java.util.stream.Stream;

public class Calculator {

    public long calculate(String expression) {
        StringTokenizer stringTokenizer = new StringTokenizer(expression);

        if (stringTokenizer.countTokens()%2==0){
            throw new IllegalArgumentException("올바른 식을 입력해주세요");
        }

        long resultValue = 0;

        long currentValue = getLongValue(stringTokenizer.nextToken());
        String currentOperator = "+";

        while(stringTokenizer.hasMoreTokens()){
            String nextOperator = stringTokenizer.nextToken();
            long nextValue = getLongValue(stringTokenizer.nextToken());

//            System.out.printf("%s%d  |  %d %s %d %s %d\n",nextOperator,nextValue,resultValue,currentOperator,currentValue,nextOperator,nextValue);

            if (nextOperator.equals("+") || nextOperator.equals("-")){
                resultValue = calculateByOperator(resultValue, currentValue, currentOperator);  // 덧셈이나 뺄셈만 수행
                currentValue = nextValue;
                currentOperator = nextOperator;
            }
            else if (nextOperator.equals("*") || nextOperator.equals("/")){
                currentValue = calculateByOperator(currentValue, nextValue, nextOperator);
            }
            else{
                throw new IllegalArgumentException("올바른 식을 입력해주세요");
            }
        }
        resultValue = calculateByOperator(resultValue, currentValue, currentOperator);  // 덧셈이나 뺄셈만 수행

        return resultValue;
    }

    private long calculateByOperator(long value1, long value2, String inputOperator) {
        CalculationOperation operation = Calculation.findOperationByOperator(inputOperator);
        return operation.calculate(value1, value2);
    }

    private long getLongValue(String token) {
        try{
            return Long.parseLong(token);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("올바른 식을 입력해주세요");
        }
    }

}

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
        }
        resultValue = calculateByOperator(resultValue, currentValue, currentOperator);  // 덧셈이나 뺄셈만 수행

        return resultValue;
    }

    public long calculateByOperator(long value1, long value2, String inputOperator) {
        for(Calculation calculation : Calculation.values()){
            String operator = calculation.getOperator();
            if (operator.equals(inputOperator)){
                CalculationOperation operation = calculation.getOperation();
                return operation.calculate(value1, value2);
            }
        }
        throw new IllegalArgumentException("올바른 식을 입력해주세요");
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

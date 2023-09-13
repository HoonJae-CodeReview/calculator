package src.main;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Calculation {
    ADD("+", (value1, value2) -> value1 + value2),
    SUB("-", (value1, value2) -> value1 - value2),
    MUL("*", (value1, value2) -> value1 * value2),
    DIV("/", (value1, value2) -> value1 / value2);

    private final String operator;
    private final BiFunction<Long, Long, Long> operation;

    Calculation(String operator, BiFunction<Long, Long, Long> operation){
        this.operator = operator;
        this.operation = operation;
    }

    public static BiFunction<Long, Long, Long> findOperationByOperator(String findingOperator){
        Calculation foundCalculation =  Stream.of(Calculation.values())
                .filter(calculation -> {
                    String operator = calculation.operator;
                    return operator.equals(findingOperator);
                })
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("적절하지 않은 연산자가 입력되었습니다"));
        return foundCalculation.operation;
    }
}

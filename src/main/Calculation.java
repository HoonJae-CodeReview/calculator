package src.main;

import java.util.stream.Stream;

public enum Calculation {
    ADD("+", (value1, value2) -> value1 + value2),
    SUB("-", (value1, value2) -> value1 - value2),
    MUL("*", (value1, value2) -> value1 * value2),
    DIV("/", (value1, value2) -> value1 / value2);

    private final String operator;
    private final CalculationOperation operation;

    Calculation(String operator, CalculationOperation operation){
        this.operator = operator;
        this.operation = operation;
    }

    public static CalculationOperation findOperationByOperator(String findingOperator){
        return Stream.of(Calculation.values())
                .filter(calculation -> {
                    String operator = calculation.operator;
                    return operator.equals(findingOperator);
                })
                .findFirst()
                .get()
                .operation;
    }
}

package src.main;

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

    public String getOperator(){
        return this.operator;
    }

    public CalculationOperation getOperation(){
        return this.operation;
    }
}

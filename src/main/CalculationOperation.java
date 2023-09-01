package src.main;

@FunctionalInterface
interface CalculationOperation {
    long calculate(long value1, long value2);
}
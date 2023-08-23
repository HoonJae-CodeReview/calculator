package options;

public enum Options {
    CHECK(1),
    CALCULATE(2);


    private int value;

    Options(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

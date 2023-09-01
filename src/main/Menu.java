package src.main;

public enum Menu {
    DISPLAY_HISTORY("조회", CalculatorDriver::displayHistory),
    CALCULATE("계산", CalculatorDriver::calculate);

    private final String title;
    private final MenuOperation operation;

    Menu(String title, MenuOperation operation) {
        this.title = title;
        this.operation = operation;
    }

    public String getTitle(){
        return this.title;
    }

    public void run(){
        this.operation.run();
    }
}

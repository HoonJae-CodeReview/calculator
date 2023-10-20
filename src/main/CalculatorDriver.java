package src.main;

public class CalculatorDriver {

    private View view;

    private final Calculator calculator = new Calculator();
    private final Recorder recorder = new Recorder();

    private boolean isRunning = true;

    public CalculatorDriver(View view){
        this.view = view;
    }

    public void run(){
        while(isRunning){
            try{
                view.displayMenu();
                var inputMenuValue = view.input();
                Menu menu = Menu.findByValue(inputMenuValue);
                runMenu(menu);
            }
            catch(ArithmeticException e){
                view.print("[!] 0으로는 나눌 수 없습니다.\n");
            }
            catch(IllegalArgumentException e){
                view.print(e);
            }
        }
    }

    private void runMenu(Menu selectedMenu){
        switch(selectedMenu){
            case DISPLAY_HISTORY:
                displayHistory();
                break;
            case CALCULATE:
                calculate();
                break;
            case STOP:
                stop();
                break;
        }
    }

    public void displayHistory(){
        String history = recorder.getHistoryToString();
        view.print(history);
    }

    public void calculate(){
        String expression = view.input();
        expression = ExpressionTrimmer.trimExpression(expression);

        long result = recorder.isAlreadyCalculated(expression)
                ? recorder.getResult(expression)
                : calculator.calculate(expression);

        view.print(result);
        recorder.addHistory(expression, result);
    }

    public void stop(){
        isRunning = false;
    }

}
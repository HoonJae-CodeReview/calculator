package src.main;

public class CalculatorDriver {

    private static View view;

    private static final Calculator calculator = new Calculator();
    private static final Recorder recorder = new Recorder();

    private static boolean isRunning = true;

    public CalculatorDriver(View view){
        this.view = view;
    }

    public void run(){
        while(isRunning){
            try{
                view.displayMenu();
                runMenu(view.input());
            }
            catch(ArithmeticException e){
                view.print("[!] 0으로는 나눌 수 없습니다.\n");
            }
            catch(IllegalArgumentException e){
                view.print(e);
            }
        }
    }

    private void runMenu(String selectedMenu){
        switch(selectedMenu){
            case "1" : Menu.DISPLAY_HISTORY.run(); break;
            case "2" : Menu.CALCULATE.run(); break;
            case "3" : Menu.STOP.run(); break;
            default : throw new IllegalArgumentException("주어진 메뉴에서 선택해주세요");
        }
    }

    public static void displayHistory(){
        String history = recorder.getHistoryToString();
        view.print(history);
    }

    public static void calculate(){
        String expression = view.input();
        expression = ExpressionTrimmer.trimExpression(expression);

        long result = recorder.isAlreadyCalculated(expression)
                ? recorder.getResult(expression)
                : calculator.calculate(expression);

        view.print(result);
        recorder.addHistory(expression, result);
    }

    public static void stop(){
        isRunning = false;
    }

}
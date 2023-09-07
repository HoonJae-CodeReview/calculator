package src.main;

public class CalculatorDriver {

    private static View view;

    private static final Calculator calculator = new Calculator();
    private static final Recorder recorder = new Recorder();

    public CalculatorDriver(View view){
        this.view = view;
    }

    public void run(){
        try{
            view.displayMenu();

            switch(view.input()){
                case "1" : Menu.DISPLAY_HISTORY.run(); break;
                case "2" : Menu.CALCULATE.run(); break;
                default : throw new IllegalArgumentException("주어진 메뉴에서 선택해주세요");
            }
        }
        catch(ArithmeticException e){
            view.print("[!] 0으로는 나눌 수 없습니다.\n");
        }
        catch(IllegalArgumentException e){
            view.print(e);
        }
        run();
    }

    public static void displayHistory(){
        String history = recorder.getHistory();
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

}
package src.main;

public class CalculatorDriver {

    private static Reader reader;
    private static Printer printer;

    private static final Calculator calculator = new Calculator();
    private static final Recorder recorder = new Recorder();

    public CalculatorDriver(Reader reader, Printer printer){
        this.reader = reader;
        this.printer = printer;
    }

    public void run(){
        try{
            printer.displayMenu();

            switch(reader.input()){
                case "1" : Menu.DISPLAY_HISTORY.run(); break;
                case "2" : Menu.CALCULATE.run(); break;
                default : throw new IllegalArgumentException("주어진 메뉴에서 선택해주세요");
            }
        }
        catch(ArithmeticException e){
            printer.print("[!] 0으로는 나눌 수 없습니다.\n");
        }
        catch(IllegalArgumentException e){
            printer.print(e);
        }
        run();
    }

    public static void displayHistory(){
        String history = recorder.getHistory();
        printer.print(history);
    }

    public static void calculate(){
        String expression = reader.input();
        expression = reader.trimExpression(expression);

        long result = recorder.isAlreadyCalculated(expression)
                ? recorder.getResult(expression)
                : calculator.calculate(expression);

        printer.print(result);
        recorder.addHistory(expression, result);
    }

}
package src.main;

import src.main.exception.BadExpressionException;
import src.main.exception.BadMenuSelectException;

public class CalculatorDriver {

    static Reader reader = new Reader();
    static Printer printer = new Printer();



    static Calculator calculator = new Calculator();
    static Recorder recorder = new Recorder(printer);

    public void run(){
        try{
            printer.displayMenu();

            switch(Integer.parseInt(reader.input())){
                case 1 : Menu.DISPLAY_HISTORY.run(); break;
                case 2 : Menu.CALCULATE.run(); break;
            }
        }
        catch(BadMenuSelectException | BadExpressionException e) {
            printer.print(e);
        }
        run();
    }

    public static void displayHistory(){
        recorder.displayHistory();
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
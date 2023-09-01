package src.main;

import src.main.exception.BadExpressionException;
import src.main.exception.BadMenuSelectException;

public class CalculatorDriver {

    static Reader reader = new Reader();
    static Printer printer = new Printer();

    static Calculator calculator = new Calculator();
    static Recorder recorder = new Recorder();

    public void run(){
        try{
            printer.displayMenu();

            switch(Integer.parseInt(reader.input())){
                case 1 : Menu.DISPLAY_HISTORY.run(); break;
                case 2 : Menu.CALCULATE.run(); break;
                default : throw new NumberFormatException();
            }
        }
        catch(BadMenuSelectException | BadExpressionException e) {
            printer.print(e);
        }
        catch(NumberFormatException e) {
            printer.print("올바른 숫자를 입력해주세요");
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
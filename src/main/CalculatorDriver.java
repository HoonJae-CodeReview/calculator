package src.main;

import src.main.exception.BadExpressionException;
import src.main.exception.BadMenuSelectException;

public class CalculatorDriver {

    static Reader reader = new Reader();
    static Printer printer = new Printer();

    static final MenuItem[] MENU_ITEMS = initMenuItems();

    static MenuSelector menuSelector = new MenuSelector(MENU_ITEMS, reader, printer);
    static Calculator calculator = new Calculator();
    static Recorder recorder = new Recorder(printer);

    public void run(){
        try{
            menuSelector.displayMenu();
            menuSelector.selectMenu();
        }
        catch(BadMenuSelectException | BadExpressionException e) {
            printer.print(e);
        }
    }

    private static MenuItem[] initMenuItems(){
        MenuItem doDisplayHistory = new MenuItem("조회", () -> {
            recorder.displayHistory();
        });

        MenuItem doCalculate = new MenuItem("계산", () -> {
            String expression = reader.input();
            expression = reader.trimExpression(expression);
            long result = calculator.calculate(expression);
            printer.print(result);
            recorder.addHistory(expression, result);
        });

        return new MenuItem[] {
                doDisplayHistory,
                doCalculate
        };
    }

}
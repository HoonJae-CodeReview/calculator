package src.main;

import src.main.exception.BadExpressionException;
import src.main.exception.BadMenuSelectException;

public class CalculatorDriver {

    static Reader reader = new Reader();
    static Printer printer = new Printer();

    enum Menu {
        DISPLAY("조회", () -> {
            recorder.displayHistory();
        }),

        CALCULATE("계산", () -> {
            String expression = reader.input();
            expression = reader.trimExpression(expression);

            long result = recorder.isAlreadyCalculated(expression)
                    ? recorder.getResult(expression)
                    : calculator.calculate(expression);

            printer.print(result);
            recorder.addHistory(expression, result);
        });

        private final String title;
        private final Operation operation;

        Menu(String title, Operation operation) {
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

    static Calculator calculator = new Calculator();
    static Recorder recorder = new Recorder(printer);

    public void run(){
        try{
            System.out.println(Menu.DISPLAY.getTitle());
            System.out.println(Menu.CALCULATE.getTitle());

            switch(Integer.parseInt(reader.input())){
                case 1 : Menu.DISPLAY.run(); break;
                case 2 : Menu.CALCULATE.run(); break;
            }
        }
        catch(BadMenuSelectException | BadExpressionException e) {
            printer.print(e);
        }
        run();
    }

}
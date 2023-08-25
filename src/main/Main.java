package src.main;

import src.main.exception.BadMenuSelectException;

public class Main{

    static Reader reader = new Reader();
    static Printer printer = new Printer();

    static MenuSelector menuSelector = new MenuSelector(initMenuItems(), printer);
    static Calculator calculator = new Calculator();
    static Recorder recorder = new Recorder(printer);

    public static void main(String[] args){

        while(true){
            try{
                menuSelector.displayMenu();

                String inputString = reader.input();
                int selectedMenuItemIndex = menuSelector.inputMenuItemIndex(inputString);
                MenuItem selectedMenuItem = menuSelector.menuItems[selectedMenuItemIndex];

                Operation selectedOperation = selectedMenuItem.getOperation();
                selectedOperation.run();
            }
            catch(BadMenuSelectException e){
                System.err.println(e);
            }
        }
    }

    private static MenuItem[] initMenuItems(){
        MenuItem doDisplayHistory = new MenuItem("조회", () -> {
            recorder.displayHistory();
        });

        MenuItem doCalculate = new MenuItem("계산", () -> {
            String expression = reader.input();
            long result = calculator.calculate(expression);
            printer.println(result);
            recorder.addHistory(expression, result);
        });

        return new MenuItem[] {
                doDisplayHistory,
                doCalculate
        };
    }

}
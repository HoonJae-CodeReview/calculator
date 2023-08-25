package src.main;

import src.main.exception.BadMenuSelectException;

import java.io.*;

public class Main{

    static MenuSelector menuSelector = new MenuSelector(initMenuItems());

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static Calculator calculator = new Calculator();

    static Recorder recorder = new Recorder();

    public static void main(String[] args){

        while(true){
            try{
                menuSelector.displayMenu();

                int selectedMenuItemIndex = menuSelector.inputMenuItemIndex(input());
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
            String expression = input();
            long result = calculator.calculate(expression);
            System.out.println("\n" + result);
            recorder.addHistory(expression, result);
        });

        return new MenuItem[] {
                doDisplayHistory,
                doCalculate
        };
    }

    public static String input(){
        try{
            return bufferedReader.readLine();
        }
        catch(IOException e){
            return "";
        }
    }

}
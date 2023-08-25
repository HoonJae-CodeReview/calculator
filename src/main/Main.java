package src.main;

import src.main.exception.BadMenuSelectException;

import java.io.*;
import java.util.regex.Pattern;

public class Main{

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static Calculator calculator = new Calculator();

    static Recorder recorder = new Recorder();

    static MenuItem[] menuItems;

    public static void main(String[] args) throws IOException {

        menuItems = initMenuItems();

        while(true){
            try{
                displayMenu();

                Operation selectedOperation = menuItems[inputMenuItemIndex()].getOperation();
                selectedOperation.run();
            }
            catch(BadMenuSelectException e){
                System.err.println(e);
            }
        }
    }

    private static MenuItem[] initMenuItems() throws IOException {
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

    public static void displayMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');

        int menuItemCnt = menuItems.length;
        for(int i=0; i<menuItemCnt; i++){
            String title = menuItems[i].getTitle();
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(title);
            stringBuilder.append('\n');
        }
        stringBuilder.append("\n선택 : ");
        System.out.print(stringBuilder);
    }

    public static int inputMenuItemIndex() throws BadMenuSelectException {
        String inputString = input();
        if(!Pattern.matches("\\d+", inputString)){
            throw new BadMenuSelectException("숫자가 아닙니다");
        }

        int selectedMenuIndex = Integer.parseInt(inputString) - 1;
        if(selectedMenuIndex < 0 || selectedMenuIndex >= menuItems.length){
            throw new BadMenuSelectException("해당하는 항목이 없습니다");
        }

        System.out.println();
        return selectedMenuIndex;
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
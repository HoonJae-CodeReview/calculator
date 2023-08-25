package src.main;

import src.main.exception.BadMenuSelectException;

import java.io.*;
import java.util.*;

public class Calculator {

    ArrayList<String> history = new ArrayList<>();
    BufferedReader bufferedReader;

    final MenuItem[] MENU_ITEMS = initMenuItems();

    public Calculator(BufferedReader bufferedReader){
        this.bufferedReader = bufferedReader;
    }
    private MenuItem[] initMenuItems(){
        MenuItem doDisplayHistory = new MenuItem("조회", () -> {
            this.displayHistory();
        });

        MenuItem doCalculate = new MenuItem("계산", () -> {
            String expression = this.input();
            long result = calculate(expression);
            System.out.println("\n" + result);
            addHistory(expression, result);
        });

        return new MenuItem[] {
                doDisplayHistory,
                doCalculate
        };
    }

    public void run() {
        try{
            displayMenu();

            Operation selectedOperation = MENU_ITEMS[inputMenuItemIndex()].getOperation();
            selectedOperation.run();
        }
        catch(BadMenuSelectException e){
            System.err.println(e);
        }
    }
    private void displayMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');

        int menuItemCnt = MENU_ITEMS.length;
        for(int i=0; i<menuItemCnt; i++){
            String title = MENU_ITEMS[i].getTitle();
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(title);
            stringBuilder.append('\n');
        }
        stringBuilder.append("\n선택 : ");
        System.out.print(stringBuilder);
    }
    private int inputMenuItemIndex() throws BadMenuSelectException {
        int selectedMenuIndex;

        try{
            selectedMenuIndex = Integer.parseInt(input()) - 1;
        }
        catch(NumberFormatException e){
            throw new BadMenuSelectException();
        }

        if(selectedMenuIndex < 0 || selectedMenuIndex >= MENU_ITEMS.length){
            throw new BadMenuSelectException();
        }

        System.out.println();
        return selectedMenuIndex;
    }

    private void addHistory(String expression, long result){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(expression);
        stringBuilder.append(" = ");
        stringBuilder.append(result);
        String history = stringBuilder.toString();
        this.history.add(history);
    }
    private void displayHistory(){
        if(this.history.size()==0) return;

        StringBuilder stringBuilder = new StringBuilder();
        this.history.forEach((string -> {
            stringBuilder.append(string);
            stringBuilder.append('\n');
        }));
        System.out.println(stringBuilder);
    }

    private long calculate(String expression){
        StringTokenizer stringTokenizer = new StringTokenizer(expression);

        long resultValue = 0;

        long currentValue = Long.parseLong(stringTokenizer.nextToken());
        char currentSymbol = '+';

        while(stringTokenizer.hasMoreTokens()){
            char nextSymbol = stringTokenizer.nextToken().charAt(0);
            long nextValue = Long.parseLong(stringTokenizer.nextToken());

//            System.out.printf("%s%d  |  %d %s %d %s %d\n",nextSymbol,nextValue,resultValue,currentSymbol,currentValue,nextSymbol,nextValue);

            switch(nextSymbol){
                case '+' :
                case '-' :
                    resultValue = calculateBySymbol(resultValue, currentValue, currentSymbol);  // 덧셈이나 뺄셈만 수행
                    currentValue = nextValue;
                    currentSymbol = nextSymbol;
                    break;
                case '*' :
                case '/' :
                    currentValue = calculateBySymbol(currentValue, nextValue, nextSymbol);
                    break;
                default:
                    //err
            }
        }
        resultValue = calculateBySymbol(resultValue, currentValue, currentSymbol);  // 덧셈이나 뺄셈만 수행

        return resultValue;
    }
    private long calculateBySymbol(long value1, long value2, char Operator){
        switch(Operator){
            case '+' : return value1 + value2;
            case '-' : return value1 - value2;
            case '*' : return value1 * value2;
            case '/' : return value1 / value2;
            default: return Long.MIN_VALUE;
        }
    }

    private String input() {
        try{
            return this.bufferedReader.readLine();
        }
        catch(IOException e){
            return "";
        }
    }
}

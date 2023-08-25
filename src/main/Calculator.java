package src.main;

import java.io.*;
import java.util.*;

public class Calculator {

    ArrayList<String> history = new ArrayList<>();
    BufferedReader bufferedReader;
    MenuItem[] menuItems;

    public Calculator(BufferedReader bufferedReader){
        this.bufferedReader = bufferedReader;
        initMenuItems();
    }
    private void initMenuItems(){
        MenuItem doDisplayHistory = new MenuItem("조회", () -> {
            this.displayHistory();
        });

        MenuItem doCalculate = new MenuItem("계산", () -> {
            String expression = this.input();
            long result = calculate(expression);
            System.out.println("\n" + result);
            addHistory(expression, result);
        });

        menuItems = new MenuItem[] {
            doDisplayHistory,
            doCalculate
        };
    }

    public void run() {
        displayMenu();

        Operation selectedOperation = menuItems[inputMenuItemIndex()].getOperation();
        selectedOperation.run();
    }
    private void displayMenu(){
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
    private int inputMenuItemIndex(){
        int inputNumber = Integer.parseInt(input());
        System.out.println();
        return inputNumber - 1;
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

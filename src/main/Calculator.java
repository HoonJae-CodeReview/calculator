package src.main;

import java.io.*;
import java.util.*;

public class Calculator {

    ArrayList<String> History = new ArrayList<>();
    BufferedReader bufferedReader;

    MenuItem[] MenuItems = {
            new MenuItem("조회", () -> this.displayHistory()),
            new MenuItem("계산", () -> {
                String expression = this.input();
                long result = calculate(expression);
                System.out.println("\n" + result + "\n");
                addHistory(expression, result);
            })
    };

    public Calculator(BufferedReader bufferedReader){
        this.bufferedReader = bufferedReader;
    }

    public void run() {
        showMenu();
        int selectedMenu = Integer.parseInt(input());
        System.out.println();
        MenuItems[selectedMenu - 1].operation.run();
    }

    private void showMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        int menuItemCnt = MenuItems.length;
        for(int i=0; i<menuItemCnt; i++){
            stringBuilder.append(i+1).append(". ").append(MenuItems[i].title).append('\n');
        }
        stringBuilder.append("\n선택 : ");
        System.out.print(stringBuilder);
    }

    private void addHistory(String expression, long result){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(expression).append(" = ").append(result);
        this.History.add(stringBuilder.toString());
    }

    private void displayHistory(){
        if(this.History.size()==0) return;

        StringBuilder stringBuilder = new StringBuilder();
        this.History.forEach((history -> stringBuilder.append(history).append('\n')));
        System.out.println(stringBuilder);
    }

    private long calculate(String expression){
        StringTokenizer stringTokenizer = new StringTokenizer(expression);

        long resultValue = 0;

        long currentValue = Long.parseLong(stringTokenizer.nextToken());
        String currentSymbol = "+";

        while(stringTokenizer.hasMoreTokens()){
            String nextSymbol = stringTokenizer.nextToken();
            long nextValue = Long.parseLong(stringTokenizer.nextToken());

//            System.out.printf("%s%d  |  %d %s %d %s %d\n",nextSymbol,nextValue,resultValue,currentSymbol,currentValue,nextSymbol,nextValue);

            switch(nextSymbol){
                case "+" :
                    switch(currentSymbol){
                        case "+" : resultValue += currentValue; break;
                        case "-" : resultValue -= currentValue; break;
                    }
                    currentValue = nextValue;
                    currentSymbol = "+";
                    break;
                case "-" :
                    switch(currentSymbol){
                        case "+" : resultValue += currentValue; break;
                        case "-" : resultValue -= currentValue; break;
                    }
                    currentValue = nextValue;
                    currentSymbol = "-";
                    break;
                case "*" :
                    currentValue *= nextValue;
                    break;
                case "/" :
                    currentValue /= nextValue;
                    break;
            }
        }

        switch(currentSymbol){
            case "+" : resultValue += currentValue; break;
            case "-" : resultValue -= currentValue; break;
        }

        return resultValue;
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

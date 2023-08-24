package src.main;

import java.io.*;
import java.util.*;

public class Calculator {

    ArrayList<String> History = new ArrayList<>();
    BufferedReader bufferedReader;

    public Calculator(BufferedReader bufferedReader){
        this.bufferedReader = bufferedReader;
    }

    public void run() throws IOException {
        showMenu();
        String input = this.bufferedReader.readLine();
        System.out.println();
        switch(input){
            case "1" :
                displayHistory();
                break;
            case "2" :
                String expression = this.bufferedReader.readLine();
                long result = calculate(expression);
                System.out.println("\n" + result + "\n");
                addHistory(expression, result);
                break;
        }
    }

    private void showMenu(){
        System.out.print("1. 조회\n2. 계산\n\n선택 : ");
    }

    private void addHistory(String expression, long result){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(expression).append(" = ").append(result);
        this.History.add(stringBuilder.toString());
    }

    private void displayHistory(){
        StringBuilder stringBuilder = new StringBuilder();
        History.forEach((history -> stringBuilder.append(history).append('\n')));
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

}

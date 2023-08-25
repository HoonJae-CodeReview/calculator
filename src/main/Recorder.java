package src.main;

import java.util.*;

public class Recorder {

    HashMap<String, Long> history = new HashMap<>();
    Printer printer;

    public Recorder(Printer printer){
        this.printer = printer;
    }

    public void addHistory(String expression, long result){
        String TrimmedExpression = trimExpression(expression);
        this.history.put(TrimmedExpression, result);
    }

    private String trimExpression(String expression){
        StringTokenizer stringTokenizer = new StringTokenizer(expression);
        StringBuilder stringBuilder = new StringBuilder();
        while(true){
            stringBuilder.append(stringTokenizer.nextToken());
            if(!stringTokenizer.hasMoreTokens()){
                break;
            }
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }

    public void displayHistory(){
        if(this.history.size()==0) return;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');

        for(Map.Entry<String, Long> entry: history.entrySet()){
            String expression = entry.getKey();
            Long result = entry.getValue();

            stringBuilder.append(expression);
            stringBuilder.append(" = ");
            stringBuilder.append(result);
            stringBuilder.append('\n');
        }

        printer.print(stringBuilder);
    }

}

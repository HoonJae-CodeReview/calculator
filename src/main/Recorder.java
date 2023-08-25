package src.main;

import java.util.ArrayList;

public class Recorder {

    ArrayList<String> history = new ArrayList<>();

    public void addHistory(String expression, long result){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(expression);
        stringBuilder.append(" = ");
        stringBuilder.append(result);
        String history = stringBuilder.toString();
        this.history.add(history);
    }

    public void displayHistory(){
        if(this.history.size()==0) return;

        StringBuilder stringBuilder = new StringBuilder();
        this.history.forEach((string -> {
            stringBuilder.append(string);
            stringBuilder.append('\n');
        }));
        System.out.println(stringBuilder);
    }

}

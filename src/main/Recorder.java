package src.main;

import java.util.*;

public class Recorder {

    private LinkedHashMap<String, Long> history = new LinkedHashMap<>();

    public void addHistory(String expression, long result){
        this.history.put(expression, result);
    }

    public String getHistory(){
        StringBuilder stringBuilder = new StringBuilder();

        for(Map.Entry<String, Long> entry: this.history.entrySet()){
            String expression = entry.getKey();
            Long result = entry.getValue();

            stringBuilder.append(expression);
            stringBuilder.append(" = ");
            stringBuilder.append(result);
            stringBuilder.append('\n');
        }

        return stringBuilder.toString();
    }

    public boolean isAlreadyCalculated(String expression){
        return this.history.containsKey(expression);
    }

    public Long getResult(String expression){
        return this.history.get(expression);
    }
}

package src.main;

import java.util.*;

public class Recorder {

    private Map<String, Long> history = new LinkedHashMap<>();

    public void addHistory(String expression, long result){
        this.history.put(expression, result);
    }

    public String getHistory(){
        StringBuilder stringBuilder = new StringBuilder();

        history.forEach((expression, result) -> {
            stringBuilder.append(expression);
            stringBuilder.append(" = ");
            stringBuilder.append(result);
            stringBuilder.append('\n');
        });

        return stringBuilder.toString();
    }

    public boolean isAlreadyCalculated(String expression){
        return this.history.containsKey(expression);
    }

    public Long getResult(String expression){
        return this.history.get(expression);
    }
}

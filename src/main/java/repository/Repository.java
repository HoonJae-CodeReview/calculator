package repository;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    static List<String> result = new ArrayList<>();

    public void store(String expression){
        result.add(expression);
    }

    public List<String> getResult(){
        return result;
    }

}

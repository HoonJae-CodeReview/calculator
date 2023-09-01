package repository;

import java.util.LinkedHashMap;
import java.util.List;

public class Repository {

    LinkedHashMap<String,String> map = new LinkedHashMap<>();

    public void store(String expression,String result){
        map.put(expression,result);

    }

    public LinkedHashMap<String, String> getResult(){
        return map;
    }

}

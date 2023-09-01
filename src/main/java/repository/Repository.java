package repository;

import java.util.LinkedHashMap;

public class Repository {

  private static LinkedHashMap<String, String> map = new LinkedHashMap<>();

  public void store(String expression, String result) {
    map.put(expression, result);

  }

  public LinkedHashMap<String, String> getResult() {
    return map;
  }

}

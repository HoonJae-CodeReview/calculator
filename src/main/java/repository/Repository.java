package repository;

import java.util.ArrayList;
import java.util.List;

public class Repository {

  private List<String> list = new ArrayList<>();

  public void store(String expression, String result) {
    list.add(expression + result);

  }

  public List<String> getResult() {
    return list;
  }

}

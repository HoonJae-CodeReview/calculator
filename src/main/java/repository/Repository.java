package repository;

import java.util.ArrayList;
import java.util.List;

public class Repository {

  private List<String> list = new ArrayList<>();

  public void store(String expression, String result) {
    StringBuilder formattedExpression = new StringBuilder(expression).append(" = ").append(result);
    list.add(formattedExpression.toString());

  }

  public List<String> getResult() {
    return list;
  }

}

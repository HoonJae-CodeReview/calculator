package output;


import java.util.LinkedHashMap;
import java.util.Map;

public class ConsoleOutput implements Output {

  @Override
  public void printOperationResult() {
    LinkedHashMap<String, String> result = repository.getResult();
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry<String, String> entry : result.entrySet()) {
      String key = entry.getKey();
      String value = entry.getValue();
      stringBuilder.append(key).append(" = ").append(value).append("\n");
    }
    System.out.println(stringBuilder);
  }

  @Override
  public void print(String msg) {
    System.out.println(msg);
  }


}

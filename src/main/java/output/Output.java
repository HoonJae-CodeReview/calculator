package output;

import java.util.List;
import repository.Repository;

public interface Output {


  public void print(List<String> result);

  public void print(String msg);

  public void displayOptions();
}

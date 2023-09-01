package input;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

  public String selectInput() {
    String selectInput = "";
    try {
      selectInput = bufferedReader.readLine();
    } catch (IOException e) {
      selectInput = "";
    }
    return selectInput;
  }

  public String expressionInput() {
    String expressionInput = "";
    try {
      expressionInput = bufferedReader.readLine();
    } catch (IOException e) {
      expressionInput = "";
    }
    return expressionInput;
  }
}

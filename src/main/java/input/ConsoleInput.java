package input;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {

  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

  public String SelectInput() {
    String selectInput = "";
    try {
      selectInput = bufferedReader.readLine();
    } catch (IOException e) {
      throw new IllegalArgumentException("잘못된 옵션 선택입니다.");
    }
    return selectInput;
  }

  public String ExpressionInput() {
    String expressionInput = "";
    try {
      expressionInput = bufferedReader.readLine();
    } catch (IOException e) {
      throw new IllegalArgumentException("잘못된 식 입력입니다.");
    }
    return expressionInput;
  }
}

package output;


import java.util.List;

public class ConsoleOutput implements Output {

  @Override
  public void print(List<String> result) {
    result.stream().forEach(System.out::println);
  }

  @Override
  public void print(String msg) {
    System.out.println(msg);
  }

  @Override
  public void displayOptions() {
    System.out.println("1.조회");
    System.out.println("2.계산");
    System.out.println();
    System.out.print("선택 : ");
  }


}

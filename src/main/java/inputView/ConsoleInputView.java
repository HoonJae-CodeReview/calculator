package inputView;


public class ConsoleInputView implements InputView {

  @Override
  public void displayOptions() {
    System.out.println("1.조회");
    System.out.println("2.계산");
    System.out.println();
    System.out.print("선택 : ");
  }

}

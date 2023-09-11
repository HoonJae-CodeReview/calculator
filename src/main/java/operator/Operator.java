package operator;

public enum Operator {
  PLUS("+"), MINUS("-"), DIVIDE("/"), MULTIPLY("*");

  private final String value;

  Operator(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public static Operator stringToOperator(String value){
    for(Operator operator: Operator.values()){
      if(operator.getValue().equals(value)) {
        return operator;
      }
    }
    throw new IllegalArgumentException("잘못된 입력값 입니다.");
  }

}

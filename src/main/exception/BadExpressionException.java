package src.main.exception;

public class BadExpressionException extends RuntimeException{
    public BadExpressionException(){
        super("올바른 계산식을 입력해주세요");
    }
    public BadExpressionException(String msg){
        super("올바른 계산식을 입력해주세요: " + msg);
    }
}

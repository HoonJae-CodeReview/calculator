package src.main.exception;

public class BadMenuSelectException extends RuntimeException {
    public BadMenuSelectException(){
        super("제시된 메뉴에서 선택해주세요");
    }
}

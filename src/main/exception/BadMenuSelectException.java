package src.main.exception;

public class BadMenuSelectException extends RuntimeException {
    public BadMenuSelectException(String msg){
        super(msg);
    }
}

package PJFramework;

public class PJException extends Exception {
    public PJException(String message) {
        super(message);
    }

    public PJException(String message, Throwable cause) {
        super(message, cause);
    }
}
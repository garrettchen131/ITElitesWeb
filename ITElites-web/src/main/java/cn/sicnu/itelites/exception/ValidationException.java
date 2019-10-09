package cn.sicnu.itelites.exception;


public class ValidationException extends Exception {
    public ValidationException(String reason) {
        super(reason);
    }
}

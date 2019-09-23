package cn.sicnu.itelites.exception;

public class OperationException extends RuntimeException {

    private int error;
    private String reason;

    public OperationException(int error, String reason) {
        super(reason);
        this.error = error;
        this.reason = reason;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

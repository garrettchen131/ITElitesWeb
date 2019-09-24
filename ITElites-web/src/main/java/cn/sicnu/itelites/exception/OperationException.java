package cn.sicnu.itelites.exception;

public class OperationException extends RuntimeException {

    private int error;

    public OperationException(int error, String reason) {
        super(reason);
        this.error = error;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }


}

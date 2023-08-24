package worldcompetitionrockscissorpaper;

public class SqlErrorException extends RuntimeException{
    public SqlErrorException() {
        super();
    }

    public SqlErrorException(String message) {
        super(message);
    }

    public SqlErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}

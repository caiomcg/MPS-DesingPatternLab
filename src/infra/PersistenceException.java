package infra;

public class PersistenceException extends Exception {

    public PersistenceException() {
        super("Persistence Error.");
    }

    public PersistenceException(String message) {
        super(message);
    }
}

package ecxeption;

public class CandidateValidationException extends RuntimeException {
    public CandidateValidationException(String message) {
        super(message);
    }
}

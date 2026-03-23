package ar.dev.josecammisi.web.reservation_backend.exception;

/**
 * Exception thrown when a requested reservation is not found.
 */
public class ReservationNotFoundException extends RuntimeException {
    
    public ReservationNotFoundException(String message) {
        super(message);
    }
    
    public ReservationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

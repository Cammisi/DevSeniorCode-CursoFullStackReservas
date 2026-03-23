package ar.dev.josecammisi.web.reservation_backend.exception;

/**
 * Exception thrown when a reservation conflict is detected
 * (e.g., another reservation already exists for the same date and time).
 */
public class ReservationConflictException extends RuntimeException {
    
    public ReservationConflictException(String message) {
        super(message);
    }
    
    public ReservationConflictException(String message, Throwable cause) {
        super(message, cause);
    }
}

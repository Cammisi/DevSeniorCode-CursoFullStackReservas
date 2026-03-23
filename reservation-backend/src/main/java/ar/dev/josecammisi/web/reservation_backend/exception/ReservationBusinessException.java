package ar.dev.josecammisi.web.reservation_backend.exception;

/**
 * Excepción personalizada para violaciones de reglas de negocio en operaciones de reserva
 */
public class ReservationBusinessException extends RuntimeException {
    
    public ReservationBusinessException(String message) {
        super(message);
    }
    
    public ReservationBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}

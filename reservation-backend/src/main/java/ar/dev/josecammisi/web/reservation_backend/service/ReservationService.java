package ar.dev.josecammisi.web.reservation_backend.service;

import org.springframework.stereotype.Service;

import ar.dev.josecammisi.web.reservation_backend.exception.ReservationBusinessException;
import ar.dev.josecammisi.web.reservation_backend.exception.ReservationConflictException;
import ar.dev.josecammisi.web.reservation_backend.exception.ReservationNotFoundException;
import ar.dev.josecammisi.web.reservation_backend.model.Reservation;
import ar.dev.josecammisi.web.reservation_backend.model.ReservationStatus;
import ar.dev.josecammisi.web.reservation_backend.repository.ReservationRepository;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    
    /**
     * Creates a new reservation validating that no other reservation exists
     * for the same date and time.
     *
     * @param reservation the reservation to create
     * @return the created reservation
     * @throws ReservationConflictException if a reservation already exists for that date and time
     */
    public Reservation createReservation(Reservation reservation) {
        if (reservationRepository.existsByDateAndTime(reservation.getDate(), reservation.getTime())) {
            throw new ReservationConflictException(
                "Reservation already exists for date " + reservation.getDate() + 
                " at " + reservation.getTime()
            );
        }
        reservation.setStatus(ReservationStatus.ACTIVE);
        return reservationRepository.save(reservation);
    }
    
    /**
     * Cancels a reservation by its id.
     *
     * @param id the id of the reservation to cancel
     * @return the cancelled reservation
     * @throws ReservationNotFoundException if the reservation does not exist
     * @throws ReservationBusinessException if the reservation is already cancelled
     */
    public Reservation cancelReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
            .orElseThrow(() -> new ReservationNotFoundException(
                "Reservation with id " + id + " not found"
            ));
        if (reservation.getStatus() == ReservationStatus.CANCELLED) {
            throw new ReservationBusinessException(
                "Reservation with id " + id + " is already cancelled"
            );
        }
        reservation.setStatus(ReservationStatus.CANCELLED);
        return reservationRepository.save(reservation);
    }
}

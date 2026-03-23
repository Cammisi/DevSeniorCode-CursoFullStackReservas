package ar.dev.josecammisi.web.reservation_backend.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.dev.josecammisi.web.reservation_backend.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    
    /**
     * Verifica si existe una reserva para una fecha y hora específicas
     * @param date la fecha de la reserva
     * @param time la hora de la reserva
     * @return true si existe una reserva para esa fecha y hora, false en caso contrario
     */
    boolean existsByDateAndTime(LocalDate date, LocalTime time);
}

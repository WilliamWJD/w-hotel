package com.wjd.hotel.repository;

import com.wjd.hotel.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query("SELECT r FROM Reserva r WHERE r.quarto.id = :quartoId AND r.checkOut > :dataCheckIn OR r.checkIn = :dataCheckIn")
    Optional<Reserva> verificarDisponibilidadeDeQuarto(@Param("quartoId") final Long quartoId, @Param("dataCheckIn") final LocalDate dataCheckIn);
    @Query("SELECT r FROM Reserva r WHERE r.quarto.id = :quartoId AND r.checkOut > :dataCheckIn AND r.id <> :reservaId")
    Optional<Reserva> verificarDisponibilidadeDeQuarto(@Param("quartoId") final Long quartoId, @Param("dataCheckIn") final LocalDate dataCheckIn, @Param("reservaId") final Long reservaId);
}

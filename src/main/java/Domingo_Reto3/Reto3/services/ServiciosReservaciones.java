package Domingo_Reto3.Reto3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Domingo_Reto3.Reto3.model.Reservaciones;
import Domingo_Reto3.Reto3.repository.RepositorioReservaciones;

@Service
public class ServiciosReservaciones {
    @Autowired
    private RepositorioReservaciones metodosCrud;

    public List<Reservaciones> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Reservaciones> getReservaciones(int idReservaciones) {
        return metodosCrud.getReservation(idReservaciones);
    }

    public Reservaciones save(Reservaciones reservaciones) {
        if (reservaciones.getIdReservation() == null) {
            return metodosCrud.save(reservaciones);
        } else {
            Optional<Reservaciones> e = metodosCrud.getReservation(reservaciones.getIdReservation());
            if (e.isEmpty()) {
                return metodosCrud.save(reservaciones);
            } else {
                return reservaciones;
            }
        }
    }

    public Reservaciones update(Reservaciones reservaciones) {
        if (reservaciones.getIdReservation() != null) {
            Optional<Reservaciones> e = metodosCrud.getReservation(reservaciones.getIdReservation());
            if (!e.isEmpty()) {
                if (reservaciones.getStartDate() != null) {
                    e.get().setStartDate(reservaciones.getStartDate());
                }
                if (reservaciones.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservaciones.getDevolutionDate());
                }
                if (reservaciones.getStatus() != null) {
                    e.get().setStatus(reservaciones.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return reservaciones;
            }
        } else {
            return reservaciones;
        }
    }

    public boolean deleteReservacion(int reservationId) {
        Boolean aBolean = getReservaciones(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBolean;
    }

}

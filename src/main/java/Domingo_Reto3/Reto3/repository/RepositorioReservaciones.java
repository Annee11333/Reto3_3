package Domingo_Reto3.Reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Domingo_Reto3.Reto3.interfaces.InterfaceReservaciones;
import Domingo_Reto3.Reto3.model.Reservaciones;

@Repository
public class RepositorioReservaciones {

    @Autowired
    private InterfaceReservaciones crud3;

    public List<Reservaciones> getAll() {
        return (List<Reservaciones>) crud3.findAll();
    }

    public Optional<Reservaciones> getReservation(int id) {
        return crud3.findById(id);
    }

    public Reservaciones save(Reservaciones reservations) {
        return crud3.save(reservations);
    }

    public void delete(Reservaciones reservations) {
        crud3.delete(reservations);
    }
}

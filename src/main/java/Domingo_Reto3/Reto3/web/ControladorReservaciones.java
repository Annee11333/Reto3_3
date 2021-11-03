package Domingo_Reto3.Reto3.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Domingo_Reto3.Reto3.model.Reservaciones;
import Domingo_Reto3.Reto3.services.ServiciosReservaciones;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ControladorReservaciones {
    @Autowired
    private ServiciosReservaciones servicio;

    @GetMapping("/all")
    public List<Reservaciones> getReservaciones() {
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservaciones> getReservaciones(@PathVariable("id") int reservationId) {
        return servicio.getReservaciones(reservationId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones save(@RequestBody Reservaciones reservacion) {
        return servicio.save(reservacion);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones update(@RequestBody Reservaciones reservacion) {
        return servicio.update(reservacion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delete(@PathVariable("id") int reservationId) {
        return servicio.deleteReservacion(reservationId);

    }
}

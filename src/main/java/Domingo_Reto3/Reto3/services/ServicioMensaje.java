package Domingo_Reto3.Reto3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Domingo_Reto3.Reto3.model.Mensaje;
import Domingo_Reto3.Reto3.repository.RepositorioMensaje;

@Service
public class ServicioMensaje {
    @Autowired
    private RepositorioMensaje metodosCrud;

    public List<Mensaje> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Mensaje> getMensaje(int idMensaje) {
        return metodosCrud.getMessage(idMensaje);
    }

    public Mensaje save(Mensaje message) {
        if (message.getIdMessage() == null) {
            return metodosCrud.save(message);
        } else {
            Optional<Mensaje> e = metodosCrud.getMessage(message.getIdMessage());
            if (e.isEmpty()) {
                return metodosCrud.save(message);
            } else {
                return message;
            }
        }
    }

    public Mensaje update(Mensaje message) {
        if (message.getIdMessage() != null) {
            Optional<Mensaje> e = metodosCrud.getMessage(message.getIdMessage());
            if (!e.isEmpty()) {
                if (message.getMessageText() != null) {
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public boolean deleteMensaje(int mensajeId) {
        Boolean aBolean = getMensaje(mensajeId).map(mensaje -> {
            metodosCrud.delete(mensaje);
            return true;
        }).orElse(false);
        return aBolean;
    }

}

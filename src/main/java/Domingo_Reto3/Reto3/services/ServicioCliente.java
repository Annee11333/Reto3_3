package Domingo_Reto3.Reto3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Domingo_Reto3.Reto3.model.Cliente;
import Domingo_Reto3.Reto3.repository.RepositorioCliente;

@Service
public class ServicioCliente {
    @Autowired
    private RepositorioCliente metodosCrud;

    public List<Cliente> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Cliente> getCliente(int idCliente) {
        return metodosCrud.getCliente(idCliente);
    }

    public Cliente save(Cliente cliente) {
        if (cliente.getIdClient() == null) {
            return metodosCrud.save(cliente);
        } else {
            Optional<Cliente> e = metodosCrud.getCliente(cliente.getIdClient());
            if (e.isEmpty()) {
                return metodosCrud.save(cliente);
            } else {
                return cliente;
            }
        }
    }

    public Cliente update(Cliente cliente) {
        if (cliente.getIdClient() != null) {
            Optional<Cliente> e = metodosCrud.getCliente(cliente.getIdClient());
            if (!e.isEmpty()) {
                if (cliente.getName() != null) {
                    e.get().setName(cliente.getName());
                }
                if (cliente.getEmail() != null) {
                    e.get().setEmail(cliente.getEmail());
                }
                if (cliente.getPassword() != null) {
                    e.get().setPassword(cliente.getPassword());
                }
                if (cliente.getAge() != null) {
                    e.get().setAge(cliente.getAge());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return cliente;
            }
        } else {
            return cliente;
        }
    }

    public boolean deleteCliente(int clienteId) {
        Boolean aBolean = getCliente(clienteId).map(cliente -> {
            metodosCrud.delete(cliente);
            return true;
        }).orElse(false);
        return aBolean;
    }
}

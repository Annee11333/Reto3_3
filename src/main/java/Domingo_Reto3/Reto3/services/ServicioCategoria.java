package Domingo_Reto3.Reto3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Domingo_Reto3.Reto3.model.Categoria;
import Domingo_Reto3.Reto3.repository.RepositorioCategoria;

@Service
public class ServicioCategoria {
    @Autowired
    private RepositorioCategoria metodosCrud;

    public List<Categoria> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Categoria> getCategoria(int idCategoria) {
        return metodosCrud.getCategoria(idCategoria);
    }

    public Categoria save(Categoria categoria) {
        if (categoria.getId() == null) {
            return metodosCrud.save(categoria);
        } else {
            Optional<Categoria> evt = metodosCrud.getCategoria(categoria.getId());
            if (evt.isEmpty()) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }

    public Categoria update(Categoria categoria) {
        if (categoria.getId() != null) {
            Optional<Categoria> e = metodosCrud.getCategoria(categoria.getId());
            if (!e.isEmpty()) {
                if (categoria.getName() != null) {
                    e.get().setName(categoria.getName());
                }
                if (categoria.getDescription() != null) {
                    e.get().setDescription(categoria.getDescription());
                }
                
                return metodosCrud.save(e.get());
            } else {
                return categoria;
            }
        } else {
            return categoria;
        }
    }

    public boolean deleteCategoria(int categoriaId) {
        Boolean d = getCategoria(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
}

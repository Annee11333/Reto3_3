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

import Domingo_Reto3.Reto3.model.Costume;
import Domingo_Reto3.Reto3.services.ServicioCostume;

@RestController
@RequestMapping("/api/Costume")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ControladorCostume {
    @Autowired
    private ServicioCostume servicio;

    @GetMapping("/all")
    public List<Costume> getCostumes() {
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Costume> getCostume(@PathVariable("id") int costumeId) {
        return servicio.getCostume(costumeId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume save(@RequestBody Costume costume) {
        return servicio.save(costume);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume update(@RequestBody Costume costume) {
        return servicio.update(costume);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delete(@PathVariable("id") int costumeId) {
        return servicio.deleteCostume(costumeId);

    }

}

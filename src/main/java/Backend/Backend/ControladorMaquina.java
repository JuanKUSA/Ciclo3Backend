/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Backend;

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

/**
 *
 * @author Juan Valero
 */


@RestController
@RequestMapping("/api/Machine")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorMaquina {
     @Autowired
    private ServiciosMaquina servicio;
    @GetMapping("/all")
    public List<Maquina> getMaquina(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Maquina> getMaquina(@PathVariable("id") int maquinaId) {
        return servicio.getMaquina(maquinaId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Maquina save(@RequestBody Maquina maquina) {
        return servicio.save(maquina);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Maquina update(@RequestBody Maquina maquina) {
        return servicio.update(maquina);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int maquinaId) {
        return servicio.deleteMaquina(maquinaId);
    } 
}
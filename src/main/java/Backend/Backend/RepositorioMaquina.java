/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Backend;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Valero
 */
@Repository
public class RepositorioMaquina {
    
    @Autowired
    private InterfaceMaquina crud;

    public List<Maquina> getAll(){
        return (List<Maquina>) crud.findAll();
    }

    public Optional<Maquina> getMaquina(int id){
        return crud.findById(id);
    }

    public Maquina save(Maquina machine){
        return crud.save(machine);
    }
    public void delete(Maquina machine){
        crud.delete(machine);
    }
    
}

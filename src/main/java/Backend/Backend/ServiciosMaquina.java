/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Backend;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Valero
 */
@Service
public class ServiciosMaquina {
     @Autowired
    private RepositorioMaquina metodosCrud;

    public List<Maquina> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Maquina> getMaquina(int machineId) {
        return metodosCrud.getMaquina(machineId);
    }

    public Maquina save(Maquina machine){
        if(machine.getId()==null){
            return metodosCrud.save(machine);
        }else{
            Optional<Maquina> e=metodosCrud.getMaquina(machine.getId());
            if(e.isEmpty()){
                return metodosCrud.save(machine);
            }else{
                return machine;
            }
        }
    }

    public Maquina update(Maquina machine){
        if(machine.getId()!=null){
            Optional<Maquina> e=metodosCrud.getMaquina(machine.getId());
            if(!e.isEmpty()){
                if(machine.getName()!=null){
                    e.get().setName(machine.getName());
                }
                if(machine.getBrand()!=null){
                    e.get().setBrand(machine.getBrand());
                }
                if(machine.getYear()!=null){
                    e.get().setYear(machine.getYear());
                }
                if(machine.getDescription()!=null){
                    e.get().setDescription(machine.getDescription());
                }
                if(machine.getCategory()!=null){
                    e.get().setCategory(machine.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return machine;
            }
        }else{
            return machine;
        }
    }
 

    public boolean deleteMaquina(int machineId) {
        Boolean aBoolean = getMaquina(machineId).map(machine -> {
            metodosCrud.delete(machine);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}


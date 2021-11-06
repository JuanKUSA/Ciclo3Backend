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

    public Optional<Maquina> getMaquina(int maquinaId) {
        return metodosCrud.getMaquina(maquinaId);
    }

    public Maquina save(Maquina maquina){
        if(maquina.getId()==null){
            return metodosCrud.save(maquina);
        }else{
            Optional<Maquina> e=metodosCrud.getMaquina(maquina.getId());
            if(e.isEmpty()){
                return metodosCrud.save(maquina);
            }else{
                return maquina;
            }
        }
    }

    public Maquina update(Maquina maquina){
        if(maquina.getId()!=null){
            Optional<Maquina> e=metodosCrud.getMaquina(maquina.getId());
            if(!e.isEmpty()){
                if(maquina.getName()!=null){
                    e.get().setName(maquina.getName());
                }
                if(maquina.getBrand()!=null){
                    e.get().setBrand(maquina.getBrand());
                }
                if(maquina.getYear()!=null){
                    e.get().setYear(maquina.getYear());
                }
                if(maquina.getDescription()!=null){
                    e.get().setDescription(maquina.getDescription());
                }
                if(maquina.getCategory()!=null){
                    e.get().setCategory(maquina.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return maquina;
            }
        }else{
            return maquina;
        }
    }
 

    public boolean deleteMaquina(int maquinaId) {
        Boolean aBoolean = getMaquina(maquinaId).map(maquina -> {
            metodosCrud.delete(maquina);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}


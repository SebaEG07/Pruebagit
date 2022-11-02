package com.estudiantedeprogramacion.estudianteProgramacion.model.service;

import com.estudiantedeprogramacion.estudianteProgramacion.model.Curso;
import com.estudiantedeprogramacion.estudianteProgramacion.model.Tema;
import com.estudiantedeprogramacion.estudianteProgramacion.repository.ITemaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaService implements ITemaService {

    @Autowired
    private ITemaRepository temaRepo;
    
    @Override
    public void saveTema(Tema tem) {
        temaRepo.save(tem);
    }

    @Override
    public void deleteTema(Long id) {
        temaRepo.deleteById(id);
    }
    
    @Override
    public Tema findTema(Long id) {
       return temaRepo.findById(id).orElse(null);
    }

    @Override
    public void editTema(Long idOriginal, Long idNueva, String nuevoNombre, String descripcionNueva) {
        

        //se busca el tema a editar
        Tema tem = this.findTema(idOriginal);
        
        //proceso de modificacion a nivel logico
        tem.setId_tema(idNueva);
        tem.setNombre(nuevoNombre);
        tem.setDescripcion(descripcionNueva);
        
        //por ultimo se guardan los cambios
        this.saveTema(tem);
    }

    @Override
    public void editTema(Tema tem) {
        this.saveTema(tem);
    }

    @Override
    public List<Tema> getTemas() {
        return temaRepo.findAll();
    }

    
    
}

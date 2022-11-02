package com.estudiantedeprogramacion.estudianteProgramacion.model.service;

import com.estudiantedeprogramacion.estudianteProgramacion.dto.CursoTemaDTO;
import com.estudiantedeprogramacion.estudianteProgramacion.model.Curso;
import com.estudiantedeprogramacion.estudianteProgramacion.repository.ICursoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private ICursoRepository cursoRepo;
    
    @Override
    public void saveCurso(Curso cur) {
        cursoRepo.save(cur);
    }

    @Override
    public void deleteCurso(long id) {
        cursoRepo.deleteById(id);
    }

    @Override
    public List<Curso> getCursos() {
        List<Curso> listaCursos = cursoRepo.findAll();
        return listaCursos;
    }

    @Override
    public Curso findCurso(long id) {
        return cursoRepo.findById(id).orElse(null);
    }
    
     @Override
    public CursoTemaDTO temasPorCurso(Long id_curso) {
        CursoTemaDTO curTemDTO = new CursoTemaDTO();
        Curso cur = this.findCurso(id_curso);
        curTemDTO.setNombreCurso(cur.getNombre());
        curTemDTO.setListaTemas(cur.getListaDeTemas());
        
        return curTemDTO;
    }

    @Override
    public List<Curso> getCursosJava() {
        List<Curso> listCur = this.getCursos();
        List<Curso> listCurJava = new ArrayList<>();
        String palabra = "Java";
        String textoComparar;
        //se recorre la lista de cursos y se analiza si su nombre contiene "java"
        //si contiene, se le agrega a otra lista que luego sera retornada
        for (Curso i:listCur){
            textoComparar = i.getNombre();
            boolean contiene = textoComparar.contains(palabra);
            if (contiene == true){
                listCurJava.add(i);
            }
        }
        
        return listCurJava;
    }

    @Override
    public void editCurso(long idOriginal, long idNueva, String nuevoNombre, String nuevaModalidad, String nuevaFecha_finalizacion) {
        
        Curso cur = this.findCurso(idOriginal);
        
        cur.setId_curso(idNueva);
        cur.setNombre(nuevoNombre);
        cur.setModalidad(nuevaModalidad);
        cur.setFecha_finalizacion(nuevaFecha_finalizacion);
        
        this.saveCurso(cur);
    }

    @Override
    public void editCurso(Curso cur) {
        this.saveCurso(cur);
    }

   
    
}

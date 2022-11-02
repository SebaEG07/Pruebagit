package com.estudiantedeprogramacion.estudianteProgramacion.model.service;

import com.estudiantedeprogramacion.estudianteProgramacion.dto.CursoTemaDTO;
import com.estudiantedeprogramacion.estudianteProgramacion.model.Curso;
import java.util.List;

public interface ICursoService {
    
    //Alta
    public void saveCurso(Curso cur);
    
    //Baja
    public void deleteCurso(long id);
    
    //Lectura de todos los cursos
    public List<Curso> getCursos();
    
    //Lectura de un solo curso
    public Curso findCurso(long id);
    
    //Obtener todos los temas de un curso
    public CursoTemaDTO temasPorCurso(Long id_curso);
    
    //Lectura de todos los cursos que contengan en su nombre "Java"
    public List<Curso> getCursosJava();
    
    //Modificacion
    public void editCurso (long idOriginal, long idNueva,
                          String nuevoNombre,
                          String nuevaModalidad,
                          String nuevaFecha_finalizacion);

    public void editCurso(Curso cur);
}

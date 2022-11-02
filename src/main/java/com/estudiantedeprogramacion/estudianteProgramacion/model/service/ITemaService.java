package com.estudiantedeprogramacion.estudianteProgramacion.model.service;

import com.estudiantedeprogramacion.estudianteProgramacion.model.Curso;
import com.estudiantedeprogramacion.estudianteProgramacion.model.Tema;
import java.util.List;



public interface ITemaService {
    
    //metodo Alta para crear tema
    public void saveTema(Tema tem);
    
    //metodo Lectura para obtener todos los temas
    public List<Tema> getTemas();
    
    //metodo Baja para eliminar un tema de un curso
    public void deleteTema(Long id);
    
    //metodo Lectura de un solo tema
    public Tema findTema(Long id);
    
    //metodo Modificacion para los datos de un tema
    public void editTema(Long idOriginal, 
                         Long idNueva,
                         String nuevoNombre,
                         String descripcionNueva);
    
    public void editTema(Tema tem);
}

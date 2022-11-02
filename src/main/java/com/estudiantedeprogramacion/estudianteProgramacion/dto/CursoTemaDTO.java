package com.estudiantedeprogramacion.estudianteProgramacion.dto;

import com.estudiantedeprogramacion.estudianteProgramacion.model.Tema;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class CursoTemaDTO {
    
    private String nombreCurso;
    private List<Tema> listaTemas;

    public CursoTemaDTO() {
    }

    public CursoTemaDTO(String nombreCurso, List<Tema> listaTemas) {
        this.nombreCurso = nombreCurso;
        this.listaTemas = listaTemas;
    }
    
    
    
}

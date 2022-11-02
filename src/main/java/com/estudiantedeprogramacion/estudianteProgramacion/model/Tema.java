package com.estudiantedeprogramacion.estudianteProgramacion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_tema;
    private String nombre;
    private String descripcion;

    public Tema() {
    }

    public Tema(long id_tema, String nombre, String descripcion) {
        this.id_tema = id_tema;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    
    
}

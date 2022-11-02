package com.estudiantedeprogramacion.estudianteProgramacion.repository;

import com.estudiantedeprogramacion.estudianteProgramacion.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepository extends JpaRepository<Curso,Long>{
    
}

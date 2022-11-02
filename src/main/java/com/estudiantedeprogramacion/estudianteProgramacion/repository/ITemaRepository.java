package com.estudiantedeprogramacion.estudianteProgramacion.repository;

import com.estudiantedeprogramacion.estudianteProgramacion.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITemaRepository extends JpaRepository<Tema,Long> {
    
}

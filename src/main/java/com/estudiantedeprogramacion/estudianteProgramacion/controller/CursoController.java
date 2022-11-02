package com.estudiantedeprogramacion.estudianteProgramacion.controller;

import com.estudiantedeprogramacion.estudianteProgramacion.dto.CursoTemaDTO;
import com.estudiantedeprogramacion.estudianteProgramacion.model.Curso;
import com.estudiantedeprogramacion.estudianteProgramacion.model.service.ICursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {

    @Autowired
    private ICursoService curServ;

    @PostMapping("/curso/crear")
    public String saveCurso(@RequestBody Curso cur) {
        curServ.saveCurso(cur);
        return "Curso creado correctamente";
    }

    @DeleteMapping("/curso/borrar/{id_curso}")
    public String deleteCurso(@PathVariable long id_curso) {
        curServ.deleteCurso(id_curso);
        return "Curso eliminado correctamente";
    }

    @GetMapping("/cursos/traer")
    public List<Curso> getCursos() {
        List<Curso> listaCur = curServ.getCursos();
        return listaCur;
    }

    @GetMapping("/curso/traer/{id_curso}")
    public Curso findCurso(@PathVariable long id_curso) {

        return curServ.findCurso(id_curso);

    }

    @GetMapping ("/cursos/temas/{id_curso}")
    public CursoTemaDTO temasPorCurso (@PathVariable Long id_curso) {
        return curServ.temasPorCurso(id_curso);
    }
    
    @GetMapping("/curso/java/traer")
    public List<Curso> getCursosJava() {
        List<Curso> listJavaCursos = curServ.getCursosJava();
        return listJavaCursos;
    }

    @PutMapping("/curso/editar/{id_original}")
    public Curso editCurso(@PathVariable long id_original,
                           @RequestParam(required = false, name = "id_curso") long idNueva,
                           @RequestParam(required = false, name = "nombre") String nuevoNombre,
                           @RequestParam(required = false, name = "modalidad") String nuevaModalidad,
                           @RequestParam(required = false, name = "fecha_finalizacion") String nuevaFecha_finalizacion) {

        curServ.editCurso(id_original, idNueva, nuevoNombre, nuevaModalidad, nuevaFecha_finalizacion);
        
        return curServ.findCurso(idNueva);
    }
    
    @PutMapping ("/curso/editar")
    public Curso editCurso(@RequestBody Curso cur){
        curServ.editCurso(cur);
        
        return this.findCurso(cur.getId_curso());
    }
    
}

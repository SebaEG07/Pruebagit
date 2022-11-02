package com.estudiantedeprogramacion.estudianteProgramacion.controller;

import com.estudiantedeprogramacion.estudianteProgramacion.model.Curso;
import com.estudiantedeprogramacion.estudianteProgramacion.model.Tema;
import com.estudiantedeprogramacion.estudianteProgramacion.model.service.ITemaService;
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
public class TemaController {
    
 @Autowired
 private ITemaService temServ;
 
 @PostMapping("/tema/crear")
    public String saveTema(@RequestBody Tema tem) {
        temServ.saveTema(tem);
        return "Tema creado correctamente";
    }
    
 @DeleteMapping("/tema/borrar/{id_tema}")
    public String deleteTema(@PathVariable long id_tema) {
        temServ.deleteTema(id_tema);
        return "Tema eliminado correctamente";
    }
    
 @GetMapping ("/tema/traer/{id_tema}")
    public Tema findTema(@PathVariable Long id_tema){
        return temServ.findTema(id_tema);
    }
    
 @GetMapping ("/temas/traer/")
    public List<Tema> getTema(){
        return temServ.getTemas();
    }
    
    
 @PutMapping("/tema/editar/{id_original}")
    public Tema editTema(@PathVariable long id_original,
                         @RequestParam(required = false, name = "id_tema") long idNueva,
                         @RequestParam(required = false, name = "nombre") String nuevoNombre,
                         @RequestParam(required = false, name = "descripcion") String descripcionNueva){
                           

        temServ.editTema(id_original, idNueva, nuevoNombre, descripcionNueva);
        
        return temServ.findTema(idNueva);
    }
    
 @PutMapping ("/tema/editar")
    public Tema editTema(@RequestBody Tema tem){
        temServ.editTema(tem);
        
        return this.findTema(tem.getId_tema());
    }
}

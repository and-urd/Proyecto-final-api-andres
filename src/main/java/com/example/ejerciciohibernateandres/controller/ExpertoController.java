package com.example.ejerciciohibernateandres.controller;

import com.example.ejerciciohibernateandres.model.Etiqueta;
import com.example.ejerciciohibernateandres.model.Experto;
import com.example.ejerciciohibernateandres.service.ExpertoService;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ExpertoController {

    private final ExpertoService expertoService;

    public ExpertoController(ExpertoService expertoService) {
        this.expertoService = expertoService;
    }

    // Crear Experto
    @PostMapping("/experto")
    public ResponseEntity<Experto> crearExperto(@RequestBody Experto experto){
        Experto expertoNuevo = expertoService.crearExperto(experto);
        if(expertoNuevo == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return ResponseEntity.ok().body(expertoNuevo);
        }
    }

    // Encontrar todas los expertos
//    @GetMapping("/expertos")
//    public ResponseEntity<List<Experto>> encontrarTodos(){
//        List<Experto> listaExpertos = expertoService.encontrarTodos();
//
//        if(listaExpertos.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }else{
//            return ResponseEntity.ok().body(listaExpertos);
//        }
//    }

    // Encontrar todos los expertos paginados
    @GetMapping("/expertos")
    public Page<Experto> encontrarTodosExpertosPaginacion(@PageableDefault(size=10, page=0) Pageable pageable){
        Page<Experto> listaExpertos = expertoService.encontrarTodos(pageable);
        if(listaExpertos.isEmpty()){
            return null;
        }else{
            return listaExpertos;
        }
    }



    // Encontrar un experto por su Id
    @GetMapping("/experto/{id}")
    public ResponseEntity<Optional<Experto>> encontrarUno(@PathVariable Long id){
        Optional<Experto> resultadoExperto = expertoService.encontrarExperto(id);

        if(resultadoExperto.isPresent()){
            return ResponseEntity.ok().body(resultadoExperto);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Borrar un experto
    @DeleteMapping("/experto/{id}")
    public ResponseEntity<Boolean> borrarExperto(@PathVariable Long id){

        Boolean resultado = expertoService.borrarExperto(id);

        if(resultado == true){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

//    // Actualizar un experto
//    @PutMapping("/experto")
//    public ResponseEntity<Experto> actualizarExperto(@RequestBody Experto experto){
//
//        // Cogemos el experto que se quiere actualizar
//        Optional<Experto> originalExperto = expertoService.encontrarExperto(experto.getId());
//
//        //COGEMOS sus etiquetas
//        List<Etiqueta> listaEtiquetas = originalExperto.get().getEtiquetas();
//
//        experto.setEtiquetas(listaEtiquetas);
//
//        Experto resultadoExperto = expertoService.actualizarExperto(experto);
//        if(resultadoExperto == null){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }else{
//            return ResponseEntity.ok().body(resultadoExperto);
//        }
//    }

    // Actualizar un experto por su Id
    @PutMapping("/experto/{id}")
    public ResponseEntity<Experto> actualizarExpertoPorId(@RequestBody Experto experto, @PathVariable Long id){
        experto.setId(id);

        Experto resultadoExperto = expertoService.actualizarExperto(experto);
        if(resultadoExperto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return ResponseEntity.ok().body(resultadoExperto);
        }
    }



}

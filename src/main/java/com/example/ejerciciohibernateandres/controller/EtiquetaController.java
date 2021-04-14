package com.example.ejerciciohibernateandres.controller;

import com.example.ejerciciohibernateandres.model.Etiqueta;
import com.example.ejerciciohibernateandres.service.EtiquetaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EtiquetaController {

    private final EtiquetaService etiquetaService;
    public EtiquetaController(EtiquetaService etiquetaService) {
        this.etiquetaService = etiquetaService;
    }


    // Encontrar todas las etiquetas
    @GetMapping("/etiquetas")
    public ResponseEntity<List<Etiqueta>> encontrarTodasEtiquetas(){
        List<Etiqueta> listaEtiquetas = etiquetaService.encontrarTodas();
        if(listaEtiquetas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body(listaEtiquetas);
        }
    }

    // Encuentra una etiqueta
    @GetMapping("/etiqueta/{id}")
    public ResponseEntity<Optional<Etiqueta>> encontrarEtiqueta(@PathVariable Long id){
        Optional<Etiqueta> resultado = etiquetaService.encontrarEtiqueta(id);
        if(resultado.isPresent()){
            return ResponseEntity.ok().body(resultado);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear un etiqueta
    @PostMapping("/etiqueta")
    public ResponseEntity<Etiqueta> crearEtiqueta(@RequestBody Etiqueta etiqueta){

        Etiqueta resultado = etiquetaService.crearEtiqueta(etiqueta);

         if(resultado == null){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         }else{
             return ResponseEntity.ok().body(resultado);
         }
    }

    // Actualiza etiqueta
    @PutMapping("/etiqueta")
    public ResponseEntity<Etiqueta> actualizaEtiqueta(@RequestBody Etiqueta etiqueta){
        Etiqueta resultado = etiquetaService.actualizarEtiqueta(etiqueta);
        if(etiquetaService == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return ResponseEntity.ok().body(resultado);
        }
    }

    // Borrar una etiqueta
    @DeleteMapping("/etiqueta/{id}")
    public ResponseEntity<Boolean> borrarEtiqueta(@PathVariable Long id){

        Boolean resultado = etiquetaService.borrarEtiqueta(id);
        if(resultado == true){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }






    // Crear una lista de etiquetas
    @PostMapping("/etiqueta/lista")
    public ResponseEntity<List<Etiqueta>> crearListEtiquetas(@RequestBody List<Etiqueta> etiquetas){

        List<Etiqueta> listaEtiquetas = etiquetaService.crearEtiquetas(etiquetas);

        if(listaEtiquetas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return ResponseEntity.ok().body(listaEtiquetas);
        }
    }


}

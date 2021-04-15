package com.example.ejerciciohibernateandres.controller;

import com.example.ejerciciohibernateandres.dao.EtiquetaDAO;
import com.example.ejerciciohibernateandres.model.Etiqueta;
import com.example.ejerciciohibernateandres.service.EtiquetaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EtiquetaController {

    private final EtiquetaService etiquetaService;
    private final EtiquetaDAO etiquetaDAO;
    public EtiquetaController(EtiquetaService etiquetaService, EtiquetaDAO etiquetaDAO) {
        this.etiquetaService = etiquetaService;
        this.etiquetaDAO = etiquetaDAO;
    }


    // Encontrar todas las etiquetas
//    @GetMapping("/etiquetas")
//    public ResponseEntity<List<Etiqueta>> encontrarTodasEtiquetas(){
//        List<Etiqueta> listaEtiquetas = etiquetaService.encontrarTodas();
//        if(listaEtiquetas.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }else{
//            return ResponseEntity.ok().body(listaEtiquetas);
//        }
//    }


    // Encontrar todas las etiquetas CON PAGINACION
    @GetMapping("/etiquetas")
    public Page<Etiqueta> encontrarTodasEtiquetasPaginacion(@PageableDefault(size=10, page=0) Pageable pageable){
        Page<Etiqueta> listaEtiquetas = etiquetaService.encontrarTodas(pageable);

        if(listaEtiquetas.isEmpty()){
            return null;
        }else{
            return listaEtiquetas;
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

    // Actualizar etiqueta por ID
    @PutMapping("/etiqueta/{id}")
    public ResponseEntity<Etiqueta> actualizaEtiquetaPorId(@RequestBody Etiqueta etiqueta, @PathVariable Long id){
        etiqueta.setId(id);
        Etiqueta resultado = etiquetaService.actualizarEtiqueta(etiqueta);
        if(resultado == null){
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

    // Recupera las etiquetas por su nombre
//    @GetMapping("/etiqueta/nombre/{nombre}")
//    public ResponseEntity<List<Etiqueta>> encontrarEtiquetaPorNombre(@PathVariable String nombre){
//        List<Etiqueta> listaEtiqueta = etiquetaDAO.encontrarPorNombre(nombre);
//        if(listaEtiqueta.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }else{
//            return ResponseEntity.ok().body(listaEtiqueta);
//        }
//    }

    // Filtrar por nombre
    @GetMapping("/etiqueta")
    public ResponseEntity<List<Etiqueta>> encontrarEtiquetaPorNombre(@RequestParam Map<String, String> parametros){
        String nombre = parametros.get("nombre");
        List<Etiqueta> listaEtiqueta = etiquetaDAO.encontrarPorNombre(nombre);
        if(listaEtiqueta.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body(listaEtiqueta);
        }
    }

}

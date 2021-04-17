package com.example.ejerciciohibernateandres.controller;


import com.example.ejerciciohibernateandres.model.Usuario;
import com.example.ejerciciohibernateandres.service.UsuarioService;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Login de usuario
    @PostMapping(value = "/usuario-login")
    public ResponseEntity<Map<String, String>> loginUsuario(@RequestBody Usuario usuario){
        Map<String, String> respuesta = usuarioService.loginUsuario(usuario);

        if(respuesta.containsKey("token")){
            return ResponseEntity.ok().body(respuesta);
        }else{
            return ResponseEntity.badRequest().body(respuesta);
        }
    }

    // Registro de usuario
    @PostMapping(value = "/usuario-registro")
    public ResponseEntity<Map<String, String>> registroUsuario(@RequestBody Usuario usuario){
        Map<String, String> respuesta = usuarioService.registroUsuario(usuario);

        if(respuesta.containsKey("token")){
            return ResponseEntity.ok().body(respuesta);
        }else{
            return ResponseEntity.badRequest().body(respuesta);
        }
    }










    // Encontrar un usuario
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Optional<Usuario>> encontrarUno(@PathVariable Long id){

        Optional<Usuario> userNuevo = usuarioService.encontrarUsuario(id);

        if(userNuevo.isPresent()){
            return ResponseEntity.ok().body(userNuevo);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

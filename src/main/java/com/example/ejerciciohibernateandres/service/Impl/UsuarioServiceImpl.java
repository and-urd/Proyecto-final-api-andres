package com.example.ejerciciohibernateandres.service.Impl;

import com.example.ejerciciohibernateandres.model.Usuario;
import com.example.ejerciciohibernateandres.repository.UsuarioRepository;
import com.example.ejerciciohibernateandres.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Map<String, String> loginUsuario(Usuario usuario) {
        Map<String, String> respuesta = new HashMap<>();
        if(usuario.getEmail().equals("admin") && usuario.getPassword().equals("admin")) {

            respuesta.put("token","QpwL5tke4Pnpja7X4");
            return respuesta;
        }else{
            respuesta.put("error","Missing password");
            return respuesta;
        }
    }

    @Override
    public Map<String, String> registroUsuario(Usuario usuario) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("id", "4");
        respuesta.put("token","QpwL5tke4Pnpja7X4");

        return respuesta;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public List<Usuario> encontrarTodos() {
        return null;
    }

    @Override
    public Optional<Usuario> encontrarUsuario(Long id) {
        return repository.findById(id);
    }
}

package com.example.ejerciciohibernateandres.service.Impl;

import com.example.ejerciciohibernateandres.model.Etiqueta;
import com.example.ejerciciohibernateandres.model.Experto;
import com.example.ejerciciohibernateandres.repository.ExpertoRepository;
import com.example.ejerciciohibernateandres.service.EtiquetaService;
import com.example.ejerciciohibernateandres.service.ExpertoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpertoServiceImpl implements ExpertoService {

    // Inyecto el repositorio de Experto y el servicio de Etiqueta
    private final ExpertoRepository expertoRepository;
    private final EtiquetaService etiquetaService;
    public ExpertoServiceImpl(ExpertoRepository expertoRepository, EtiquetaService etiquetaService) {
        this.expertoRepository = expertoRepository;
        this.etiquetaService = etiquetaService;
    }


    // Crea un experto
    @Override
    public Experto crearExperto(Experto experto) {
        Experto expertoNuevo = null;
        if(experto.getId() == null){
            return expertoRepository.save(experto);
        }else {
            return null;
        }
    }

    @Override
    public Experto actualizarExperto(Experto experto) {
        Experto expertoActualizado = null;
        if(experto.getId() != null && expertoRepository.existsById(experto.getId())){
            return expertoActualizado = expertoRepository.save(experto);
        }else{
            return null;
        }
    }

    // Recupero todos los expertos
    @Override
    public List<Experto> encontrarTodos() {
        return expertoRepository.findAll();
    }

    // Recupero un experto por su Id
    @Override
    public Optional<Experto> encontrarExperto(Long id) {
        return expertoRepository.findById(id);
    }

    // Borrar experto por su Id
    @Override
    public Boolean borrarExperto(Long id) {
        if(expertoRepository.existsById(id)){
            expertoRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
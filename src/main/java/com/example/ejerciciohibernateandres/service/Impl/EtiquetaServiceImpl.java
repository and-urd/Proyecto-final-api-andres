package com.example.ejerciciohibernateandres.service.Impl;

import com.example.ejerciciohibernateandres.model.Etiqueta;
import com.example.ejerciciohibernateandres.repository.EtiquetaRepository;
import com.example.ejerciciohibernateandres.service.EtiquetaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EtiquetaServiceImpl implements EtiquetaService {

    private final EtiquetaRepository etiquetaRepository;
    public EtiquetaServiceImpl(EtiquetaRepository etiquetaRepository) {
        this.etiquetaRepository = etiquetaRepository;
    }

    @Override
    public Etiqueta crearEtiqueta(Etiqueta etiqueta) {
        if(etiqueta.getId() == null){
            return etiquetaRepository.save(etiqueta);
        }else{
            return null;
        }
    }

    @Override
    public List<Etiqueta> crearEtiquetas(List<Etiqueta> etiquetas) {
        List<Etiqueta> resultado = null;

        if(etiquetas != null && !etiquetas.isEmpty()){
            for(Etiqueta etiqueta: etiquetas){
                if(etiqueta.getId() != null)
                    return new ArrayList<>();
            }
            resultado = etiquetaRepository.saveAll(etiquetas);
        }
        return resultado;
    }

    @Override
    public Etiqueta actualizarEtiqueta(Etiqueta etiqueta) {
        if(etiqueta.getId() != null && etiquetaRepository.existsById(etiqueta.getId())){
            return etiquetaRepository.save(etiqueta);
        }else{
            return null;
        }
    }

    @Override
    public List<Etiqueta> encontrarTodas() {
        return etiquetaRepository.findAll();
    }

    @Override
    public Optional<Etiqueta> encontrarEtiqueta(Long id) {
        return etiquetaRepository.findById(id);
    }
}

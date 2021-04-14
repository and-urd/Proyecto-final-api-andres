package com.example.ejerciciohibernateandres.service.Impl;

import com.example.ejerciciohibernateandres.model.Etiqueta;
import com.example.ejerciciohibernateandres.repository.EtiquetaRepository;
import com.example.ejerciciohibernateandres.service.EtiquetaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EtiquetaServiceImpl implements EtiquetaService {

    private final Logger log = LoggerFactory.getLogger (EtiquetaServiceImpl.class);


    private final EtiquetaRepository etiquetaRepository;
    public EtiquetaServiceImpl(EtiquetaRepository etiquetaRepository) {
        this.etiquetaRepository = etiquetaRepository;
    }

    // Crear una etiqueta
    @Override
    public Etiqueta crearEtiqueta(Etiqueta etiqueta) {
        if(etiqueta.getId() == null){
            return etiquetaRepository.save(etiqueta);
        }else{
            return null;
        }
    }

    // Crear una lista de etiquetas
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

    // Actualizar una etiqueta
    @Override
    public Etiqueta actualizarEtiqueta(Etiqueta etiqueta) {
        if(etiqueta.getId() != null && etiquetaRepository.existsById(etiqueta.getId())){
            return etiquetaRepository.save(etiqueta);
        }else{
            return null;
        }
    }

    // Encontrar todas las etiquetas
    @Override
    public List<Etiqueta> encontrarTodas() {
        return etiquetaRepository.findAll();
    }

    // Encontrar etiqueta por su id
    @Override
    public Optional<Etiqueta> encontrarEtiqueta(Long id) {
        return etiquetaRepository.findById(id);
    }

    // Borra etiqueta por su id
    @Override
    public Boolean borrarEtiqueta(Long id) {
        if(etiquetaRepository.existsById(id)){

            try{
                etiquetaRepository.deleteById(id);
            }catch (Exception ex){
                log.info("Error en el borrado");
                return false;
            }

            return true;
        }else{
            return false;
        }
    }
}

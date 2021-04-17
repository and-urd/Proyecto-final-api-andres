package com.example.ejerciciohibernateandres.dao.impl;

import com.example.ejerciciohibernateandres.dao.ExpertoDAO;
import com.example.ejerciciohibernateandres.model.Experto;
import com.example.ejerciciohibernateandres.service.ExpertoService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpertoDAOImpl implements ExpertoDAO {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private Session session;

    private final ExpertoService expertoService;
    public ExpertoDAOImpl(ExpertoService expertoService) {
        this.expertoService = expertoService;
    }

    @Override
    public List<Experto> encontrarConFiltros(String nombre, Integer etiqueta, String modalidad, String estado) {

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Experto> criteria = builder.createQuery(Experto.class);
        Root<Experto> root = criteria.from(Experto.class);

//        criteria.select(root).where(builder.like(root.get("nombre"), nombre+"%"));
        Predicate contieneNombre = builder.like(root.get("nombre"), nombre+"%");
        Predicate contieneModalidad = builder.like(root.get("modalidad"), modalidad+"%");
        Predicate contieneEstado = builder.like(root.get("estado"), estado+"%");


        List<Experto> listaResultado = new ArrayList<>();
        for (Experto experto :
                session.createQuery(criteria.where(builder.and(contieneNombre, contieneModalidad, contieneEstado))).getResultList()) {
            listaResultado.add(expertoService.encontrarExperto(experto.getId()).get());
        }




        return listaResultado;
    }
}

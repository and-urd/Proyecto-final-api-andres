package com.example.ejerciciohibernateandres.dao;

import com.example.ejerciciohibernateandres.model.Experto;

import java.util.List;

public interface ExpertoDAO {

    List<Experto> encontrarConFiltros(String nombre, Long etiqueta, String modalidad, String estado);

}
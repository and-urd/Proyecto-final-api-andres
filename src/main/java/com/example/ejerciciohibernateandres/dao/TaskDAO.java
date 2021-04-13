package com.example.ejerciciohibernateandres.dao;

import com.example.ejerciciohibernateandres.model.Task;

import java.util.List;

public interface TaskDAO {

    List<Task> findAllTagsByTitulo(String titulo);
}

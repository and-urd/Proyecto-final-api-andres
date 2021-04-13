package com.example.ejerciciohibernateandres.dao;

import com.example.ejerciciohibernateandres.model.User;

public interface UserDAO {

    User findByDni(String  dni);
}

package com.example.ejerciciohibernateandres.repository;

import com.example.ejerciciohibernateandres.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}

package com.example.ejerciciohibernateandres.dao;

import com.example.ejerciciohibernateandres.model.Tag;
import com.example.ejerciciohibernateandres.model.TagColor;

import java.util.List;

public interface TagDAO {

    List<Tag> findByColorTag(TagColor tagColor);

}

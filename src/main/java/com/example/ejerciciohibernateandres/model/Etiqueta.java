package com.example.ejerciciohibernateandres.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="etiquetas")
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "etiquetas", fetch = FetchType.EAGER)
    private List<Experto> expertos = new ArrayList<>();
}

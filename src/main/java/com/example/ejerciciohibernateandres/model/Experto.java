package com.example.ejerciciohibernateandres.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="expertos")
public class Experto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String telefono;

    private String email;

    @ManyToMany
    @JoinTable(
            name="experto_etiqueta",
            joinColumns = {@JoinColumn(name="experto_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="etiqueta_id", referencedColumnName = "id")}
    )
    private List<Etiqueta> etiquetas = new ArrayList<>();

}

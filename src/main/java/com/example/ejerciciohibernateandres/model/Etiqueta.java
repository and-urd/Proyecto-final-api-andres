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


    // constructores
    public Etiqueta() {
    }

    public Etiqueta(String nombre) {
        this.nombre = nombre;
    }

    // Getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Experto> getExpertos() {
        return expertos;
    }

    public void setExpertos(List<Experto> expertos) {
        this.expertos = expertos;
    }

    // método toString

    @Override
    public String toString() {
        return "Etiqueta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", num_expertos=" + expertos.size() +
                '}';
    }
}

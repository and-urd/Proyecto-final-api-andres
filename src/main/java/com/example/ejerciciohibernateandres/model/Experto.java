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


    // constructores
    public Experto() {
    }
    public Experto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    // método toString

    @Override
    public String toString() {
        return "Experto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", num_etiquetas=" + etiquetas.size() +
                '}';
    }
}

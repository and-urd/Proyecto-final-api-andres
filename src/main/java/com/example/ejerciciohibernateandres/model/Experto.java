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

    private String modalidad;

    private String estado;

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
    public Experto(String nombre, String telefono, String email, String modalidad, String estado, List<Etiqueta> etiquetas) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.modalidad = modalidad;
        this.estado = estado;
        this.etiquetas = etiquetas;
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

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
                ", modalidad='" + modalidad + '\'' +
                ", estado='" + estado + '\'' +
                ", num_etiquetas=" + etiquetas.size() +
                '}';
    }
}

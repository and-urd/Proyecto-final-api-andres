package com.example.ejerciciohibernateandres.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descripcion;


    @Type(type="yes_no")
    @Column(name = "esta_finalizada")
    private Boolean estaFinalizada;

    @Column(name="fecha_entrega")
    private LocalDate fechaEntrega;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="task_tag",
            joinColumns = {@JoinColumn(name="id_task", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="id_tag",referencedColumnName = "id")}
    )
    private List<Tag> tags = new ArrayList<>();

    @OneToMany
    @JoinTable(
            name="user_task",
            joinColumns={@JoinColumn(name="id_user", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="id_task", referencedColumnName = "id")}
    )
    private List<User> users = new ArrayList<>();

    // Constructores

    public Task() {
    }

    public Task(String titulo, String descripcion, Boolean estaFinalizada, LocalDate fechaEntrega, List<Tag> tags) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estaFinalizada = estaFinalizada;
        this.fechaEntrega = fechaEntrega;
        this.tags = tags;
    }

    // Getter y Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstaFinalizada() {
        return estaFinalizada;
    }

    public void setEstaFinalizada(Boolean estaFinalizada) {
        this.estaFinalizada = estaFinalizada;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    // método toString

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estaFinalizada=" + estaFinalizada +
                ", fechaEntrega=" + fechaEntrega +
                ", num_tags=" + tags.size() +
                '}';
    }
}

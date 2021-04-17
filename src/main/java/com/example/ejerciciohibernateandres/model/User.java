//package com.example.ejerciciohibernateandres.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.hibernate.annotations.Type;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name="users")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String nombre;
//
//    private String apellido;
//
//    private String dni;
//
//    @Type(type="yes_no")
//    @Column(name="esta_activo")
//    private Boolean estaActivo;
//
//    @Column(name = "fecha_nacimiento")
//    private LocalDate fechaNaciento;
//
//    @OneToOne
//    @JoinColumn(name="id_billinginfo")
//    @JsonIgnoreProperties("user")
//    private BillingInfo billingInfo;
//
//    // Constructores
//
//    public User() {
//    }
//
//    public User(String nombre, String apellido, String dni, Boolean estaActivo, LocalDate fechaNaciento, BillingInfo billingInfo, List<Task> tasks) {
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.dni = dni;
//        this.estaActivo = estaActivo;
//        this.fechaNaciento = fechaNaciento;
//        this.billingInfo = billingInfo;
//    }
//
//    // Getter y Setter
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String getApellido() {
//        return apellido;
//    }
//
//    public void setApellido(String apellido) {
//        this.apellido = apellido;
//    }
//
//    public String getDni() {
//        return dni;
//    }
//
//    public void setDni(String dni) {
//        this.dni = dni;
//    }
//
//    public Boolean getEstaActivo() {
//        return estaActivo;
//    }
//
//    public void setEstaActivo(Boolean estaActivo) {
//        this.estaActivo = estaActivo;
//    }
//
//    public LocalDate getFechaNaciento() {
//        return fechaNaciento;
//    }
//
//    public void setFechaNaciento(LocalDate fechaNaciento) {
//        this.fechaNaciento = fechaNaciento;
//    }
//
//    public BillingInfo getBillingInfo() {
//        return billingInfo;
//    }
//
//    public void setBillingInfo(BillingInfo billingInfo) {
//        this.billingInfo = billingInfo;
//    }
//
//    // método toString
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", nombre='" + nombre + '\'' +
//                ", apellido='" + apellido + '\'' +
//                ", dni='" + dni + '\'' +
//                ", estaActivo=" + estaActivo +
//                ", fechaNaciento=" + fechaNaciento +
//                ", billingInfo=" + billingInfo +
//                '}';
//    }
//}

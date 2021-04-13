package com.example.ejerciciohibernateandres.model;

import javax.persistence.*;

@Entity
@Table(name="billing_info")
public class BillingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String producto;

    private Double precio;

    @OneToOne(mappedBy = "billingInfo")
    private User user;

    // Constructores

    public BillingInfo() {
    }

    public BillingInfo(String producto, Double precio, User user) {
        this.producto = producto;
        this.precio = precio;
        this.user = user;
    }

    // Getter y Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // método toString

    @Override
    public String toString() {
        return "BillingInfo{" +
                "id=" + id +
                ", producto='" + producto + '\'' +
                ", precio=" + precio +
                '}';
    }
}

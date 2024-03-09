package com.Proyecto.CrudGestionProductos.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
@Data
@Entity
@Table(name = "productos")
public class Producto {
    
    public Producto() {
    }

    public Producto(long id, String name, String brand, String supplier, Date fechaElb, float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.supplier = supplier;
        this.fechaElb = fechaElb;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false, length = 40)
    private String brand;

    @Column(nullable = false, length = 40)
    private String supplier;

    @Temporal(TemporalType.DATE)
    private Date fechaElb;

    @Column()
    private float price;

}

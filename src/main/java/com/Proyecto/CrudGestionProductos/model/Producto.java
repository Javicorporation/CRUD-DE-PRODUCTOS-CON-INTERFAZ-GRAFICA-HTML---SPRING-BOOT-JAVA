package com.Proyecto.CrudGestionProductos.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    @Column(name = "nombre",nullable = false, length = 40)
    private String name;

    @Column(name = "marca",nullable = false, length = 40)
    private String brand;

    @Column(name = "proveedor", nullable = false, length = 40)
    private String supplier;

    @Column(name = "fechaElaboracion")
    private Date fechaElb;

    @Column(name = "precio")
    private float price;

}

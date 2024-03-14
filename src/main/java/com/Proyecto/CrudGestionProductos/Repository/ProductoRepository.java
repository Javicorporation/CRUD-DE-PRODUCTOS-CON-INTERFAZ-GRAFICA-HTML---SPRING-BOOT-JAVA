package com.Proyecto.CrudGestionProductos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyecto.CrudGestionProductos.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    List<Producto> buscarProducto(String name, String brand, String supplier);

}

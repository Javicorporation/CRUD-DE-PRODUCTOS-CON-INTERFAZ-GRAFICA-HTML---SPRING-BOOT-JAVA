package com.Proyecto.CrudGestionProductos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Proyecto.CrudGestionProductos.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    @Query("SELECT p FROM Producto p WHERE p.nombreProducto LIKE %:nombre% AND p.marca LIKE %:marca% AND p.proveedor LIKE %:proveedor%")
    List<Producto> findByNombreContainingAndMarcaContainingAndProveedorContaining(String name, String brand, String supplier);

}

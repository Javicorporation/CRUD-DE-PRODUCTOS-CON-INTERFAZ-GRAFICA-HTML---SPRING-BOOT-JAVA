package com.Proyecto.CrudGestionProductos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Proyecto.CrudGestionProductos.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    @Query("SELECT p FROM Producto p WHERE"
            + " CONCAT (p.id, p.name, p.brand, p.supplier)"
            + " LIKE %?1%")
    List<Producto> findAll(String Queery);

}

package com.Proyecto.CrudGestionProductos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyecto.CrudGestionProductos.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}

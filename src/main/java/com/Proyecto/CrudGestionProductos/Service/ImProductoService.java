package com.Proyecto.CrudGestionProductos.Service;

import java.util.List;

import com.Proyecto.CrudGestionProductos.model.Producto;

public interface ImProductoService {

    List<Producto> getListAll();

    Producto findByIdPro(long id);

    Producto save(Producto producto);

    void delete(long id);

    Producto update(long id, Producto productoUpdate);

    List<Producto> findByNombreContainingAndMarcaContainingAndProveedorContaining(String name, String brand, String supplier);

}
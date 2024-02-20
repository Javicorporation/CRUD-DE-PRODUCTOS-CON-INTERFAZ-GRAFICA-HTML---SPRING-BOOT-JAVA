package com.Proyecto.CrudGestionProductos.Service;

import java.util.List;

import com.Proyecto.CrudGestionProductos.model.Producto;

public interface ImpProductoService {

    List<Producto> getAll();

    Producto findByIdPro(long id);

    Producto save(Producto producto);

    void delete(long id);

    Producto update(long id, Producto productoUpdate);

}